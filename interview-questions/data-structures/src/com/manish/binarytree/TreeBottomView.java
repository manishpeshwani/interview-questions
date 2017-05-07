package com.manish.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * http://www.geeksforgeeks.org/bottom-view-binary-tree/
 * 
 * @author manishpeshwani
 *
 */

public class TreeBottomView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        
        root.hd = 0;
        
        List<TreeNode> result = bottomView(root);
        
        System.out.println(result);

	}
	
	private static List<TreeNode> bottomView(TreeNode root) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		HashMap<Integer, TreeNode> hdMap = new HashMap<>();
		hdMap.put(root.hd, root);
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node.left != null){
				int hd = node.hd -1;
				node.left.hd = hd;
				hdMap.put(hd, node.left);
				queue.offer(node.left);
			}
			
			if(node.right != null){
				int hd = node.hd + 1;
				node.right.hd = hd;
				hdMap.put(hd, node.right);
				queue.offer(node.right);
			}
		}
		
		//Iterate through the hdMap and place the nodes in result
		Iterator<Integer> iter = hdMap.keySet().iterator();
		
		while(iter.hasNext()){
			result.add(hdMap.get(iter.next()));
		}
		
		
		return result;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		int hd;
		
		public TreeNode(int val){
			this.val = val;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
		
		
	}

}
