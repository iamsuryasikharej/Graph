
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	HashMap<String, LinkedList<Node>> vertices = new HashMap<>();
	LinkedList<String> visisted = new LinkedList<>();

	public void addEdge(String src1, String src2) {
		LinkedList<Node> l1 = null;
		LinkedList<Node> l2 = null;
		if (vertices.containsKey(src1) && vertices.containsKey(src2)) {
			l1 = vertices.get(src1);
			l2 = vertices.get(src2);
		}
		if (!l1.contains(src2) && !l2.contains(src1)) {
			l1.add(new Node(src2));
			l2.add(new Node(src1));

		}
	}

	public void addVertex(String x) {
		vertices.put(x, new LinkedList<Node>());
	}

	public void displayGraph() {
		System.out.println(vertices);
	}

	// BFT iterative assuming it’s a connected graph
	public void BFT(String src) {
		Queue q = new Queue();
		visisted = new LinkedList<>();
		HashMap<String, String> path = new HashMap<>();

		if (vertices.containsKey(src)) {
			q.enqueue(src);
			visisted.add(src);
		}
		while (!q.linkedList.isEmpty()) {
			String key = q.dequeue();
			System.out.println(key);
			LinkedList<Node> neighbour = vertices.get(key);
			for (Node n : neighbour) {
				if (!visisted.contains(n.data)) {

					q.enqueue(n.data);
					visisted.add(n.data);

				}
			}

		}
	}

	// BFT recursive assuming it’s a connected graph
	public void BFT1(String src) {
		Queue q = new Queue();
		HashSet<String> visisted = new HashSet<>();
		HashMap<String, String> path = new HashMap<>();

		if (vertices.containsKey(src)) {
			q.enqueue(src);
			visisted.add(src);

		}
		BFT1Traverse(q, visisted);
	}
	// BFT recursive assuming it’s a connected graph

	private void BFT1Traverse(Queue q, HashSet<String> visisted) {
		if (q.linkedList.isEmpty()) {
			return;
		}
		String key = q.dequeue();
		System.out.println(key);

		LinkedList<Node> neighbour = vertices.get(key);
		for (Node n : neighbour) {
			if (!visisted.contains(n.data)) {
				q.enqueue(n.data);
				visisted.add(n.data);

			}
		}
		BFT1Traverse(q, visisted);

	}

	public void getConnectedComponents() {

		Set<String> vertices1 = vertices.keySet();
		LinkedList<String> linkedList = new LinkedList<String>(vertices1);
		int connectedComponentsCounter = 0;
		for (int i = 0; i < linkedList.size(); i++) {
			if (!visisted.contains(linkedList.get(i))) {
				connectedComponentsCounter++;
				System.out.println("entry for" + linkedList.get(i));
				BFT(linkedList.get(i));
			}
		}

		System.out.println("Number of connected components present ---->" + connectedComponentsCounter);
	}
	
	public boolean isCyclic(String src)
	{
		int cyclicCounter=0;
		Queue q = new Queue();
		LinkedList<String> visisted1 = new LinkedList<>();
		HashMap<String, String> path = new HashMap<>();

		if (vertices.containsKey(src)) {
			q.enqueue(src);
		}
		while (!q.linkedList.isEmpty()) {
			String key = q.dequeue();
			if(visisted1.contains(key))
			{
				cyclicCounter++;
			}
			visisted1.add(key);
			

			System.out.println(key);
			LinkedList<Node> neighbour = vertices.get(key);
			for (Node n : neighbour) {
				if (!visisted1.contains(n.data)) {

					q.enqueue(n.data);
//					visisted1.add(n.data);

				}
			}

		}
		if(cyclicCounter>0)
		{
			return true;
		}
		else
			return false;
	}
	
	
	
	public void DFT(String src,LinkedList<String> visited)
	{
		System.err.println("entry dft------->"+src);
		if(!visited.contains(src))
		{
			System.out.println(src);
			visited.add(src);
			
		}
		LinkedList<Node> neighbours=null;
		if(vertices.containsKey(src))
		{
			neighbours=vertices.get(src);
		}
		for(Node temp:neighbours)
		{
			if(!visited.contains(temp.data)) {
			System.err.println("calling DFT"+temp.data +"from-->"+src);
			DFT(temp.data,visited);
			}
			
		}
	}

}
