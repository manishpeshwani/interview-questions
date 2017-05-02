package com.manish.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 * 
 * @author manishpeshwani
 *
 */

public class DijkstraMinDistance {

	public static void main(String[] args) {
		Graph graph = new Graph(false);
		
		Vertex a = new Vertex("a");//1
		Vertex b = new Vertex("b");//2
		Vertex c = new Vertex("c");//3
		Vertex d = new Vertex("d");//4
		Vertex e = new Vertex("e");//5
		Vertex f = new Vertex("f");//6
		Vertex g = new Vertex("g");//7
		Vertex h = new Vertex("h");//7
		Vertex i = new Vertex("i");//7
		
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
		
		Map<Vertex, Integer> minDistMap = new HashMap<Vertex, Integer>();
		Map<Vertex, Vertex> parentVertex = new HashMap<Vertex, Vertex>();
		dijkstraMST(graph, minDistMap, parentVertex);
		
		System.out.println(minDistMap);
		System.out.println(parentVertex);

	}
	
	public static class Index {
		Vertex vert;
		int minDistance;
		Vertex parent;
	}

	private static void dijkstraMST(Graph graph, Map<Vertex, Integer> minDistMap, Map<Vertex, Vertex> parentVertex) {
		
		//Create a priority queue
		PriorityQueue<Index> queue = new PriorityQueue<Index>(new Comparator<Index>(){

			@Override
			public int compare(Index o1, Index o2) {
				return o1.minDistance - o2.minDistance;
			}});
		
		//Start with a vertex and create index for it with minDist 0 and offer it to the queue
		Index aInd = new Index();
		aInd.vert = graph.vertices[0];//0th position has a vertex
		aInd.minDistance = 0;
		
		queue.offer(aInd);
		
		//Initialize all the indices with max integer
		for(int k=1; k<graph.vSize;k++){
			Index ind = new Index();
			ind.vert = graph.vertices[k];
			ind.minDistance = Integer.MAX_VALUE;
			
			queue.offer(ind);
			
		}
		
		while(!queue.isEmpty()){
			
			//poll the index with min distance
			Index ind = queue.poll();
			
			//Make an entry in the minDistMap
			minDistMap.put(ind.vert, ind.minDistance);
			parentVertex.put(ind.vert, ind.parent);
			
			for(Vertex n: ind.vert.neighbours){
				Edge edge = getEdge(graph, ind.vert, n);
				int distance = edge.weight;
				int minDist = ind.minDistance + distance;
				//Update the minDist of the vertex in the queue
				updateMinDist(queue, n, minDist, ind);
			}
		}
		
	}

	private static void updateMinDist(PriorityQueue<Index> queue, Vertex n, int minDist, Index parent) {
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
		if(indToUpdate != null && minDist < indToUpdate.minDistance){
			queue.remove(indToUpdate);
			Index i = new Index();
			i.vert = n;
			i.minDistance = minDist;
			i.parent = parent.vert;
			
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
