package airportGraphImpl;

import airportDomain.Airport;
import airportDomain.Route;
import java.util.List;
import java.util.Map;

// 2. Find shortest path (distance) from one location to another
public class DjikstrasAlgorithm {

    private final List<Airport> vertices;
    private final List<Route> edges;
    private List<Airport> visited;
    private List<Airport> notVisited;
    private Map<Airport, Route> distance;
    
    public DjikstrasAlgorithm(List<Airport> vertices, List<Route> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

}
