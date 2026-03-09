package pu.dijkstra.astar_zonder_t;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Graph
{
private final Set<Station> nodes;
private final Map<String, Set<String>> connections;

public Graph( Set<Station> aNodes, Map<String, Set<String>> aConnections )
{
	super();
	nodes = aNodes;
	connections = aConnections;
}
public Node getNode( String id )
{
	return nodes.stream()
	    .filter( node -> node.getId().equals( id ) )
	    .findFirst()
	    .orElseThrow( () -> new IllegalArgumentException( "No node found with ID" ) );
}
public Set<Node> getConnections( Node node )
{
	return connections.get( node.getId() )
	    .stream()
	    .map( this::getNode )
	    .collect( Collectors.toSet() );
}
}