package pu.dijkstra.dijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra
{

public void calculateShortestPathFromSource( Graph aGraph )
{
	Node source = aGraph.getStartNode();
	source.setDistance( 0 );

	Set<Node> settledNodes = new HashSet<>();
	PriorityQueue<Node> unsettledNodes = new PriorityQueue<>();

	unsettledNodes.add( source );

	while ( unsettledNodes.size() != 0 )
	{
		Node currentNode = getLowestDistanceNode( unsettledNodes );
		for ( Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet() )
		{
			Node adjacentNode = adjacencyPair.getKey();
			Integer edgeWeight = adjacencyPair.getValue();
			if ( ! settledNodes.contains( adjacentNode ) )
			{
				calculateMinimumDistance( unsettledNodes, adjacentNode, edgeWeight, currentNode );
			}
		}
		settledNodes.add( currentNode );
	}
	aGraph.getEndNode().getShortestPath().add( aGraph.getEndNode() );
}
private Node getLowestDistanceNode( PriorityQueue<Node> aUnsettledNodes )
{
	return aUnsettledNodes.poll();
}
private void calculateMinimumDistance( PriorityQueue<Node> aUnsettledNodes, Node aEvaluationNode, Integer aEdgeWeight, Node aSourceNode )
{
	Integer sourceDistance = aSourceNode.getDistance();
	if ( sourceDistance + aEdgeWeight < aEvaluationNode.getDistance() )
	{
		if ( aEvaluationNode.getDistance() != Integer.MAX_VALUE )
		{
			aUnsettledNodes.remove( aEvaluationNode );
		}
		aEvaluationNode.setDistance( sourceDistance + aEdgeWeight );
		List<Node> shortestPath = new ArrayList<>( aSourceNode.getShortestPath() );
		shortestPath.add( aSourceNode );
		aEvaluationNode.setShortestPath( shortestPath );

		aUnsettledNodes.add( aEvaluationNode );
	}
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

}
