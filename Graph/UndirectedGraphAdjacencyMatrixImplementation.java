/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Acer
 */
public class UndirectedGraphAdjacencyMatrixImplementation {
    
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
            matrix[r][c] = 1;
            matrix[c][r] = 1;
            e++;
        }
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Vertices : "+v+", Edges: "+e+"\n");
            for (int i = 0; i < v; i++) {
                sb.append(i+" : ");
                for (int j : matrix[i]) {
                    sb.append(j+" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Graph gp = new Graph(4);
        gp.addEdge(0, 1);
        gp.addEdge(1, 2);
        gp.addEdge(2, 3);
        gp.addEdge(3, 0);
        System.out.println(gp.toString());
    }
    
}
