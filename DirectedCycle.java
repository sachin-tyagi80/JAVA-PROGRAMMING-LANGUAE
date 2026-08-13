import java.util.*;

public class DirectedCycle {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create Directed Graph
    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -> 1
        graph[0].add(new Edge(0, 1));

        // 1 -> 2
        graph[1].add(new Edge(1, 2));

        // 2 -> 3
        graph[2].add(new Edge(2, 3));

        // 3 -> 1
        // Cycle: 1 -> 2 -> 3 -> 1
        graph[3].add(new Edge(3, 1));
    }

    // Cycle Detection
    public static boolean isCycle(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        // Current DFS path
        boolean recStack[] = new boolean[graph.length];

        // For disconnected graph
        for (int i = 0; i < graph.length; i++) {

            if (!vis[i]) {

                if (isCycleUtil(graph, i, vis, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    // DFS Utility
    public static boolean isCycleUtil(
            ArrayList<Edge>[] graph,
            int curr,
            boolean vis[],
            boolean recStack[]) {

        // Mark current vertex visited
        vis[curr] = true;

        // Current vertex is in recursion stack
        recStack[curr] = true;

        // Visit all neighbours
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            // Case 1: Neighbour is not visited
            if (!vis[e.dest]) {

                if (isCycleUtil(
                        graph,
                        e.dest,
                        vis,
                        recStack)) {

                    return true;
                }
            }

            // Case 2: Neighbour is already in current DFS path
            else if (recStack[e.dest]) {

                return true;
            }
        }

        // Current vertex is no longer in current DFS path
        recStack[curr] = false;

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(isCycle(graph));
    }
}