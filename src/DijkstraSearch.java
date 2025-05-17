import java.util.*;

/**
 * Dijkstra's algorithm for finding the shortest path in a vertex-based weighted graph.
 * Calculates the minimum distances from a source vertex to all other vertices.
 */
public class DijkstraSearch<T> extends Search<T> {

    // Stores the current shortest known distance from the source to each vertex
    private final Map<Vertex<T>, Double> distances;

    /**
     * Constructor that starts Dijkstra's algorithm from the given source.
     * @param graph The weighted graph.
     * @param source The starting vertex.
     */
    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        this.distances = new HashMap<>();
        dijkstra(graph);
    }

    /**
     * Internal method that implements Dijkstra's algorithm.
     * It calculates the shortest paths from the source to all reachable vertices.
     *
     * @param graph The graph to traverse.
     */
    private void dijkstra(WeightedGraph<T> graph) {
        // Priority queue to always process the vertex with the smallest known distance
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Distance to the source is 0
        distances.put(source, 0.0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();

            if (!marked.contains(current)) {
                marked.add(current); // Mark the current vertex as visited

                // Explore all adjacent vertices
                for (Map.Entry<Vertex<T>, Double> entry : current.getAdjacentVertices().entrySet()) {
                    Vertex<T> neighbor = entry.getKey();
                    double weight = entry.getValue();

                    // Calculate new potential distance to neighbor
                    double newDist = distances.get(current) + weight;

                    // If the new distance is shorter, update and enqueue the neighbor
                    if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                        distances.put(neighbor, newDist);          // Update shortest distance
                        edgeTo.put(neighbor, current);             // Store the path
                        queue.add(neighbor);                       // Enqueue neighbor for further processing
                    }
                }
            }
        }
    }
}
