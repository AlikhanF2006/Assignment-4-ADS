import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<T> graph, Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        marked.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();

            for (Vertex<T> neighbor : current.getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
