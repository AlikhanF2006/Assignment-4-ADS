import java.util.*;

public class DijkstraSearch<T> extends Search<T> {

    private final Map<Vertex<T>, Double> distances;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        this.distances = new HashMap<>();
        dijkstra(graph);
    }

    private void dijkstra(WeightedGraph<T> graph) {
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        distances.put(source, 0.0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();

            if (!marked.contains(current)) {
                marked.add(current);

                for (Map.Entry<Vertex<T>, Double> entry : current.getAdjacentVertices().entrySet()) {
                    Vertex<T> neighbor = entry.getKey();
                    double weight = entry.getValue();
                    double newDist = distances.get(current) + weight;

                    if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                        distances.put(neighbor, newDist);
                        edgeTo.put(neighbor, current);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}
