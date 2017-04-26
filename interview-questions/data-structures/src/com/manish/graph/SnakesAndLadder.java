package com.manish.graph;

import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class SnakesAndLadder {
	
	static class Node {
		int label;
		int distance;
		
		@Override
		public String toString() {
			return "Node [label=" + label + ", distance=" + distance + "]";
		}
		
		
	}

	public static void main(String[] args) {
		int N = 30;
	    int[] moves = new int[N];
	    for (int i = 0; i<N; i++)
	        moves[i] = -1;
	 
	    // Ladders
	    moves[2] = 21;
	    moves[4] = 7;
	    moves[10] = 25;
	    moves[19] = 28;
	 
	    // Snakes
	    moves[26] = 0;
	    moves[20] = 8;
	    moves[16] = 3;
	    moves[18] = 6;
	    
	    System.out.println(findMinMoves(N, moves));

	}

	private static int findMinMoves(int n, int[] moves) {
		Deque<Node> q = new LinkedList<Node>();
		int[] visited = new int[n];
		
		for(int i=0; i<n;i++){
			visited[i] = 0;
		}
		
		List<Node> finalList = new LinkedList<Node>();
		
		Node startNode = new Node();
		startNode.distance = 0;
		startNode.label = 0;
		
		q.offer(startNode);
		visited[0] = 1;
		
		Node node = null;
		while(!q.isEmpty()){
			node = q.peek();
			if(node.label == n-1){
				break;
			}
			
			q.poll();
			
			for(int k=node.label + 1;k<=(node.label + 6) && k<n ;k++){
				if(visited[k] == 0){
					
					// Otherwise calculate its distance and mark it
	                // as visited
	                Node a = new Node();
	                a.distance= (node.distance + 1);
	                visited[k] = 1;
	 
	                // Check if there a snake or ladder at 'j'
	                // then tail of snake or top of ladder
	                // become the adjacent of 'i'
	                if (moves[k] != -1)
	                    a.label = moves[k];
	                else
	                	a.label = k;
	                q.offer(a);
					
	                finalList.add(a);
				}
			}
		}
		
		System.out.println(finalList);
		return node.distance;
		
	}

}
