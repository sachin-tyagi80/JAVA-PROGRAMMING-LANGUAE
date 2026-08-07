import java.util.*;
public class PathGraph {
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
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]){
      vis[curr] = true;  //visited the current vertex  // 0(V+E)
      System.out.print(curr + " ");
      for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.dest]){
          dfs(graph,e.dest,vis);
        }
      }
    }

    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){
      if(src == dest){
        return true;
      }
      vis[src] = true;  //visited the current vertex  // 0(V+E)
      for(int i=0;i<graph[src].size();i++){
        Edge e = graph[src].get(i);
        if(!vis[e.dest]){
          if(hasPath(graph,e.dest,dest,vis)){
            return true;
          }
        }
      }
      return false;
    }


    
    public static void main(String[] args) {
      int n = 7; // number of vertices
      ArrayList<Edge> graph[] = new ArrayList[n]; // null -> empty arraylist 
      for(int i=0;i<n;i++){
        graph[i] = new ArrayList<>();
      }
  
      // adding edges
      // 0-vertex 
      graph[0].add(new Edge(0,1,1));
      graph[0].add(new Edge(0,2,1));

      
      // 1-vertex
      graph[1].add(new Edge(1,0,1));
      graph[1].add(new Edge(1,3,1));
      //2-vertex
      graph[2].add(new Edge(2,0,1));
      graph[2].add(new Edge(2,4,1));
  
      //3-vertex
      graph[3].add(new Edge(3,1,1));
      graph[3].add(new Edge(3,4,1));
      graph[3].add(new Edge(3,5,1));
      //4-vertex
      graph[4].add(new Edge(4,2,1));
      graph[4].add(new Edge(4,3,1));
      graph[4].add(new Edge(4,5,1));

      //5-vertex
      graph[5].add(new Edge(5,3,1));
      graph[5].add(new Edge(5,4,1));
      graph[5].add(new Edge(5,6,1));
      //6-vertex
      graph[6].add(new Edge(6,5,1));  
  
     dfs(graph,0,new boolean[n]); // source vertex = 0
    
     System.out.println(hasPath(graph,0,5,new boolean[n])); // true
    };
  
};
