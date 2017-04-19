package com.manish.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {

	public TreeNode<T> rootNode;

	public TreeNode<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode<T> rootNode) {
		this.rootNode = rootNode;
	}

	public void addNode(TreeNode<T> node) {
		if (rootNode == null) {
			rootNode = node;
			return;
		}

		// Start from root
		TreeNode<T> parent = rootNode;

		// Compare values now
		while (true) {
			if (node.getValue().compareTo(parent.getValue()) < 0) {
				// go left
				if (parent.getLeftNode() == null) {
					parent.setLeftNode(node);
					return;
				} else {
					parent = parent.getLeftNode();
					continue;
				}
			} else {
				if (parent.getRightNode() == null) {
					parent.setRightNode(node);
					return;
				} else {
					parent = parent.getRightNode();
					continue;
				}
			}
		}
	}

	// Breadth first traversal
	public void bfsTraversal(TreeNode<T> node) {
		if (node == null) {
			return;
		}

		Deque<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			TreeNode<T> tNode = queue.pop();
			System.out.println(tNode.getValue());
			if (tNode.getLeftNode() != null) {
				queue.offer(tNode.getLeftNode());
			}

			if (tNode.getRightNode() != null) {
				queue.offer(tNode.getRightNode());
			}
		}
	}

	public void dfsInOrderTraversal(TreeNode<T> node) {
		if (node == null) {
			return;
		}

		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(node);

		// Keep pushing the left node till there is no left node left
		while (node.getLeftNode() != null) {
			stack.push(node.getLeftNode());
			node = node.getLeftNode();
		}

		while (!stack.isEmpty()) {
			TreeNode<T> tNode = stack.pop();

			System.out.println(tNode.getValue());
			TreeNode<T> rNode = tNode.getRightNode();
			if (rNode != null) {
				stack.push(rNode);
				// Keep pushing the left node till there is no left node left
				while (rNode.getLeftNode() != null) {
					stack.push(rNode.getLeftNode());
					rNode = rNode.getLeftNode();
				}
			}
		}

	}
	
	public void dfsPreOrderTraversal(TreeNode<T> node){
		if (node == null) {
			return;
		}

		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(node);
		
		while(!stack.isEmpty()){
			TreeNode<T> tNode = stack.pop(); 
			System.out.println(tNode.getValue());
			if(tNode.getRightNode() != null){
				stack.push(tNode.getRightNode());
			}
			if(tNode.getLeftNode() != null){
				stack.push(tNode.getLeftNode());
			}
		}
	}
	
	public void dfsPostOrderTraversal(TreeNode<T> node){
		
		if (node == null) {
			return;
		}

		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(node);
		
		TreeNode<T> prev = null;
		
		while(!stack.isEmpty()){
			
			TreeNode<T> current = stack.peek();
			
			if(prev == null || prev.getLeftNode() == current || prev.getRightNode() == current){
				
			}
			
		}
	}

	public void inOrderTraversal(TreeNode<T> node) {

		// Terminal condition
		if (node == null) {
			return;
		}

		if (node.getLeftNode() != null) {
			inOrderTraversal(node.getLeftNode());
		}

		System.out.println(node.getValue());

		if (node.getRightNode() != null) {
			inOrderTraversal(node.getRightNode());
		}

	}

	public void preOrderTraversal(TreeNode<T> node) {
		// Terminal condition
		if (node == null) {
			return;
		}

		System.out.println(node.getValue());

		if (node.getLeftNode() != null) {
			preOrderTraversal(node.getLeftNode());
		}

		if (node.getRightNode() != null) {
			preOrderTraversal(node.getRightNode());
		}
	}
	
	public void postOrderTraversal(TreeNode<T> node){
		if(node == null){
			return;
		}
		
		if(node.getLeftNode() != null){
			postOrderTraversal(node.getLeftNode());
		}
		
		if(node.getRightNode() != null){
			postOrderTraversal(node.getRightNode());
		}
		
		System.out.println(node.getValue());
		
	}
	
    public int findHeightRecursive(TreeNode<T> node){
    	if(node == null){
    		return -1;
    	}
    	
    	return 1 + Math.max(findHeightRecursive(node.getLeftNode()) , findHeightRecursive(node.getRightNode()));
    }
	
	public int findHeight(TreeNode<T> node){
		int maxHeight = 0;
		
		if(node == null){
			return maxHeight;
		}
		
		int height = 0;
		
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(node);
		height++;
		
		while(node.getLeftNode() != null){
			node = node.getLeftNode();
			stack.push(node);
			height++;
		}
		
		//Max left depth
		maxHeight = height;
		
		System.out.println("maxHeight:" + maxHeight);
		while(!stack.isEmpty()){
			TreeNode<T> tNode = stack.pop();
			height--;
			
			if(tNode.getRightNode() != null){
				tNode = tNode.getRightNode();
				stack.push(tNode);
				height++;
				
				while(tNode.getLeftNode() != null){
					tNode = tNode.getLeftNode();
					stack.push(tNode);
					height++;
				} 
			}
			
			if(maxHeight < height){
				maxHeight = height;
			}
			System.out.println("maxHeight:" + maxHeight);
		}
		
		return maxHeight;
		
	}
	
	public int findSize(TreeNode<T> node){
		if(node == null){
			return 0;
		}
		
		int lSize = 0;
		int rSize = 0;
		
		if(node.getLeftNode() != null){
			lSize = findSize(node.getLeftNode());
		}
		
		if(node.getRightNode() != null){
			rSize = findSize(node.getRightNode());
		}
		
		return rSize + lSize + 1;
	}
	
	public void printLeftView(TreeNode<T> node){
		
		Map<Integer, List<TreeNode<T>>> levelNodes = new HashMap<Integer, List<TreeNode<T>>>();
		
		
		collectLevelNodes(node, 0, levelNodes);
		
		for(List<TreeNode<T>> l : levelNodes.values()){
			System.out.print(l.get(0));
			System.out.print(" ");
		}
	}
	
	public void printBottomView(TreeNode<T> node){
		
		Map<Integer, List<TreeNode<T>>> levelNodes = new HashMap<Integer, List<TreeNode<T>>>();
		
		
		collectLevelNodes(node, 0, levelNodes);
		
		int size = levelNodes.size();
		System.out.println();
		levelNodes.get(size -1).forEach(System.out::print);
	}

	private void collectLevelNodes(TreeNode<T> node, int level, Map<Integer, List<TreeNode<T>>> levelNodes) {
		
		List<TreeNode<T>> nodes = levelNodes.getOrDefault(level, new ArrayList<TreeNode<T>>());
		nodes.add(node);
		levelNodes.put(level, nodes);
		
		if(node.getLeftNode() != null){
			collectLevelNodes(node.getLeftNode(), level + 1, levelNodes);
		}
		
		if(node.getRightNode() != null){
			collectLevelNodes(node.getRightNode(), level + 1, levelNodes);
		}
		
	}

}
