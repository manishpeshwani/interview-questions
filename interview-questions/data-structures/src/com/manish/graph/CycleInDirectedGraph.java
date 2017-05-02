package com.manish.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleInDirectedGraph {

	public static void main(String[] args) {
		Graph g = new Graph(true);
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		Vertex five = new Vertex("5");
		Vertex six = new Vertex("6");
		
		g.addVertex(one);
		g.addVertex(two);
		g.addVertex(three);
		g.addVertex(four);
		g.addVertex(five);
		g.addVertex(six);
		
		Edge onetwo = new Edge(one, two, 0);
		Edge twothree = new Edge(two, three, 0);
		Edge onethree = new Edge(one, three, 0);
		Edge fourone = new Edge(four, one, 0);
		Edge fourfive = new Edge(four, five, 0);
		Edge fivesix = new Edge(five, six, 0);
		Edge sixfour = new Edge(six, four, 0);
		
		g.addEdge(onetwo);
		g.addEdge(twothree);
		g.addEdge(onethree);
		g.addEdge(fourone);
		g.addEdge(fourfive);
		g.addEdge(fivesix);
		g.addEdge(sixfour);
		
		CycleInDirectedGraph cyc = new CycleInDirectedGraph();
		System.out.println(cyc.findCycle(g));
		

	}
	
	public boolean findCycle(Graph g){
		Set<Vertex> whitelist = new HashSet<Vertex>();
		Set<Vertex> graylist = new HashSet<Vertex>();
		Set<Vertex> blacklist = new HashSet<Vertex>();
		
		
		Vertex[] vertices = g.vertices;
		
		for(int i=0; i<g.vSize;i++){
			whitelist.add(vertices[i]);
		}
		
		
		int i=0;
		while(whitelist.size() > 0){
			Vertex root = g.vertices[i++];
			if(dfs(g, root, whitelist, graylist, blacklist)){
				return true;
			}
		}
		
		return false;
	}

	private boolean dfs(Graph g, Vertex root, Set<Vertex> whitelist, Set<Vertex> graylist, Set<Vertex> blacklist) {
		
		moveVertex(root, whitelist, graylist);
		
		List<Vertex> neighbours = root.neighbours;
		
		for(Vertex v:neighbours){
			//If in blacklist, it is already fully explored, so no need to explore
			if(blacklist.contains(v)){
				continue;
			}
			
			//If in graylist means that it is still being explored and so we have found a cycle
			if(graylist.contains(v)){
				return true;
			}
			
			//If any child reports cycle, then return true
			if(dfs(g, v, whitelist, graylist, blacklist)){
				return true;
			}
		}
		
		moveVertex(root, graylist, blacklist);
		return false;
	}

	private void moveVertex(Vertex root, Set<Vertex> sourcelist, Set<Vertex> destlist) {
		sourcelist.remove(root);
		
		destlist.add(root);
		
	}

}
