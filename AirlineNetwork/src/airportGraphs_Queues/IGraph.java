package airportGraphs_Queues;

import java.io.PrintStream;
import java.util.Collection;

// A graph is a set of vertices and a collection of edges that each connect a pair of vertices.
// GRAPH = VERTEX, EDGE
// G=(V,E)
public interface IGraph<D, W> {

    void addVertex(D... data);

    void addEdge(W weight, Vertex<D, W> tail, Vertex<D, W> head, boolean directed);

    default void addEdge(W weight, D tailData, D headData, boolean directed) {
        addEdge(weight, vertexOf(tailData), vertexOf(headData), directed);
    }

    Vertex<D, W> vertexOf(D data);

    Collection<Vertex<D, W>> getVertices();

    Collection<Edge<D, W>> getEdges();

    // Implement this method instead of Vertex.getAdjacentEdges()
    Collection<Edge<D, W>> getEdgesFrom(Vertex<D, W> vertex);

    default void print(PrintStream out) {
        out.println(toString());
    }

    interface Vertex<D, W> {

        D getData();

        Collection<Edge<D, W>> getAdjacentEdges();
    }

    interface Edge<D, W> {

        W getWeight();

        Vertex<D, W> getHeadVertex();
    }

}
