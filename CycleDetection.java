import java.util.ArrayList;

public class CycleDetection {
  static class Edge{
    int src;
    int dest;

    public Edge(int s, int d){
      this.src = s;
      this.dest = d;
    }
  }
  static void createGraph(ArrayList<Edge> graph[]){
    for(int i=0;i<graph.length;i++){
      graph[i] = new ArrayList<>();
    }
    // adding edges
    // 0-vertex 
    graph[0].add(new Edge(0,1));
    graph[0].add(new Edge(0,2));
    graph[0].add(new Edge(0,3));

    
    // 1-vertex
    graph[1].add(new Edge(1,0));
    graph[1].add(new Edge(1,2));
    //2-vertex
    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));

    //3-vertex
    graph[3].add(new Edge(3,0));
    graph[3].add(new Edge(3,4));
    //4-vertex
    graph[4].add(new Edge(4,3));
    

  }
  public static boolean detectCycle(ArrayList<Edge> graph[]){
    boolean vis[] = new boolean[graph.length];
    for(int i=0;i<graph.length;i++){ // for every components check if cycle exists or not
      if(!vis[i]){
        if(detectCycleUtil(graph,i,vis,-1)){
          return true; // cycle exists in one of the parts of the graph
        }
      }
    }
    return false; // cycle doesn't exist in any part of the graph
  }
  public static boolean detectCycleUtil(ArrayList<Edge> graph[],int curr,boolean vis[],int parent){
    vis[curr] = true;
    for(int i=0;i<graph[curr].size();i++){ //for every neighbor of the current vertex
      Edge e = graph[curr].get(i);
      if(!vis[e.dest]){  // case 3 
        if(detectCycleUtil(graph,e.dest,vis,curr)){
          return true;
        }
      }else if(vis[e.dest] && e.dest != parent){ // case 1 
        return true;
      }
      // case 2 -> do nothing --> continue to next edge
    }
    return false;
  }
  public static void main(String[] args) {
    int v = 5;
    ArrayList<Edge> graph[] = new ArrayList[v];
    createGraph(graph);
    System.out.println(detectCycle(graph));
  }


  
}



// "I am using DFS to detect a cycle in an undirected graph. I maintain a visited array and also keep track of the
// parent of every current node. If I find an unvisited neighbor, I recursively visit it. If I find a visited 
// neighbor that is not the parent, then there is a cycle. The outer loop is used because the graph can be 
// disconnected, so we need to check every component."