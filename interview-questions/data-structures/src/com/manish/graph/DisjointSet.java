package com.manish.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Each set will be represented by its parent node
 * 
 * @author manishpeshwani
 *
 */
public class DisjointSet<T> {
	
	//Map of value and parent node
	private Map<T, Node<T>> map = new HashMap<>();
	
	class Node<T> {
		T data;
		Node<T> parent;
		int rank;
		
		@Override
		public String toString() {
			if(parent== null){
				return "Node [data=" + data +  " rank=" + rank + "]";
			}else{
				return "Node [data=" + data +  " rank=" + rank + "  parent " + parent.data + " ]";
			}
		}
		
		
	}
	
	public void makeSet(T data){
		
		Node<T> node = new Node<>();
		node.data = data;
		node.parent = node;//Set parent as itself 
		node.rank = 0;//Start with 0 rank to begin with
		
		//Place the node in the map
		map.put(data, node);
		
	}
	
	public boolean union(T data1, T data2){
		
		Node<T> parent1 = findSet(data1);
		Node<T> parent2 = findSet(data2);
		
		if(parent1.data == parent2.data){
			return true;
		}
		
		if(parent1.rank >= parent2.rank){
			parent2.parent = parent1;
			//increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
		}else {
			parent1.parent = parent2;
			parent2.rank = (parent1.rank == parent2.rank) ? parent2.rank + 1 : parent2.rank;
		}
		
		return false;
	}

	//Return the parent node and reset the parent to the topmost parent node (path compression)
	public Node<T> findSet(T data) {
		Node<T> node = map.get(data);
		Node<T> parent = node.parent;
		
		//If the node is the topmost parent, then its value will be same as the node's value
		if(parent.data == node.data){
			return parent;
		}
		
		//Find the parent of the parent, by passing parent's value in findSet
		node.parent = findSet(parent.data);
		
		return node.parent;
	}
	
	public static void main(String[] args){
		DisjointSet<Integer> ds = new DisjointSet<>();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1).data);
        System.out.println(ds.findSet(2).data);
        System.out.println(ds.findSet(3).data);
        System.out.println(ds.findSet(4).data);
        System.out.println(ds.findSet(5).data);
        System.out.println(ds.findSet(6).data);
        System.out.println(ds.findSet(7).data);
	}

}
