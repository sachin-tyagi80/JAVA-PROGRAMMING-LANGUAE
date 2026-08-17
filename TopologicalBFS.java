import java.util.*;

public class TopologicalBFS {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // Create Graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -> 1
        graph[0].add(new Edge(0, 1));

        // 0 -> 2
        graph[0].add(new Edge(0, 2));

        // 1 -> 3
        graph[1].add(new Edge(1, 3));

        // 2 -> 3
        graph[2].add(new Edge(2, 3));

        // 3 -> 4
        graph[3].add(new Edge(3, 4));
    }

    // BFS + Topological Sort
    static void bfs(ArrayList<Edge>[] graph, int V) {

        // Calculate indegree
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {

            for (Edge e : graph[i]) {
                indegree[e.dest]++;
            }
        }

        // Queue
        Queue<Integer> q = new LinkedList<>();

        // Add vertices having indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {

            int curr = q.remove();

            System.out.print(curr + " ");

            // Decrease indegree of neighbours
            for (Edge e : graph[curr]) {

                indegree[e.dest]--;

                // If indegree becomes 0
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        bfs(graph, V);
    }
}

///////////////////////////////
//  Kahn's Algorithm ka core

// Yaad rakhna:

// 1. Indegree calculate karo
//         ↓
// 2. Indegree 0 wale Queue mein
//         ↓
// 3. Queue se node nikalo
//         ↓
// 4. Answer mein add karo
//         ↓
// 5. Neighbours ka indegree--
//         ↓
// 6. Jiska indegree 0 ho → Queue


//Indegree = kisi node par aane wali incoming edges ki count.

// 14. Interview mein 30-second explanation
// Agar interviewer bole "Explain your approach", ye bolo:
// I represent the prerequisites as a directed graph where the prerequisite points to the course. I calculate 
// the indegree of every course. Then I use Kahn's Algorithm, which is BFS-based. I put all courses with indegree
// zero into a queue because they have no pending prerequisites. I remove a course from the queue, add it to the
// answer, and decrease the indegree of all its neighbours. Whenever a neighbour's indegree becomes zero, I add
// it to the queue. Finally, if I processed all courses, I return the ordering. Otherwise, a cycle exists, 
// so I return an empty array.


// 🔥 Interview Follow-up Questions
// Q1. Why do we use BFS here?

// Answer:

// We are using BFS as part of Kahn's Topological Sort algorithm. It repeatedly processes nodes with indegree zero.

// Q2. Why is indegree == 0 important?

// It means the course has no remaining prerequisite, so we can safely take it.

// Q3. How do you detect a cycle?

// If the graph has a cycle, some nodes will always have non-zero indegree. Therefore, they will never enter the queue. If the number of processed nodes is less than numCourses, a cycle exists.

// if (index != numCourses)
//     return new int[0];
// Q4. DFS se bhi kar sakte hain?

// Yes.

// Two common approaches:

// Course Schedule II
//         |
//         ├── DFS
//         │    ├── visited[]
//         │    ├── stack[]
//         │    └── Stack<Integer>
//         │
//         └── BFS / Kahn
//              ├── indegree[]
//              └── Queue
// Q5. BFS vs DFS mein kaunsa better hai?

// Dono ka:

// Time:  O(V + E)
// Space: O(V + E)

// Practical interview answer:
// Both are valid. Kahn's BFS approach is often easier for me to explain because cycle detection directly comes
// from the number of processed nodes.