package airportGraphs_Queues;

import airportGraphs_Queues.IGraph.Edge;
import airportGraphs_Queues.IGraph.Vertex;
import java.util.HashSet;
import java.util.Set;

// Find if an Airport can be reached from another using single Airline
// Compare DepthFirst and BreathFirst
public class Graphs {

    private static <D, W> void depthFirst(
            Set<Vertex<D, W>> marked,
            RootedTree<D, W> edgesTo,
            IGraph<D, W> graph,
            Vertex<D, W> vertex
    ) {
        marked.add(vertex);
        for (Edge<D, W> edge : graph.getEdgesFrom(vertex)) {
            if (marked.contains(edge.getHeadVertex())) {
                continue;
            }
            edgesTo.add(edge);
            depthFirst(marked, edgesTo, graph, edge.getHeadVertex());
        }
    }

    public static <D, W> RootedTree<D, W> depthFirst(IGraph<D, W> graph, Vertex<D, W> root) {
        Set<Vertex<D, W>> marked = new HashSet<>();
        RootedTree<D, W> edgesTo = new SimpleRootedTree<>(graph, root);

        depthFirst(marked, edgesTo, graph, root);

        return edgesTo;
    }

    private static <D, W> void breadthFirst(
            Set<Vertex<D, W>> marked,
            RootedTree<D, W> edgesTo,
            IGraph<D, W> graph,
            IQueue<Vertex<D, W>> queue
    ) {
        if (queue.isEmpty()) {
            return;
        }
        Vertex<D, W> vertex = queue.dequeue();
        for (Edge<D, W> edge : graph.getEdgesFrom(vertex)) {
            Vertex<D, W> headVertex = edge.getHeadVertex();
            if (marked.contains(headVertex)) {
                continue;
            }
            marked.add(headVertex);
            queue.enqueue(headVertex);
            edgesTo.add(edge);
        }
        breadthFirst(marked, edgesTo, graph, queue);
    }

    public static <D, W> RootedTree<D, W> breadthFirst(IGraph<D, W> graph, Vertex<D, W> root) {
        Set<Vertex<D, W>> marked = new HashSet<>();
        RootedTree<D, W> edgesTo = new SimpleRootedTree<>(graph, root);
        IQueue<Vertex<D, W>> queue = new LinkedQueue<>();

        marked.add(root);
        queue.enqueue(root);
        breadthFirst(marked, edgesTo, graph, queue);

        return edgesTo;
    }

}
