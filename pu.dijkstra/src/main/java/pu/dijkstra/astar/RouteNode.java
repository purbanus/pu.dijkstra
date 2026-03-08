package pu.dijkstra.astar;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RouteNode<T extends Node> implements Comparable<RouteNode<T>>
{
private final T current;
private T previous;
private double routeScore;
private double estimatedScore;

@SuppressWarnings( "hiding" )
RouteNode( T current )
{
	this( current, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY );
}
@SuppressWarnings( "hiding" )
RouteNode( T current, T previous, double routeScore, double estimatedScore )
{
	this.current = current;
	this.previous = previous;
	this.routeScore = routeScore;
	this.estimatedScore = estimatedScore;
}
@Override
public int compareTo( RouteNode<T> other )
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
}