import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a vertex in a graph.
 * Stores its own data and a map of adjacent vertices with edge weights.
 */
public class Vertex<T> {
    // The data stored in the vertex (e.g., city name, number, etc.)
    private T data;

    // A map of adjacent vertices and the weights of the edges connecting them
    private Map<Vertex<T>, Double> adjacentVertices;

    /**
     * Constructor to initialize the vertex with data.
     * @param data The value this vertex holds.
     */
    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Gets the data stored in the vertex.
     * @return The data of the vertex.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data for the vertex.
     * @param data The new value to store.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Adds an adjacent vertex and the weight of the connecting edge.
     * @param neighbor The vertex connected to this one.
     * @param weight The weight of the edge to the neighbor.
     */
    public void addAdjacent(Vertex<T> neighbor, double weight) {
        adjacentVertices.put(neighbor, weight);
    }

    /**
     * Returns a map of adjacent vertices and their edge weights.
     * @return A map of neighbors and edge weights.
     */
    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    /**
     * Returns a string representation of the vertex (its data).
     */
    @Override
    public String toString() {
        return data.toString();
    }

    /**
     * Checks if two vertices are equal based on their data.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    /**
     * Generates a hash code based on the data.
     */
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
