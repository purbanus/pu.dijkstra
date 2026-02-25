package pu.dijkstra;

import org.junit.jupiter.api.Test;

public class TestDijkstra
{
public Pair<Graph, Node> createGraph()
{
	Graph graph = new Graph();
	Node nodeA = new Node("A", graph );
	Node nodeB = new Node("B", graph );
	Node nodeC = new Node("C", graph );
	Node nodeD = new Node("D", graph ); 
	Node nodeE = new Node("E", graph );
	Node nodeF = new Node("F", graph );
	
	nodeA.addAdjacentNode(nodeB, 10);
	nodeA.addAdjacentNode(nodeC, 15);
	
	nodeB.addAdjacentNode(nodeD, 12);
	nodeB.addAdjacentNode(nodeF, 15);
	
	nodeC.addAdjacentNode(nodeE, 10);
	
	nodeD.addAdjacentNode(nodeE, 2);
	nodeD.addAdjacentNode(nodeF, 1);
	
	nodeF.addAdjacentNode(nodeE, 5);
	
	return new Pair<>( graph, nodeA );
}
@Test
public void testBaeldungGraph()
{
	Pair<Graph, Node> pair = createGraph();
	Graph graph = pair.getFirst();
	Node startNode = pair.getSecond();
	graph = new Dijkstra().calculateShortestPathFromSource( graph, startNode);
	graph.printShortestPath();
}

}
