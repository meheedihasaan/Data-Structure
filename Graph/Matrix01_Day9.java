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
public class Matrix01_Day9 {
    public int[][] updateMatrix(int[][] mat) {
        class Pair{
            int row;
            int col;
            Pair(int row, int col){
                this.row = row;
                this.col = col;
            }
        }
        
        int n = mat.length;
        int m = mat[0].length;
        
        int ans[][] = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Pair(i, j));
                    ans[i][j] = 0;
                }
                else{
                    ans[i][j] = -1;
                }
            }
        }
        
        //BFS
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int i = temp.row;
            int j = temp.col;
            
            //If 4 diagnal neighbouring cells of current cell is valid and not visited yet then update the distance.
            if(isValid(i, j+1, n, m) && ans[i][j+1] == -1){
                queue.offer(new Pair(i, j+1));
                ans[i][j+1] = ans[i][j]+1;
            }
            
            if(isValid(i, j-1, n, m) && ans[i][j-1] == -1){
                queue.offer(new Pair(i, j-1));
                ans[i][j-1] = ans[i][j]+1;
            }
            
            if(isValid(i+1, j, n, m) && ans[i+1][j] == -1){
                queue.offer(new Pair(i+1, j));
                ans[i+1][j] = ans[i][j]+1;
            }
            
            if(isValid(i-1, j, n, m) && ans[i-1][j] == -1){
                queue.offer(new Pair(i-1, j));
                ans[i-1][j] = ans[i][j]+1;
            }            
        }
        return ans;
    }
    
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
}
