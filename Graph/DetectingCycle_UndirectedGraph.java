/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

/**
 *
 * @author User
 */
public class DetectingCycle_UndirectedGraph {    
    public boolean detectCycle(int[][] graph){
        int n = graph.length;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++){
            if(!visited[i]){
                if(dfs(i, -1, visited, graph)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Appplying DFS
    public boolean dfs(int node, int parent, boolean[] visited, int[][] graph){
        visited[node] = true;
        
        for (int adj : graph[node]) {
            //If current node is visited but this is not the parent(previous) node then this is cycle
            if(visited[adj]){
                if(adj != parent){
                    return true;
                }
            }
            else{
                if(dfs(adj, node, visited, graph)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        DetectingCycle_UndirectedGraph dt = new DetectingCycle_UndirectedGraph();
        int[][] graph1 = {{1},{0, 2},{1}}; //Not a cycle
        int[][] graph2 = {{1,2},{0,2},{0,1}}; //Cycle
        System.out.println(dt.detectCycle(graph2));
    }   
}
