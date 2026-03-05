package pu.dijkstra.dijkstra;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
public class Graph 
{
@EqualsAndHashCode.Exclude
@ToString.Exclude
private Node startNode;
private Node endNode;
private Set<Node> nodes = new HashSet<>();

public void addNode( Node aNode )
{
    nodes.add(aNode);
}
public Node getNode( String aNodeName )
{
    for ( Node node : nodes )
	{
		if ( node.getName().equals( aNodeName ) )
		{
			return node;
		}
	}
    throw new RuntimeException( "Node does not exist: " + aNodeName );
}
public List<Node> getShortestPath()
{
	return getEndNode().getShortestPath();
}

}
