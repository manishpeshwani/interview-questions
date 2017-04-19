package com.manish.binarytree;

public class TestBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(5);
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.addNode(rootNode);
		
		TreeNode<Integer> node1 = new TreeNode<Integer>(20);
		tree.addNode(node1);
		
		TreeNode<Integer> node2 = new TreeNode<Integer>(4);
		tree.addNode(node2);
		
		TreeNode<Integer> node3 = new TreeNode<Integer>(16);
		tree.addNode(node3);
		
		TreeNode<Integer> node4 = new TreeNode<Integer>(1);
		tree.addNode(node4);
		
		TreeNode<Integer> node5 = new TreeNode<Integer>(8);
		tree.addNode(node5);
		
		TreeNode<Integer> node6 = new TreeNode<Integer>(7);
		tree.addNode(node6);
		
		TreeNode<Integer> node7 = new TreeNode<Integer>(6);
		tree.addNode(node7);
		
		TreeNode<Integer> node8 = new TreeNode<Integer>(3);
		tree.addNode(node8);
		
		TreeNode<Integer> node9 = new TreeNode<Integer>(15);
		tree.addNode(node9);
		
		TreeNode<Integer> node10 = new TreeNode<Integer>(9);
		tree.addNode(node10);
		
		//tree.bfsTraversal(rootNode);
		
		//tree.dfsInOrderTraversal(rootNode);
		
		//tree.inOrderTraversal(rootNode);
		//tree.preOrderTraversal(rootNode);
		
		tree.postOrderTraversal(rootNode);
		
		//tree.dfsPreOrderTraversal(rootNode);
		
		//tree.dfsPostOrderTraversal(rootNode);
		
		System.out.println("max height is :" + tree.findHeight(rootNode));
		
		System.out.println("max height is :" + tree.findHeightRecursive(rootNode));
		
		System.out.println("size of the tree is:" + tree.findSize(rootNode));
		
		System.out.println(" Left View:" );
		tree.printLeftView(rootNode);
		tree.printBottomView(rootNode);

	}

}
