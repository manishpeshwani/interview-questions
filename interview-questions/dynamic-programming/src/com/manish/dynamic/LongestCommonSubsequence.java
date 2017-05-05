package com.manish.dynamic;

import java.util.Stack;

/*
 * 
 * 
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		char[] arr1 = "ABCDGH".toCharArray();
		char[] arr2 = "AEDFHR".toCharArray();
		
		int[][] result = new int[arr1.length+1][arr2.length+1];
		
		
		
		for(int i=0; i<arr1.length; i++){
			for(int j=0;j<arr2.length; j++){
				if(arr1[i] == arr2[j]){
					result[i+1][j+1] = result[i][j] + 1;
				}else{
					result[i+1][j+1] = Math.max(result[i][j+1], result[i+1][j]);
				}
			}
		}
		
		for(int i=0; i<arr1.length+1; i++){
			for(int j=0;j<arr2.length+1; j++){
				System.out.print(result[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		//Print the common sequence
		Stack<Character> stack = new Stack<Character>();

		for(int i=arr1.length; i > 0; ){
			for(int j=arr2.length; j>0 ; ){
				
								
				if(result[i][j] != result[i-1][j] && result[i][j] != result[i][j-1]){
				//if(arr1[i-1] == arr2[j-1]){
					
					stack.push(arr1[i-1]);
					i--;
					j--;
				}else if (result[i][j] == result[i-1][j]){
					i--;
				}else {
					j--;
				}
				
				if(i==0 || j==0){
					i=0;
					j=0;
				}
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}

}
