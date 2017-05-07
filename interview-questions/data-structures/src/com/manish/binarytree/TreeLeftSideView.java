package com.manish.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLeftSideView {

	public static void main(String[] args) {
		
		/**
		 * 				1
		 *      2              3 
		 *            5              4
		 *            					  6
		 */
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(6);
		
		List<TreeNode> result = leftSideView(root);
		
		System.out.println(result);

	}
	
	private static List<TreeNode> leftSideView(TreeNode root) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		result.add(root);
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		int currentLevel = 1;
		int nextLevel = 0;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			
			--currentLevel;
			
			if(node.left != null){
				queue.offer(node.left);
				nextLevel++;
				
				if(nextLevel == 1){
					result.add(node.left);
				}
			}
			
			if(node.right != null){
				queue.offer(node.right);
				nextLevel++;
				
				if(nextLevel == 1){
					result.add(node.right);
				}
			}
			
			
			
			if(currentLevel == 0){
				currentLevel = nextLevel;
				nextLevel = 0;
			}
			
		}
		
		return result;
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
