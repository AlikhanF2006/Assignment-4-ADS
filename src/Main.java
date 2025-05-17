import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> atyrau = new Vertex<>("Atyrau");
        Vertex<String> kostanay = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        // Create graph and add edges
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(almaty, astana, 2.1);
        graph.addEdge(shymkent, atyrau, 7.8);
        graph.addEdge(atyrau, astana, 7.1);
        graph.addEdge(almaty, shymkent, 7.2);
        graph.addEdge(shymkent, astana, 3.9);
        graph.addEdge(astana, kostanay, 3.5);
        graph.addEdge(shymkent, kyzylorda, 5.4);

        // Run BFS
        System.out.println("Breadth-First Search from Almaty to Kyzylorda:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, almaty);
        outputPath(bfs.pathTo(kyzylorda));

        System.out.println();

        // Run Dijkstra
        System.out.println("Dijkstra Search from Almaty to Kyzylorda:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, almaty);
        outputPath(dijkstra.pathTo(kyzylorda));
    }

    public static void outputPath(List<Vertex<String>> path) {
        if (path == null) {
            System.out.println("No path found.");
            return;
        }

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).getData());
            if (i < path.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
    }
}
