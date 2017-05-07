package com.manish.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		
		List<TreeNode> result = rightSideView(root);
		
		System.out.println(result);

	}
	
	private static List<TreeNode> rightSideView(TreeNode root) {
		
		List<TreeNode> rightSideNodes = new ArrayList<TreeNode>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		//Since the root level has only one node, set the currentLevel count as 1
		int currentLevel = 1;
		
		//Keep the count of the next level nodes with this counter
		int nextLevel = 0;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			--currentLevel;
			
			if(node.left != null){
				queue.offer(node.left);
				nextLevel++;
			}
			
			if(node.right != null){
				queue.offer(node.right);
				nextLevel++;
			}
			
			//This means you have polled all items at the current level
			if(currentLevel == 0){
				rightSideNodes.add(node);
				currentLevel = nextLevel;
				nextLevel=0;//reset next level count as we move to next level
			}
		}
		
		return rightSideNodes;
		
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
		
		
	}

}
