Assignment 4

This project is a Java implementation of a weighted directed graph using a vertex-based adjacency model. It was developed as part of the course "Algorithms and Data Structures" 

Inste  ad of using a separate Edge class or edge list, each Vertex<T> object stores a map of its adjacent vertices along with corresponding edge weights. This structure enables flexible graph traversal and efficient access to neighbors.

Contents:
- Vertex.java
- WeightedGraph.java
- Search.java
- BreadthFirstSearch.java
- DijkstraSearch.java
- Main.java

Part 1: Graph Structure
Implemented in Vertex.java and WeightedGraph.java  
Each Vertex<T> contains:
- T data – the content of the vertex (e.g., city name)
- Map<Vertex<T>, Double> adjacentVertices – the connected neighbors and weights

WeightedGraph<T> manages a Set<Vertex<T>> and allows adding vertices and weighted edges via:
- addVertex(Vertex<T> vertex)
- addEdge(Vertex<T> source, Vertex<T> destination, double weight)

Part 2: Breadth-First Search (BFS)
Implemented in BreadthFirstSearch.java  
This algorithm performs a standard breadth-first traversal using a queue. It builds the `marked` set and `edgeTo` map (inherited from the abstract class Search) to reconstruct the shortest path in terms of the number of edges.

Part 3: Dijkstra’s Algorithm
Implemented in DijkstraSearch.java  
Uses a PriorityQueue to always process the vertex with the smallest current known distance. The `distances` map tracks the shortest distance from the source to every reachable vertex. The resulting `edgeTo` map allows reconstruction of the shortest weighted path.

Part 4: Search Base Class
The abstract class Search<T> provides shared logic for both search algorithms:
- hasPathTo(Vertex<T> destination) – checks if a path exists
- pathTo(Vertex<T> destination) – returns the list of vertices forming the path from the source

Part 5: Main Demonstration
Main.java demonstrates usage by:
- Creating a graph of Kazakhstani cities (e.g., Almaty, Astana, Shymkent)
- Adding weighted directed edges between them
- Running both BFS and Dijkstra to find paths from Almaty to Kyzylorda
- Printing the resulting paths to the console

The project follows an iterative approach, suitable for BFS and Dijkstra.
