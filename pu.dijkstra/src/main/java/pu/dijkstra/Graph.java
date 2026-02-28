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
private Node startNode;
private Node endNode;
private Set<Node> nodes = new HashSet<>();

public void addNode( Node aNode)
{
    nodes.add(aNode);
}
public void printShortestPath()
{
	List<Node> shortestPath = getEndNode().getShortestPath();
	shortestPath.add( getEndNode() );
	System.out.println( "Shorted Path: " + shortestPath );
}

}
