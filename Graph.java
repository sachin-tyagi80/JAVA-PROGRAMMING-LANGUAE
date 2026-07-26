import java.util.*;
public class Graph {
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
    public static void bfs(ArrayList<Edge> graph[],int v){
      Queue<Integer> q = new LinkedList<>();
      boolean vis[] = new boolean[v];
      q.add(0); // source vertex = 0
      while(!q.isEmpty()){
        int curr = q.remove();
        if(!vis[curr]){ // if the current vertex is not visited
          System.out.print(curr + " ");
          vis[curr] = true;
          for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            q.add(e.dest);
          }
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
  
     bfs(graph,n);
    }
  
}


// 30-Second Interview Explanation
// "This code implements Breadth First Search (BFS) using an adjacency list. It starts from vertex 0, uses a queue to visit nodes level by level, 
// and a visited array to ensure each vertex is processed only once. For every dequeued vertex, it visits all its neighbours and enqueues the unvisited ones. 
// The time complexity is O(V + E) and the space complexity is O(V)."
////////////////////////////////////////////////////////////////////////////////////
// Interview Follow-up Questions
// Q1. Why do we use a Queue?
// Answer
// BFS explores nodes level by level, so it follows the FIFO (First In, First Out) principle. A Queue naturally supports FIFO order.
  
// Q2. Why do we use a Visited array?
// Answer
// To avoid visiting the same vertex multiple times and to prevent infinite loops in graphs containing cycles.

// Q3. Why Adjacency List instead of Matrix?
// Answer
// Adjacency List uses O(V + E) space and is more efficient for sparse graphs. Most graph algorithms such as BFS and DFS use it.

// Q4. Can BFS work without a visited array?
// Answer
// It works only for trees. In general graphs with cycles, a visited array is required; otherwise, the algorithm may revisit nodes indefinitely.

// Q5. Why is the complexity O(V + E)?
// Answer
// Every vertex is visited at most once, and every edge is examined at most once, so the total time complexity is O(V + E).

// Q6. What are the applications of BFS?
// Shortest Path in an Unweighted Graph
// Level Order Traversal of Trees
// Social Network Analysis
// Web Crawling
// Connected Components
// Network Broadcasting
