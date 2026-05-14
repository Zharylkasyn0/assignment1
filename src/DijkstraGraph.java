import java.util.*;

class Edge {
    String to;
    int weight;

    Edge(String to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {

    String vertex;
    int dist;

    Node(String vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }

    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}

public class DijkstraGraph {

    Map<String, List<Edge>> graph = new HashMap<>();

    void addVertex(String v) {
        graph.putIfAbsent(v, new ArrayList<>());
    }

    void addEdge(String v, String w, int weight) {
        graph.get(v).add(new Edge(w, weight));
        graph.get(w).add(new Edge(v, weight));
    }

    void dijkstra(String start) {

        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();

        for (String v : graph.keySet())
            dist.put(v, Integer.MAX_VALUE);

        dist.put(start, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            for (Edge e : graph.get(cur.vertex)) {

                int newDist = dist.get(cur.vertex) + e.weight;

                if (newDist < dist.get(e.to)) {

                    dist.put(e.to, newDist);
                    prev.put(e.to, cur.vertex);

                    pq.add(new Node(e.to, newDist));
                }
            }
        }

        for (String v : dist.keySet()) {

            System.out.print("Path to " + v + ": ");

            printPath(prev, v);

            System.out.println(" | Distance = " + dist.get(v));
        }
    }

    void printPath(Map<String, String> prev, String v) {

        if (prev.get(v) != null)
            printPath(prev, prev.get(v));

        System.out.print(v + " ");
    }

    public static void main(String[] args) {

        DijkstraGraph g = new DijkstraGraph();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");

        g.addEdge("A", "B", 4);
        g.addEdge("A", "C", 2);
        g.addEdge("B", "D", 5);
        g.addEdge("C", "D", 1);

        g.dijkstra("A");
    }
}