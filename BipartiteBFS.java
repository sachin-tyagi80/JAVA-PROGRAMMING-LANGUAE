import java.util.*;

public class BipartiteBFS {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {

        int color[] = new int[graph.length];

        // -1 means no color
        Arrays.fill(color, -1);

        // For disconnected graph
        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean bfs(
            ArrayList<Edge>[] graph,
            int start,
            int color[]) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {

            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {

                Edge e = graph[curr].get(i);

                // Neighbour is not colored
                if (color[e.dest] == -1) {

                    // Give opposite color
                    color[e.dest] = 1 - color[curr];

                    q.add(e.dest);
                }

                // Neighbour has same color
                else if (color[e.dest] == color[curr]) {

                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int n = 4;

        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // if doesn't have cycle then it is bipartite

        // 0 -- 1
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        // 1 -- 2
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        // 2 -- 3
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        // 3 -- 0
        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3));

        System.out.println(isBipartite(graph));
    }
}


// 🎤 Interview Answer

// “A bipartite graph is a graph whose vertices can be divided into two groups, such that no two adjacent vertices belong to the same group.

// I can check whether a graph is bipartite using BFS and two colors. I initially assign color 0 to the starting vertex.
// Then, for every uncolored neighbour, I assign the opposite color using 1 - color[curr] and add it to the queue.

// If I ever find an edge where both connected vertices have the same color, then the graph is not bipartite, so I return false.
// Otherwise, after checking all vertices, I return true.

// I also check every unvisited vertex because the graph can be disconnected.”

// 🧠 Agar interviewer bole: Why 1 - color[curr]?

// Aap bolo:

// “Because I am using only two colors: 0 and 1. If the current color is 0, 1 - 0 gives 1. If the current color is 1, 1 - 1 gives 0. So it always gives the opposite color.”

// ❓ Agar interviewer bole: Why BFS?

// “BFS lets me process the graph level by level. When I visit a vertex, I give its neighbours the opposite color. This makes it easy to detect whether any adjacent vertices have the same color.”

// ❓ Time Complexity?

// “The time complexity is O(V + E), because every vertex and every edge is processed at most a constant number of times. The space complexity is O(V) for the color array and BFS queue.”

// ⭐ One-line trick

// Interview mein yaad rakho:

// Bipartite
//    ↓
// 2 Colors
//    ↓
// BFS / DFS
//    ↓
// Adjacent vertices → Different colors
//    ↓
// Same color adjacent → false