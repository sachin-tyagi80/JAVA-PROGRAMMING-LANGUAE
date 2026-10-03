import java.util.*;

class DijkstraShortest {

    // Edge class
    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Pair class for PriorityQueue
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    // Create graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -> 1 = 4
        graph[0].add(new Edge(1, 4));

        // 0 -> 2 = 1
        graph[0].add(new Edge(2, 1));

        // 2 -> 1 = 2
        graph[2].add(new Edge(1, 2));

        // 1 -> 3 = 1
        graph[1].add(new Edge(3, 1));

        // 2 -> 3 = 5
        graph[2].add(new Edge(3, 5));

        // 3 -> 4 = 3
        graph[3].add(new Edge(4, 3));
    }

    // Dijkstra Algorithm
    static void dijkstra(ArrayList<Edge>[] graph, int src) {

        int V = graph.length;

        // Distance array
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source distance = 0
        dist[src] = 0;

        // Priority Queue
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a.dist, b.dist));

        // Source add
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            int u = curr.node;

            // Check all neighbours
            for (Edge e : graph[u]) {

                int v = e.dest;
                int wt = e.weight;

                // Relaxation
                if (dist[v] > dist[u] + wt) {

                    dist[v] = dist[u] + wt;

                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // Print shortest distance
        System.out.println("Shortest distances from source " + src + ":");

        for (int i = 0; i < V; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int V = 5;

        // Graph create
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        // Source
        int src = 0;

        // Dijkstra
        dijkstra(graph, src);
    }
}