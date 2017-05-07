package com.manish.heap;

import java.util.PriorityQueue;

/**
 * http://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 * 
 * @author manishpeshwani
 *
 */

public class MinCostNStrings {

	public static void main(String[] args) {
		int[] stringLengths = {2,3,4,6};
		
		
		
		System.out.println(minCost(stringLengths));

	}

	private static int minCost(int[] stringLengths) {
		int minCost = 0;
		
		if(stringLengths.length == 1){
			return minCost;
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0; i<stringLengths.length; i++){
			queue.offer(stringLengths[i]);
		}
		
		while(!queue.isEmpty()){
			int firstNumber = queue.poll();
			
			if(queue.isEmpty()){
				break;
			}
			
			int secondNumber = queue.poll();
			
			System.out.println(" Tie " + firstNumber + " and " + secondNumber);
		
			int cost = firstNumber + secondNumber;
			queue.offer(cost);
			minCost += cost;
		}
		
		return minCost;
	}

}
