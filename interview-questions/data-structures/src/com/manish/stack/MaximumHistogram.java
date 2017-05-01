package com.manish.stack;

import java.util.Stack;

public class MaximumHistogram {

	public static void main(String[] args) {
		int[] heights = {6,2,5,4,5,1,6};
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int maxArea = 0;
		
		//stack.push(0);
		
		int i;
		for(i=0; i<heights.length;){
			
			//Keep pushing the index on stack till the height of the block is higher than previous one
			//Increment the index value i.e. i++
			if(stack.isEmpty() || heights[i] > heights[stack.peek()]){
				stack.push(i++);
			}else {
				//Till the previous value is equal to lower than the current height keep popping out values from stack
				while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
					int top = stack.pop();
					int area =0;
					//If the stack is empty then calculate area by multiplying with value of i
					if(stack.isEmpty()){
						area = heights[top] * i;
						
					}else {
						area = heights[top]*(i-stack.peek() -1);
					}
					if(area > maxArea){
						maxArea = area;
					}
				}
			}
			
		}
		
		while(!stack.isEmpty()){
			int top = stack.pop();
			int area = 0;
			if(stack.isEmpty()){
				area = heights[top]*i;
			}else {
				area = heights[top]*(i-stack.peek() -1);
			}
			
			if(area > maxArea){
				maxArea = area;
			}
		}
		
		System.out.println(maxArea);

	}

}
