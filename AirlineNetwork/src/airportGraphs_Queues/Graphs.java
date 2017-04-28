package airportGraphs_Queues;

import airportGraphs_Queues.IGraph.Edge;
import airportGraphs_Queues.IGraph.Vertex;
import java.util.HashSet;
import java.util.Set;

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
       public static <D,W> RootedTree<D,W> depthFirst(IGraph<D,W> graph, Vertex<D,W> root) {
    Set<Vertex<D,W>> marked = new HashSet<>();
    RootedTree<D,W> edgesTo = new SimpleRootedTree<>(graph, root);
    
    depthFirst(marked, edgesTo, graph, root);
    
    return edgesTo;
    }
    
}
