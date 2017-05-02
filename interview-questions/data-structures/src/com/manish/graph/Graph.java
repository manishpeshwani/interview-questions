package com.manish.graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {
	
	int MAX_VERTICES = 20;
	int vSize = 0;
	int eSize = 0;
	
	boolean directional = false;
	
	Graph(boolean directional){
		this.directional = directional;
	}
	
	Vertex[] vertices = new Vertex[MAX_VERTICES];
	
	Edge[] edges = new Edge[MAX_VERTICES-1];
	
	public void addVertex(Vertex v){
		vertices[vSize++] = v; 
		
	}
	
	public void addEdge(Edge e){
		e.source.neighbours.add(e.destination);
		if(!directional){
			e.destination.neighbours.add(e.source);
		}
		edges[eSize] = e;
		eSize++;
	}
	
	public void dfs(){
		Stack<Vertex> s = new Stack<Vertex>();
		
		Vertex currentNode = vertices[0];//Start dfs here
		s.push(currentNode);
		currentNode.isVisited = true;
		
		System.out.println(currentNode);
				
		while(!s.isEmpty()){
			currentNode = s.peek();
			List<Vertex> neighbours = currentNode.neighbours;
			Vertex nextUnvisitedNode = null;
			for(Vertex x: neighbours){
				if(!x.isVisited){
					s.push(x);
					x.isVisited = true;
					currentNode = x;
					nextUnvisitedNode = x;
					System.out.println(currentNode);
					break;
				}
			}
			if(nextUnvisitedNode == null){
				s.pop();//If no unvisitedNode then pop
			}
		}
		
		for(int i=0;i<vSize;i++){
			vertices[i].isVisited = false;
		}
		
	}
	
	public void bfs(){
		Deque<Vertex> queue = new LinkedList<Vertex>();
		Vertex currentNode = vertices[0];
		currentNode.isVisited = true;
		
		queue.offer(currentNode);
		
		while(!queue.isEmpty()){
			Vertex v = queue.poll();
			System.out.println(v);
			List<Vertex> n = v.neighbours;
			for(int i=0;i<n.size();i++){
				if(!n.get(i).isVisited){
					n.get(i).isVisited = true;
					queue.offer(n.get(i));
				}
			}
		}
		
		for(int i=0;i<vSize;i++){
			vertices[i].isVisited = false;
		}
	}
	
	

}
