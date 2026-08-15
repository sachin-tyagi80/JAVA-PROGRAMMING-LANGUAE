import java.util.*;

public class TopologicalSortDFS {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // DFS function
    public static void dfs(
            ArrayList<Edge>[] graph,
            int curr,
            boolean[] vis,
            Stack<Integer> stack) {

        // Current vertex visited
        vis[curr] = true;

        // Visit all neighbours
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis, stack);
            }
        }

        // IMPORTANT:
        // Add vertex after visiting all neighbours
        stack.push(curr);
    }

    public static void topologicalSort(
            ArrayList<Edge>[] graph) {

        boolean[] vis = new boolean[graph.length];

        Stack<Integer> stack = new Stack<>();

        // Graph can be disconnected
        for (int i = 0; i < graph.length; i++) {

            if (!vis[i]) {
                dfs(graph, i, vis, stack);
            }
        }

        // Print topological order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 1 -> 3
        graph[1].add(new Edge(1, 3));

        // 2 -> 3
        graph[2].add(new Edge(2, 3));

        // 4 -> 1
        graph[4].add(new Edge(4, 1));

        // 4 -> 0
        graph[4].add(new Edge(4, 0));

        // 5 -> 0
        graph[5].add(new Edge(5, 0));

        // 5 -> 2
        graph[5].add(new Edge(5, 2));

        topologicalSort(graph);
    }
}


/////////////////////////////////////////////
// 🎤 Interview mein kaise explain karna hai?

// "I use DFS for topological sorting. I visit every unvisited vertex and recursively visit all its neighbours. After all neighbours are processed, I push the current vertex into a stack. Finally, I pop all vertices from the stack to get the topological order."

// Complexity
// Time  = O(V + E)
// Space = O(V)