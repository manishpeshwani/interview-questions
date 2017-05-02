package com.manish.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import com.manish.graph.DijkstraMinDistance.Index;


/**
 * http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-
 * tree-mst-2/
 * 
 * @author manishpeshwani
 *
 */

public class PrimsAlgoMST {
	
	public static class Index {
		Vertex vert;
		int minEdgeLength;
		Edge parent;
		
		@Override
		public String toString() {
			return "[v=" + vert + ", l=" + minEdgeLength + ", p=" + parent + "]";
		}
		
	}

	public static void main(String[] args) {
		Graph graph = new Graph(false);

		Vertex a = new Vertex("a");// 1
		Vertex b = new Vertex("b");// 2
		Vertex c = new Vertex("c");// 3
		Vertex d = new Vertex("d");// 4
		Vertex e = new Vertex("e");// 5
		Vertex f = new Vertex("f");// 6
		Vertex g = new Vertex("g");// 7
		Vertex h = new Vertex("h");// 7
		Vertex i = new Vertex("i");// 7

		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);

		graph.addEdge(new Edge(a, b, 4));
		graph.addEdge(new Edge(a, c, 8));
		graph.addEdge(new Edge(b, c, 11));
		graph.addEdge(new Edge(b, d, 8));
		graph.addEdge(new Edge(c, e, 1));
		graph.addEdge(new Edge(d, f, 7));
		graph.addEdge(new Edge(c, g, 7));
		graph.addEdge(new Edge(e, g, 6));
		graph.addEdge(new Edge(d, g, 2));
		graph.addEdge(new Edge(e, h, 2));
		graph.addEdge(new Edge(d, h, 4));
		graph.addEdge(new Edge(f, h, 14));
		graph.addEdge(new Edge(f, i, 9));
		graph.addEdge(new Edge(h, i, 10));

		List<Edge> mstEdges = new ArrayList<Edge>();

		primMST(graph, mstEdges);

		System.out.println(mstEdges);

	}
	
	

	private static void primMST(Graph graph, List<Edge> mstEdges) {
		// Create a priority queue
		PriorityQueue<Index> queue = new PriorityQueue<Index>(new Comparator<Index>() {

			@Override
			public int compare(Index o1, Index o2) {
				return o1.minEdgeLength - o2.minEdgeLength;
			}
		});

		// Start with a vertex and create index for it with minDist 0 and offer
		// it to the queue
		Index aInd = new Index();
		aInd.vert = graph.vertices[0];// 0th position has a vertex
		aInd.minEdgeLength = 0;

		queue.offer(aInd);

		// Initialize all the indices with max integer
		for (int k = 1; k < graph.vSize; k++) {
			Index ind = new Index();
			ind.vert = graph.vertices[k];
			ind.minEdgeLength = Integer.MAX_VALUE;

			queue.offer(ind);

		}
		
		while(!queue.isEmpty()){
			
			Index ind = queue.poll();
			
			if(ind.parent != null){
				mstEdges.add(ind.parent);
			}
			
			for(Vertex n: ind.vert.neighbours){
				Edge edge = getEdge(graph, ind.vert, n);
				updateMinDist(queue, n, edge);
			}
			
		}
			

	}
	
	private static void updateMinDist(PriorityQueue<Index> queue, Vertex n, Edge e) {
		Iterator<Index> iter = queue.iterator();
		
		Index indToUpdate = null;
		while(iter.hasNext()){
			Index ind = iter.next();
			if(ind.vert.equals(n)){
				indToUpdate = ind;
				break;
			}
		}
		
		//Remove the index from queue and replace it with updated one if minDist is less than the existing minDistance
		if(indToUpdate != null && e.weight < indToUpdate.minEdgeLength){
			queue.remove(indToUpdate);
			Index i = new Index();
			i.vert = n;
			i.minEdgeLength = e.weight;
			i.parent = e;
			queue.offer(i);
		}
		
	}

	private static Edge getEdge(Graph graph, Vertex s, Vertex d) {
		Edge[] edges = graph.edges;
		
		for(int k=0;k<graph.eSize;k++){
			if(edges[k].source.equals(s) && edges[k].destination.equals(d)){
				return edges[k];
			}else if(edges[k].source.equals(d) && edges[k].destination.equals(s)){
				return edges[k];
			}
		}
		
		return null;
	}


}
