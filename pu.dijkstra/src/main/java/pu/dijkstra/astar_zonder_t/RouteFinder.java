package pu.dijkstra.astar_zonder_t;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RouteFinder
{
private final Graph graph;
private final Scorer nextNodeScorer;
private final Scorer targetScorer;
@SuppressWarnings( "hiding" )
public RouteFinder(Graph graph, Scorer nextNodeScorer, Scorer targetScorer) {
    this.graph = graph;
    this.nextNodeScorer = nextNodeScorer;
    this.targetScorer = targetScorer;
}
public List<Node> findRoute(Node from, Node to) {
    Map<Node, RouteNode> allNodes = new HashMap<>();
    @SuppressWarnings( "rawtypes" )
	Queue<RouteNode> openSet = new PriorityQueue<>();

    RouteNode start = new RouteNode(from, null, 0d, targetScorer.computeCost(from, to));
    allNodes.put(from, start);
    openSet.add(start);

    while (!openSet.isEmpty()) {
        log.debug("Open Set contains: " + openSet.stream().map(RouteNode::getCurrent).collect(Collectors.toSet()));
        RouteNode next = openSet.poll();
        log.debug("Looking at node: " + next);
        if (next.getCurrent().equals(to)) {
            log.debug("Found our destination!");

            List<Node> route = new ArrayList<>();
            RouteNode current = next;
            do {
                route.add(0, current.getCurrent());
                current = allNodes.get(current.getPrevious());
            } while (current != null);

            log.debug("Route: " + route);
            return route;
        }

        graph.getConnections(next.getCurrent()).forEach(connection -> {
            double newScore = next.getRouteScore() + nextNodeScorer.computeCost(next.getCurrent(), connection);
            RouteNode nextNode = allNodes.getOrDefault(connection, new RouteNode(connection));
            allNodes.put(connection, nextNode);

            if (nextNode.getRouteScore() > newScore) {
                nextNode.setPrevious(next.getCurrent());
                nextNode.setRouteScore(newScore);
                nextNode.setEstimatedScore(newScore + targetScorer.computeCost(connection, to));
                openSet.add(nextNode);
                log.debug("Found a better route to node: " + nextNode);
            }
        });
    }
    throw new IllegalStateException("No route found");
}

}