/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.LinkedList;

/**
 *
 * @author Acer
 */
public class UndirectedGraphAdjacencyListImplementation {
    
    static class Graph{
        int v;   //Number of vertices
        int e;   //Number of edges
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
        Graph graph = new Graph(4);
        
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);      //   0--1
        graph.addEdge(2, 3);      //   |  |
        graph.addEdge(3, 0);      //   3--2
        
        System.out.println(graph.toString());
    }
     
}
