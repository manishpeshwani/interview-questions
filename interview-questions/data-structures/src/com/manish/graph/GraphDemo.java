package com.manish.graph;

public class GraphDemo {
	
	public static void main(String[] args){
		Graph g = new Graph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
				
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		g.addVertex(e);
		
		Edge ab = new Edge(a, b, 0);
		Edge bc = new Edge(b, c, 0);
		Edge ad = new Edge(a, d, 0);
		Edge de = new Edge(d, e, 0);
		Edge dc = new Edge(d, c, 0);
		
		
		
		g.addEdge(ab);
		g.addEdge(bc);
		g.addEdge(ad);
		g.addEdge(de);
		g.addEdge(dc);
		
		g.dfs();
		System.out.println();
		g.bfs();
	}

}
