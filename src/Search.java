import java.util.*;

/**
 * Abstract base class for search algorithms (e.g., BFS, Dijkstra).
 * Stores common path-tracking logic shared by all graph search algorithms.
 */
public abstract class Search<T> {

    // Set of visited vertices during the search
    protected Set<Vertex<T>> marked;

    // Maps each vertex to the one it was reached from (used to reconstruct paths)
    protected Map<Vertex<T>, Vertex<T>> edgeTo;

    // The starting point of the search
    protected Vertex<T> source;

    /**
     * Constructor initializes the source and tracking structures.
     * @param source The source vertex to start the search from.
     */
    public Search(Vertex<T> source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    /**
     * Checks if there is a path from the source to the given destination vertex.
     * @param destination The target vertex.
     * @return true if a path exists; false otherwise.
     */
    public boolean hasPathTo(Vertex<T> destination) {
        return marked.contains(destination);
    }

    /**
     * Reconstructs the path from the source to the given destination.
     * If no path exists, returns null.
     *
     * @param destination The target vertex.
     * @return A list of vertices representing the path, or null if unreachable.
     */
    public List<Vertex<T>> pathTo(Vertex<T> destination) {
        if (!hasPathTo(destination)) return null;

        List<Vertex<T>> path = new ArrayList<>();
        for (Vertex<T> current = destination; current != source; current = edgeTo.get(current)) {
            path.add(current); // Trace path backward
        }
        path.add(source); // Add the source at the end
        Collections.reverse(path); // Reverse to get the correct order
        return path;
    }
}
