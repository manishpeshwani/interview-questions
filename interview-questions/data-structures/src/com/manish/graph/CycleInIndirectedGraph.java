package com.manish.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CycleInIndirectedGraph {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		g.addVertex(e);
		g.addVertex(f);
		
		Edge ab = new Edge(a, b, 0);
		Edge bc = new Edge(b, c, 0);
		Edge cd = new Edge(c, d, 0);
		Edge de = new Edge(d, e, 0);
		Edge ef = new Edge(e, f, 0);
		Edge fc = new Edge(f, c, 0);
		
		
		g.addEdge(ab);
		g.addEdge(bc);
		g.addEdge(cd);
		g.addEdge(de);
		g.addEdge(ef);
		//g.addEdge(fc);
		
		System.out.println(findCycleWithDisjointSet(g));
		
		System.out.println(findCycleWithDFS(g));

	}

	private static boolean findCycleWithDisjointSet(Graph g) {
		
		DisjointSet<Vertex> set = new DisjointSet<>();
		
		for(Vertex v:g.vertices){
			set.makeSet(v);
		}
		
		for(int i=0; i<g.eSize;i++){
			Edge e = g.edges[i];
			Vertex s = e.source;
			Vertex d = e.destination;
			
			Vertex p1 = set.findSet(s).data;
			Vertex p2 = set.findSet(d).data;
			
			if(p1.equals(p2)){
				return true;
			}
			
			set.union(s, d);
			
		}
		
		return false;
	}
	
	private static boolean findCycleWithDFS(Graph g){
		Set<Vertex> visited = new HashSet<Vertex>();
		
		for(int i=0; i<g.vSize;i++){
			Vertex v =  g.vertices[i];
			if(visited.contains(v)){
				continue;
			}else{
				
				
					if(findCycleWithDFS(g, v, null, visited)){
						return true;
					}
				
			}
		}
		
		return false;
		
	}

	private static boolean findCycleWithDFS(Graph g, Vertex v, Vertex parent, Set<Vertex> visited) {
		visited.add(v);
		
		for(Vertex n: v.neighbours){
			if(n.equals(parent)){
				return false;
			}
			
			if(visited.contains(n)){
				return true;
			}
			if(findCycleWithDFS(g, n, v, visited)){
				return true;
			}
		}
		return false;
	}
	

}
