package pu.dijkstra;

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
private Set<Node> nodes = new HashSet<>();

public void addNode( Node aNode)
{
    nodes.add(aNode);
}
public void printShortestPath()
{
	for ( Node node : getNodes() )
	{
		if ( node.getAdjacentNodes().isEmpty() )
		{
			List<Node> shortestPath = node.getShortestPath();
			shortestPath.add( node );
			System.out.println( "Shorted Path: " + shortestPath );
		}
	}
}

}
