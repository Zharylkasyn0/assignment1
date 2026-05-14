import java.util.*;

class Edge2 {

    String to;
    int weight;

    Edge2(String to, int weight) {
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

            System.out.print(v + " Distance = " + dist.get(v) + " Path = ");

            printPath(prev, v);

            System.out.println();
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
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("B", "A", 11);
        g.addEdge("C", "B", 5);
        g.addEdge("D", "A", 11);
        g.addEdge("E", "D", 8);
        g.addEdge("F", "C", 13);
        g.addEdge("A", "E", 12);
        g.addEdge("F", "E", 3);

        g.dijkstra("B");
    }
}