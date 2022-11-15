/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Acer
 */
public class BFS_Traversal_Matrix {
    
    static class Graph{
        int v;  //Number of Vertices
        int e;  //Number of Edges
        int matrix[][];
        Graph(int node){
            this.v = node;
            this.e = 0;
            matrix = new int[node][node];
        }
        
        public void addEdge(int r, int c){
            matrix[r][c] = c;
            matrix[c][r] = r;
            e++;
        }
        
        public List<Integer> bfsTraversal(int start){
            List<Integer> ans = new ArrayList<>();
            boolean visited[] = new boolean[v];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;
            while(!queue.isEmpty()){
                int temp = queue.poll();
                ans.add(temp);
                for (int i : matrix[temp]) {
                    if(!visited[i]){
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
            return ans;
        }
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Vertices: "+v+",   Edges: "+e+"\n");
            for (int i = 0; i < v; i++) {
                sb.append(i+": ");
                for (int n : matrix[i]) {
                    sb.append(n+" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);   //  0--1
        graph.addEdge(2, 3);   //  |  |
        graph.addEdge(2, 4);   //  3--2--4
        graph.addEdge(3, 0);        
        
        System.out.println(graph.toString());
        System.out.println();
        
        System.out.println("BFS Traversal: ");
        System.out.println(graph.bfsTraversal(0));
    }
    
}
