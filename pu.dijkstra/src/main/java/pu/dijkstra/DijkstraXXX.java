package pu.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class DijkstraXXX
{

public Graph calculateShortestPathFromSource( Graph graph, Node source )
{
	source.setDistance( 0 );

	Set<Node> settledNodes = new HashSet<>();
	Set<Node> unsettledNodes = new HashSet<>();

	// System.out.print( "Adding " + source + " to unsettledNodes. " + printShortNodes( unsettledNodes ) );
	boolean success1 = unsettledNodes.add( source );
	// System.out.println( ( success1 ? " successfully" : " failed" ) );

	while ( unsettledNodes.size() != 0 )
	{
		Node currentNode = getLowestDistanceNode( unsettledNodes );
		// System.out.print( "Removing " + currentNode + " from unsettledNodes. " + printShortNodes( unsettledNodes ) );
		boolean success2 = unsettledNodes.remove( currentNode );
		// System.out.println( ( success2 ? " successfully " : " failed " ) + " afterwards " + printShortNodes(
		// unsettledNodes ) );
		for ( Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes()
		    .entrySet() )
		{
			Node adjacentNode = adjacencyPair.getKey();
			Integer edgeWeight = adjacencyPair.getValue();
			if ( !settledNodes.contains( adjacentNode ) )
			// boolean hasAdjacentNode = settledNodes.contains( adjacentNode );
			// System.out.println( "settledNodes contains " + adjacentNode + " is " + (hasAdjacentNode == true ? "true "
			// : "false ") + printShortNodes( settledNodes ) );
			// if ( ! hasAdjacentNode )
			{
				calculateMinimumDistance( adjacentNode, edgeWeight, currentNode );
				// System.out.print( "Adding " + adjacentNode + " to unsettledNodes. " + printShortNodes( unsettledNodes
				// ) );
				boolean success3 = unsettledNodes.add( adjacentNode );
				// System.out.println( ( success3 ? " successfully" : " failed" ) );
			}
		}
		// System.out.print( "Adding " + currentNode + " to settledNodes. " + printShortNodes( settledNodes ) );
		boolean success4 = settledNodes.add( currentNode );
		// System.out.println( ( success4 ? " successfully" : " failed" ) );
	}
	return graph;
}
@SuppressWarnings( "unused" )
private String printShortNodes( Set<Node> aNodeSet )
{
	StringBuilder sb = new StringBuilder();
	if ( aNodeSet.isEmpty() )
	{
		sb.append( "is empty" );
	}
	else
	{
		sb.append( "Contains " );
		for ( Node node : aNodeSet )
		{
			sb.append( node.getName() )
			    .append( node.getDistance() == Integer.MAX_VALUE ? "∞" : node.getDistance() )
			    .append( " " );
		}
	}
	return sb.toString();
}
private Node getLowestDistanceNode( Set<Node> unsettledNodes )
{
	// >@@NOG Het lijkt efficienter om hier een PriorityQueue te gebruiken
	Node lowestDistanceNode = null;
	int lowestDistance = Integer.MAX_VALUE;
	for ( Node node : unsettledNodes )
	{
		int nodeDistance = node.getDistance();
		if ( nodeDistance < lowestDistance )
		{
			lowestDistance = nodeDistance;
			lowestDistanceNode = node;
		}
	}
	return lowestDistanceNode;
}
private void calculateMinimumDistance( Node evaluationNode, Integer edgeWeigh, Node sourceNode )
{
	Integer sourceDistance = sourceNode.getDistance();
	if ( sourceDistance + edgeWeigh < evaluationNode.getDistance() )
	{
		evaluationNode.setDistance( sourceDistance + edgeWeigh );
		LinkedList<Node> shortestPath = new LinkedList<>( sourceNode.getShortestPath() );
		shortestPath.add( sourceNode );
		evaluationNode.setShortestPath( shortestPath );
	}
}

}
