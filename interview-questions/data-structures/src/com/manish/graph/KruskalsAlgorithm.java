package com.manish.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.manish.graph.DisjointSet.Node;

public class KruskalsAlgorithm {

	public static void main(String[] args) {
		Graph graph = new Graph(false);
		
		Vertex a = new Vertex("a");//1
		Vertex b = new Vertex("b");//2
		Vertex c = new Vertex("c");//3
		Vertex d = new Vertex("d");//4
		Vertex e = new Vertex("e");//5
		Vertex f = new Vertex("f");//6
		Vertex g = new Vertex("g");
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		
		Edge ab = new Edge(a, b, 4);
		Edge ac = new Edge(a, c, 1);
		Edge be = new Edge(b, e, 1);
		Edge bf = new Edge(b, f, 3);
		Edge bd = new Edge(b, d, 2);
		Edge fe = new Edge(f, e, 2);
		Edge fd = new Edge(f, d, 3);
		Edge dg = new Edge(d, g, 2);
		Edge cd = new Edge(c, d, 5);
		Edge cg = new Edge(c, g, 8);
		
        graph.addEdge(ab);
        graph.addEdge(ac);
        graph.addEdge(be);
        graph.addEdge(bf);
        graph.addEdge(bd);
        graph.addEdge(fe);
        graph.addEdge(fd);
        graph.addEdge(dg);
        graph.addEdge(cd);
        graph.addEdge(cg);
        
        List<Edge> mst = kurskalMST(graph);
        
        System.out.println(mst);

	}

	private static List<Edge> kurskalMST(Graph gr) {
		//Get all edges and sort them by weight in descending order
		Edge[] edges = gr.edges;
		
		Arrays.sort(edges, new Comparator<Edge>(){

			@Override
			public int compare(Edge o1, Edge o2) {
				if(o1 == null){
					return 1;
				}
				
				if(o2 == null){
					return -1;
				}
				return o1.weight - o2.weight;
			}});
		
		DisjointSet<Vertex> djSet = new DisjointSet<Vertex>();
		
		//Create disjoint sets for each vertex
		for(int i=0; i<gr.vSize;i++){
			djSet.makeSet(gr.vertices[i]);
		}
		
		//Maintain a list of edges in MST
		List<Edge> mstList = new ArrayList<Edge>();
		
		for(int k=0;k<gr.eSize;k++){
			Edge edge = gr.edges[k];
			Vertex s = edge.source;
			Vertex d = edge.destination;
			
			//If the source and destination vertex of the edge are in the same disjoint set then continue
			//else add it in the mst list and put the source and destination vertex in the same set
			if(djSet.findSet(s).data == djSet.findSet(d).data){
				continue;
			}else{
				mstList.add(edge);
				djSet.union(s, d);
			}
			
		}
		
		return mstList;
	}

}
