import java.util.*;
public class GraphDfs {
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
    }
  
}


// 30-Second Interview Explanation
// "This code implements Depth First Search (DFS) using recursion and an adjacency list. Starting from the source vertex, it marks the current vertex as visited, 
// prints it, and recursively visits each unvisited neighbour. DFS explores one path completely before backtracking to explore other paths. 
// The time complexity is O(V + E), and the space complexity is O(V) due to the visited array and recursion stack."

// Why Recursion?
// English
// DFS follows one path completely before returning to explore another path.
// Recursion automatically uses the call stack.


// Interview Follow-up Questions
// Q1. Why do we use a visited array?
// Answer
// To avoid visiting the same vertex multiple times and to prevent infinite recursion in graphs containing cycles.
  
// Q2. Why does DFS use recursion?
// Answer
// DFS explores one path as deep as possible before backtracking. Recursion naturally manages this behaviour using the call stack.

// Q3. Can DFS be implemented without recursion?
// Answer
// Yes. DFS can also be implemented iteratively using an explicit Stack.

// Q4. Why is the complexity O(V + E)?
// Answer
// Every vertex is visited once, and every edge is explored once.

// Q5. What is backtracking?
// Answer
// When a vertex has no unvisited neighbours, DFS returns to the previous recursive call to continue exploring other paths.

// Q6. What are the applications of DFS?
// Cycle Detection
// Topological Sort
// Connected Components
// Path Finding
// Maze Solving
// Strongly Connected Components
// Bridge and Articulation Point algorithms
