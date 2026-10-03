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


////////////////////////////////////////////////////////////////////////////////////////////////
// 1. Interview me Dijkstra kaise explain karein?

// Interviewer: What is Dijkstra's Algorithm?

// You:

// Dijkstra's Algorithm is a shortest path algorithm used to find the minimum distance from a source vertex to all other vertices in a weighted graph.

// It works when all edge weights are non-negative.

// I use a PriorityQueue so that I can always process the vertex having the smallest current distance.

// Initially, the source distance is 0 and all other distances are infinity.

// Then I repeatedly take the node with the minimum distance and try to improve the distance of its neighbours. This process is called relaxation.

// If I find a shorter distance through the current node, I update the distance and add the neighbour to the PriorityQueue.

// Finally, the distance array contains the shortest distance from the source to every vertex.

// 2. Relaxation kya hota hai?

// Interviewer ye almost certainly pooch sakta hai.

// Suppose:

// 0 → 1 = 4
// 0 → 2 = 1
// 2 → 1 = 2

// Initially:

// dist[0] = 0
// dist[1] = 4
// dist[2] = 1

// Ab node 2 se 1 check karenge:

// dist[2] + weight
// = 1 + 2
// = 3

// Current:

// dist[1] = 4

// Because:

// 3 < 4

// we update:

// dist[1] = 3

// This is called relaxation.

// Code:

// if (dist[v] > dist[u] + wt) {
//     dist[v] = dist[u] + wt;
// }
// 3. Why PriorityQueue?

// Interviewer: Why do you use PriorityQueue?

// Answer:

// Because Dijkstra always needs to process the node having the smallest tentative distance. PriorityQueue gives me the minimum-distance node efficiently.

// Simple:

// Normal Queue
// → FIFO

// PriorityQueue
// → Smallest distance first
// 4. Why can't we use normal BFS?

// Interviewer: Why not use BFS for shortest path?

// Answer:

// BFS works for unweighted graphs or graphs where every edge has the same weight. Dijkstra is used when edges have different non-negative weights.

// Example:

// 0 → 1 = 100
// 0 → 2 = 1
// 2 → 1 = 1

// BFS may see 0 → 1 first.

// But Dijkstra calculates:

// 0 → 2 → 1
// = 1 + 1
// = 2

// So shortest distance is 2.

// 5. Can Dijkstra handle negative weights?

// Interviewer: Does Dijkstra work with negative edge weights?

// Answer:

// No. Dijkstra requires non-negative edge weights.

// For negative weights, we generally use:

// Bellman-Ford
// 6. Why doesn't it work with negative weights?

// Interviewer: Why?

// Answer:

// Dijkstra assumes that once the node with the smallest distance is selected, its distance is finalized. A negative edge can later reduce that distance, so this assumption becomes invalid.

// 7. Time Complexity

// Interviewer: What is the time complexity?

// Using:

// Adjacency List + PriorityQueue

// the commonly stated complexity is:

// O((V + E) log V)

// Often simplified to:

// O(E log V)

// for a connected graph.

// Space:

// O(V + E)

// because we store the graph, distance array and PriorityQueue.

// 8. Dijkstra vs BFS
// BFS	Dijkstra
// Unweighted graph	Weighted graph
// Same edge cost	Different non-negative costs
// Queue	PriorityQueue
// O(V + E)	O((V+E) log V)
// Minimizes number of edges	Minimizes total weight
// 9. Dijkstra vs Bellman-Ford
// Dijkstra	Bellman-Ford
// Non-negative weights	Can handle negative weights
// Faster generally	Slower
// PriorityQueue commonly used	Repeated relaxation
// Cannot detect negative cycle	Can detect negative cycle
// 10. Dijkstra vs Prim's Algorithm

// Ye tricky follow-up hai.

// Interviewer: Both use PriorityQueue. What's the difference?

// Answer:

// Dijkstra finds the shortest distance from a source to other vertices.

// Prim's algorithm finds a Minimum Spanning Tree, where the goal is to minimize the total weight of the selected edges.

// Dijkstra
// Source → shortest distance → every node
// Prim
// Connect all vertices
// with minimum total edge weight
// 11. Directed graph me work karega?

// Interviewer: Can Dijkstra work on directed graphs?

// Answer:

// Yes. Dijkstra can work on both directed and undirected graphs as long as the edge weights are non-negative.

// 12. Source se sirf ek node tak shortest path?

// Dijkstra normally:

// Source → all nodes

// But agar mujhe sirf target chahiye, to target node ki shortest distance finalize hone ke baad algorithm stop kar sakte hain.

// Example:

// 0 → 1 → 2 → 3

// Agar target 3 hai, to 3 minimum distance ke saath PriorityQueue se remove hone par stop kar sakte hain.

// 13. Shortest path ka actual route kaise print karenge?

// Abhi hum sirf distance nikal rahe hain:

// 0 → 3 = 4

// Agar interviewer bole:

// "Actual path bhi print karo."

// To parent[] array maintain karenge.

// Example:

// parent[v] = u;

// Jab relaxation hota hai:

// if (dist[v] > dist[u] + wt) {

//     dist[v] = dist[u] + wt;

//     parent[v] = u;

//     pq.add(new Pair(v, dist[v]));
// }

// Then target se parent follow karke source tak ja sakte hain.

// 14. Ek important tricky question

// Interviewer: Why can the same node be added to PriorityQueue multiple times?

// Answer:

// Because we may discover a better distance for the same node later. Instead of updating an existing PriorityQueue entry, we can insert the new pair. When an old pair comes out, we can ignore it if it is no longer equal to the current shortest distance.

// Isliye optimized code me:

// if (d != dist[u]) {
//     continue;
// }

// use karte hain.

// 15. Interview me algorithm ke steps

// Ye 7 steps yaad kar lo:

// 1. Graph create karo
// 2. dist[] = INF
// 3. source distance = 0
// 4. PriorityQueue me source add
// 5. Minimum distance node nikalo
// 6. Neighbours ko relax karo
// 7. Queue empty hone tak repeat
// One-line memory trick:

// Minimum node nikalo → neighbours check karo → shorter distance mile to update karo.

// Most important follow-up questions

// Interview ke liye in questions ko pakka prepare karo:

// What is Dijkstra's Algorithm?
// Why PriorityQueue?
// What is relaxation?
// Why can't BFS handle weighted graphs?
// Can Dijkstra handle negative weights?
// Why doesn't it work with negative weights?
// Time and space complexity?
// Dijkstra vs BFS?
// Dijkstra vs Bellman-Ford?
// Dijkstra vs Prim's Algorithm?
// Can it work on directed graphs?
// How do you reconstruct the actual shortest path?
// Why can a node enter PriorityQueue multiple times?
// What happens if some vertices are unreachable?
// What if all edge weights are 1?

// Most important: BFS vs Dijkstra, negative weights, relaxation, PriorityQueue, complexity, aur Dijkstra vs Prim ko strong kar lo.