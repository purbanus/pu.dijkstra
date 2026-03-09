package pu.dijkstra.astar_zonder_t;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RouteNode implements Node, Comparable<RouteNode>
{
private final Node current;
private Node previous;
private double routeScore;
private double estimatedScore;

@SuppressWarnings( "hiding" )
RouteNode( Node current )
{
	this( current, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY );
}
@SuppressWarnings( "hiding" )
RouteNode( Node current, Node previous, double routeScore, double estimatedScore )
{
	this.current = current;
	this.previous = previous;
	this.routeScore = routeScore;
	this.estimatedScore = estimatedScore;
}
@Override
public int compareTo( RouteNode other )
{
	if ( this.estimatedScore > other.estimatedScore )
	{
		return 1;
	}
	else if ( this.estimatedScore < other.estimatedScore )
	{
		return -1;
	}
	else
	{
		return 0;
	}
}
@Override
public String getId()
{
	return "Geen id";
}
}