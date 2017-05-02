package com.manish.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph graph = new Graph(true);
		
		Vertex a = new Vertex("a");//0
		Vertex b = new Vertex("b");//1
		Vertex c = new Vertex("c");//2
		Vertex d = new Vertex("d");//3
		Vertex e = new Vertex("e");//4
		Vertex f = new Vertex("f");//5
		
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		
		graph.addEdge(new Edge(f, a, 0));
		graph.addEdge(new Edge(f, c, 0));
		graph.addEdge(new Edge(e, a, 0));
		graph.addEdge(new Edge(e, b, 0));
		graph.addEdge(new Edge(d, b, 0));
		graph.addEdge(new Edge(c, d, 0));
		
		Set<Vertex> visitedSet = new HashSet<Vertex>();
		Stack<Vertex> stack = new Stack<Vertex>();
		topologocialSort(graph, stack, visitedSet);
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
			System.out.print(" ");
		}

	}

	private static void topologocialSort(Graph graph, Stack<Vertex> stack, Set<Vertex> visited) {
				
		for(int i=0; i<graph.vSize;i++){
			Vertex v = graph.vertices[i];
			
			if(visited.contains(v)){
				continue;
			}
			
			//Perform topological sort
			
			topologicalSortUtil(v, stack, visited, graph);
			
		}
		
	}

	private static void topologicalSortUtil(Vertex v, Stack<Vertex> stack, Set<Vertex> visited, Graph graph) {
		//If it has reached here means it is not in the visited set
		//So add the vertex in the set first
		visited.add(v);
		
		for(int k=0;k<v.neighbours.size();k++){
			Vertex neighbour = v.neighbours.get(k);
			if(visited.contains(neighbour)){
				continue;
			}
			topologicalSortUtil(neighbour, stack, visited, graph);
		}
		
		stack.push(v);
		
	}

}
