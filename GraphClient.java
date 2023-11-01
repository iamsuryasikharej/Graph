import java.util.LinkedList;

public class GraphClient {
	public static void main(String[] args) {
		Graph g=new Graph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addEdge("a", "b");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("d", "a");
		g.addEdge("b", "e");

//		g.addEdge("e", "f");
//		g.addEdge("f", "g");
//		g.addEdge("g", "e");
//		g.displayGraph();
//		g.BFT1("a");
//		g.BFT("a");
//		
//		g.getConnectedComponents();
//		System.out.println(g.isCyclic("a"));
		g.DFT("a", new LinkedList<String>());
		System.out.println("-------");
		g.BFT("a");


		
	}

}
