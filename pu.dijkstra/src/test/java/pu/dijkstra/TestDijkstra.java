package pu.dijkstra;

import org.junit.jupiter.api.Test;

public class TestDijkstra
{
public Graph createBaeldungGraph()
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
	
	graph.setStartNode( nodeA );
	graph.setEndNode( nodeE );
	return graph;
}
public Graph createComputerphileGraph()
{
	Graph graph = new Graph();
	Node nodeS = new Node("S", graph );
	Node nodeA = new Node("A", graph );
	Node nodeB = new Node("B", graph );
	Node nodeC = new Node("C", graph );
	Node nodeD = new Node("D", graph ); 
	Node nodeF = new Node("F", graph );
	Node nodeG = new Node("G", graph );
	Node nodeH = new Node("H", graph );
	Node nodeI = new Node("I", graph );
	Node nodeJ = new Node("J", graph );
	Node nodeK = new Node("K", graph );
	Node nodeL = new Node("L", graph );
	Node nodeE = new Node("E", graph );
	
	nodeS.addAdjacentNode(nodeA, 7 );
	nodeS.addAdjacentNode(nodeB, 2 );
	nodeS.addAdjacentNode(nodeC, 3 );
	
	nodeA.addAdjacentNode(nodeB, 3 );
	nodeA.addAdjacentNode(nodeD, 4 );
	
	nodeB.addAdjacentNode(nodeD, 4 );
	nodeB.addAdjacentNode(nodeH, 1 );
	
	nodeC.addAdjacentNode(nodeL, 2 );
	
	nodeD.addAdjacentNode(nodeF, 5 );

	//nodeF.addAdjacentNode(?????, 5 );
	
	nodeG.addAdjacentNode(nodeE, 2 );

	nodeH.addAdjacentNode(nodeF, 3 );
	nodeH.addAdjacentNode(nodeG, 2 );

	nodeI.addAdjacentNode(nodeJ, 6 );
	nodeI.addAdjacentNode(nodeK, 4 );

	nodeJ.addAdjacentNode(nodeK, 4 );

	nodeK.addAdjacentNode(nodeE, 5 );
	
	nodeL.addAdjacentNode(nodeI, 4 );
	nodeL.addAdjacentNode(nodeJ, 4 );
	
	graph.setStartNode( nodeS );
	graph.setEndNode( nodeE );
	return graph;
}
@Test
public void testBaeldungGraph()
{
	Graph graph = createBaeldungGraph();
	runGraph( graph );
}
@Test
public void testComputerphileGraph()
{
	Graph graph = createComputerphileGraph();
	runGraph( graph );
}
void runGraph( Graph aGraph )
{
	new Dijkstra().calculateShortestPathFromSource( aGraph);
	aGraph.printShortestPath();
}

}
