import java.util.*;

public abstract class Search<T> {
    protected Set<Vertex<T>> marked;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;
    protected Vertex<T> source;

    public Search(Vertex<T> source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<T> destination) {
        return marked.contains(destination);
    }

    public List<Vertex<T>> pathTo(Vertex<T> destination) {
        if (!hasPathTo(destination)) return null;

        List<Vertex<T>> path = new ArrayList<>();
        for (Vertex<T> current = destination; current != source; current = edgeTo.get(current)) {
            path.add(current);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}
