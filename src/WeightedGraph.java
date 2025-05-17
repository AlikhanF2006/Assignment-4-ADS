import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<T> {
    private Set<Vertex<T>> vertices;

    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        source.addAdjacent(destination, weight);
        vertices.add(source);      // в случае, если source ещё не добавлен
        vertices.add(destination); // в случае, если destination ещё не добавлен
    }

    public Set<Vertex<T>> getVertices() {
        return vertices;
    }
}
