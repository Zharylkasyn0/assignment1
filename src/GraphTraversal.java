import java.util.*;

class Edge1 {

    String to;
    int weight;

    Edge1(String to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class GraphTraversal {

    Map<String, List<Edge>> graph = new HashMap<>();

    void addVertex(String v) {
        graph.putIfAbsent(v, new ArrayList<>());
    }

    void addEdge(String v, String w, int weight) {

        graph.get(v).add(new Edge(w, weight));
        graph.get(w).add(new Edge(v, weight));
    }

    void dfs(String start, Set<String> visited) {

        visited.add(start);

        System.out.print(start + " ");

        for (Edge e : graph.get(start)) {

            if (!visited.contains(e.to))
                dfs(e.to, visited);
        }
    }

    void bfs(String start) {

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {

            String cur = q.poll();

            System.out.print(cur + " ");

            for (Edge e : graph.get(cur)) {

                if (!visited.contains(e.to)) {

                    visited.add(e.to);
                    q.add(e.to);
                }
            }
        }
    }

    public static void main(String[] args) {

        GraphTraversal g = new GraphTraversal();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("B", "A", 11);
        g.addEdge("C", "B", 5);
        g.addEdge("D", "A", 11);
        g.addEdge("E", "D", 8);
        g.addEdge("F", "C", 13);
        g.addEdge("A", "E", 12);
        g.addEdge("F", "E", 3);

        System.out.println("DFS:");
        g.dfs("C", new HashSet<>());

        System.out.println("\nBFS:");
        g.bfs("C");
    }
}