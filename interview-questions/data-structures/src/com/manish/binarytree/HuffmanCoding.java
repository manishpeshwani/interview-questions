package com.manish.binarytree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {
	
	public class HuffmanNode{
		public Character c;
		public int frequency;
		
		public HuffmanNode left;
		public HuffmanNode right;
		
		public String toString(){
			return "[" + c + "=" + frequency + "]";
		}
	}
	
	public class HuffmanComparator implements Comparator<HuffmanNode>{

		@Override
		public int compare(HuffmanNode o1, HuffmanNode o2) {
			if(o1.frequency < o2.frequency){
				return -1;
			}else if(o1.frequency > o2.frequency){
				return 1;
			}
			
			return 0;
		}
		
	}
	
	public static void main(String[] args){
		
		char input[] = {'a','b','c','d','e','f'};
		
		int freq[] = {5,9,12,13,16,45};
		
		HuffmanCoding huff = new HuffmanCoding();
		HuffmanNode root = huff.createTree(input, freq);
		
		Map<Character, String> newCodeMap = new HashMap<Character, String>();
		
		StringBuffer code = new StringBuffer();
		//code.append("0");
		huff.calculateNewCode(root, newCodeMap, code);
		
		System.out.println(newCodeMap);
	}

	private void calculateNewCode(HuffmanNode root, Map<Character, String> newCodeMap, StringBuffer code) {
		
		if(root == null){
			return;
		}
		
		if(root.left == null && root.right == null){
			newCodeMap.put(root.c, code.toString());
		}
		
		if(root.left != null){
			code.append("0");
			calculateNewCode(root.left, newCodeMap, code);
			code.deleteCharAt(code.length()-1);
		}
		
		if(root.right != null){
			code.append("1");
			calculateNewCode(root.right, newCodeMap, code);
			code.deleteCharAt(code.length()-1);
		}
		
		
		
	}

	private HuffmanNode createTree(char[] input, int[] freq) {
		//Create the priority queue with huffman comparator
		PriorityQueue<HuffmanNode> heap = new PriorityQueue<HuffmanNode>(new HuffmanComparator());
		
		for(int i=0; i<input.length;i++){
			HuffmanNode node = new HuffmanNode();
			node.c = input[i];
			node.frequency = freq[i];
			heap.offer(node);
		}
		
		System.out.println(heap);
		
		HuffmanNode parent = null;
		
		while(heap.size() > 1){
			HuffmanNode n1 = heap.poll();
			HuffmanNode n2 = heap.poll();
			parent = new HuffmanNode();
			parent.frequency =  n1.frequency + n2.frequency;
			parent.left = n1;
			parent.right = n2;
			
			heap.offer(parent);
		}
		
		return parent;
	}

}
