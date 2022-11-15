/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class DFS_Traversal_Recursive {
    
    static class Graph{
        int v;   //Number of Vertices
        int e;   //Number of Edges
        LinkedList<Integer>[] adj;
        Graph(int node){
            this.v = node;
            this.e = 0;
            adj = new LinkedList[node];
            for (int i = 0; i < node; i++) {
                adj[i] = new LinkedList();
            }
        }
        
        public void addEdge(int u, int v){
            adj[u].add(v);
            adj[v].add(u);
            e++;
        }
        
        public List<Integer> dfsTraversal(int start){
            List<Integer> ans = new ArrayList<>();
            boolean visited[] = new boolean[v];
            for (int i = 0; i < v; i++) {
                if(!visited[i]){
                    dfs(i, visited, ans);
                }
            }
            return ans;
        }
        
        public void dfs(int n, boolean visited[], List<Integer> ans){
            ans.add(n);
            visited[n] = true;
            for (int m : adj[n]) {
                if(!visited[m]){
                    dfs(m, visited, ans);
                }
            }
        }
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Vertices: "+v+",   Edges: "+e+"\n");
            for (int i = 0; i < v; i++) {
                sb.append(i+": ");
                for (int n : adj[i]) {
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
        System.out.println(graph.dfsTraversal(0));
    }
    
}
