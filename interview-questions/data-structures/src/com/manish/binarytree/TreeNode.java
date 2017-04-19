package com.manish.binarytree;

public class TreeNode<T extends Comparable<T>> {
	
	private T value;
	
	private TreeNode<T> leftNode;
	
	private TreeNode<T> rightNode;
	
	public TreeNode(T value){
		this.value = value;
	}
	
	
	
	public T getValue() {
		return value;
	}



	public void setValue(T value) {
		this.value = value;
	}



	public TreeNode<T> getLeftNode() {
		return leftNode;
	}



	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}



	public TreeNode<T> getRightNode() {
		return rightNode;
	}



	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}



	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
	
	
	
}
