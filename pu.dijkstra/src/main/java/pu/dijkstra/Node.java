package pu.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data Want we willenn hier geen equals en hashCode
@Getter
@Setter
@ToString
public class Node
{

private String name;
private Integer distance = Integer.MAX_VALUE;

@EqualsAndHashCode.Exclude
@ToString.Exclude
private List<Node> shortestPath = new LinkedList<>();
@EqualsAndHashCode.Exclude
@ToString.Exclude
Map<Node, Integer> adjacentNodes = new HashMap<>();

public Node( String aName, Graph aGraph )
{
	name = aName;
	aGraph.addNode( this );
}
public void addAdjacentNode( Node aDestination, int aDistance )
{
	adjacentNodes.put( aDestination, aDistance );
}
}
