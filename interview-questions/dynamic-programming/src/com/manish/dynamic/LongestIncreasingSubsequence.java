package com.manish.dynamic;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {3 , 4, -1, 0, 6, 3, 5, 7, 8};
		
		int[] result = new int[arr.length];
		
		//Initialize the result with 1 as minimum increasing subsequence at each index is 1
		for(int k=0; k<arr.length; k++){
			result[k] = 1;
		}
		
		for(int i=1; i<arr.length; i++){
			int maxVal = result[i];
			for(int j=0; j<i; j++){
				//If the value before is less than the current value then
				//the longest subsequence will be 1 plus the longest subsequence of prev value
				if(arr[j]<arr[i]){
					maxVal = result[j] + 1;
				}
			}
			
			result[i] = maxVal;
		}
		
		//Print the longest increasing subsequence at each index
		for(int k=0; k<result.length;k++){
			System.out.print(result[k]);
			System.out.print(" ");
		}
		
		System.out.println();

	}

}
