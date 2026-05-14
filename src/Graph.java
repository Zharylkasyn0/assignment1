import java.util.*;

class Edge {

    String to;
    int weight;

    Edge(String to, int weight) {
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
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("B", "A", 11);
        g.addEdge("C", "B", 5);
        g.addEdge("D", "A", 11);
        g.addEdge("E", "D", 8);
        g.addEdge("F", "C", 13);
        g.addEdge("A", "E", 12);
        g.addEdge("F", "E", 3);

        g.printGraph();
    }
}