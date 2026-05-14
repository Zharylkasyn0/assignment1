import java.util.*;

class Edge2 {
    String to;
    int weight;

    Edge2(String to, int weight) {
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

        g.addEdge("A", "B", 4);
        g.addEdge("A", "C", 2);
        g.addEdge("B", "D", 5);
        g.addEdge("C", "D", 1);

        System.out.println("DFS:");
        g.dfs("A", new HashSet<>());

        System.out.println("\nBFS:");
        g.bfs("A");
    }
}