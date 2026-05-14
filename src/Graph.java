import java.util.*;

class Edge1 {
    String to;
    int weight;

    Edge1(String to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Graph {

    Map<String, List<Edge>> graph = new HashMap<>();

    void addVertex(String v) {
        graph.putIfAbsent(v, new ArrayList<>());
    }

    void addEdge(String v, String w, int weight) {
        graph.get(v).add(new Edge(w, weight));
        graph.get(w).add(new Edge(v, weight));
    }

    void printGraph() {

        for (String v : graph.keySet()) {

            System.out.print(v + " -> ");

            for (Edge e : graph.get(v))
                System.out.print("(" + e.to + "," + e.weight + ") ");

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");

        g.addEdge("A", "B", 4);
        g.addEdge("A", "C", 2);
        g.addEdge("B", "D", 5);
        g.addEdge("C", "D", 1);

        g.printGraph();
    }
}