import java.util.*;

/**
 * Breadth-First Search algorithm for vertex-based weighted graph.
 * Traverses the graph from a given source vertex and builds the path tree.
 */
public class BreadthFirstSearch<T> extends Search<T> {

    /**
     * Constructor that starts BFS from the given source vertex.
     * @param graph The weighted graph to traverse.
     * @param source The starting vertex.
     */
    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        bfs(graph, source);
    }

    /**
     * Internal method that performs the BFS traversal.
     * It populates 'marked' and 'edgeTo' as it discovers vertices.
     *
     * @param graph The graph to traverse.
     * @param start The source vertex.
     */
    private void bfs(WeightedGraph<T> graph, Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        marked.add(start);        // Mark the source as visited
        queue.add(start);         // Add the source to the queue

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll(); // Dequeue the next vertex to explore

            // Iterate through all adjacent vertices (neighbors)
            for (Vertex<T> neighbor : current.getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);           // Mark neighbor as visited
                    edgeTo.put(neighbor, current);  // Store the path (where we came from)
                    queue.add(neighbor);            // Enqueue neighbor for further exploration
                }
            }
        }
    }
}
