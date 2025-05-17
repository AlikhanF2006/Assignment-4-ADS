import java.util.HashSet;
import java.util.Set;

/**
 * Represents a weighted graph where each vertex stores its adjacent vertices and edge weights.
 * The graph uses vertex-based adjacency instead of a separate edge list.
 */
public class WeightedGraph<T> {

    // A set containing all vertices in the graph
    private Set<Vertex<T>> vertices;

    /**
     * Constructs an empty weighted graph.
     */
    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    /**
     * Adds a vertex to the graph.
     * If the vertex already exists, it is not added again.
     *
     * @param vertex The vertex to add.
     */
    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    /**
     * Adds an edge from the source vertex to the destination vertex with the given weight.
     * Also ensures both vertices are part of the graph.
     *
     * @param source The starting vertex of the edge.
     * @param destination The target vertex of the edge.
     * @param weight The weight of the edge.
     */
    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        source.addAdjacent(destination, weight);  // Add destination as a neighbor of source
        vertices.add(source);                     // Ensure source is in the graph
        vertices.add(destination);                // Ensure destination is in the graph
    }

    /**
     * Returns all vertices in the graph.
     *
     * @return A set of all vertices.
     */
    public Set<Vertex<T>> getVertices() {
        return vertices;
    }
}
