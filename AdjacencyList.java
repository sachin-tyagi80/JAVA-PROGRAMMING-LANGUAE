import java.util.*;
public class AdjacencyList {
  static class Edge{
    int src;
    int dest;
    int weight;

    public Edge(int s, int d, int w){
      this.src = s;
      this.dest = d;
      this.weight = w;
    }
  }
  public static void main(String[] args) {
    int n = 5; // number of vertices
    ArrayList<Edge> graph[] = new ArrayList[n]; // null -> empty arraylist 
    for(int i=0;i<n;i++){
      graph[i] = new ArrayList<>();
    }

    // adding edges
    graph[0].add(new Edge(0,1,5));
    graph[0].add(new Edge(0,2,3));
    graph[1].add(new Edge(1,3,8));
    graph[2].add(new Edge(2,3,7));
    graph[3].add(new Edge(3,4,2));

    // printing the adjacency list
    for(int i=0;i<n;i++){
      System.out.print("Vertex " + i + " is connected to: ");
      for(Edge e : graph[i]){
        System.out.print("(" + e.dest + ", weight: " + e.weight + ") ");
      }
      System.out.println();
    }
  }
  
}
