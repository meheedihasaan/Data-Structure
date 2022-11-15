/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Acer
 */
public class RottenOrange_Day9 {
    
    public int rottingOranges(int grid[][]){
        //Custom Pair class for storing cell to Queue
        class Pair{
            int row;
            int col;
            Pair(int row, int col){
                this.row = row;
                this.col = col;
            }
        }
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i, j));  //Storing cell which has rotten orange
                }
                else if(grid[i][j] == 1){
                    cnt++; //Storing number of fresh orange
                }
            }
        }
        
        //Applying BFS
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Pair temp = queue.poll();
                int row = temp.row;
                int col = temp.col;
                
                //If diagnal cell is valid and has a fresh orange then set it rotten and set flag as true
                if(isValid(row, col+1, n, m) && grid[row][col+1] == 1){
                    flag = true;
                    grid[row][col+1] = 2;
                    queue.offer(new Pair(row, col+1));
                    cnt--;
                }
                
                if(isValid(row, col-1, n, m) && grid[row][col-1] == 1){
                    flag = true;
                    grid[row][col-1] = 2;
                    queue.offer(new Pair(row, col-1));
                    cnt--;
                }
                
                if(isValid(row+1, col, n, m) && grid[row+1][col] == 1){
                    flag = true;
                    grid[row+1][col] = 2;
                    queue.offer(new Pair(row+1, col));
                    cnt--;
                }
                
                if(isValid(row-1, col, n, m) && grid[row-1][col] == 1){
                    flag = true;
                    grid[row-1][col] = 2;
                    queue.offer(new Pair(row-1, col));
                    cnt--;
                }
            }
            //If any of fresh orange become rotten
            if(flag){
                ans++;
            }
        }
        //If there is no fresh orange left then simply return ans otherwise return -1
        if(cnt == 0){
            return ans;
        }
        return -1;
    }
    
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m){
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        RottenOrange_Day9 r = new RottenOrange_Day9();
        
        int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = r.rottingOranges(grid);
        System.out.println(ans);
    }
    
}
