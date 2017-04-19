package com.manish.dynamic;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * @author manishpeshwani
 *
 */

public class RodcuttingProblem {

	public static void main(String[] args) {
		//Length of the rod
		int L = 8;
		
		//Value of the piece of rod. The value of 1 inch rod is 1 dollar, value of 2 inch rod is 5 dollar
		//and so and so forth
		int[] val = {1,5,8,9,10,17,17,20};
		int[] wt = {1,2,3,4,5,6,7,8};
		
		int[][] solution = new int[val.length + 1][L+1];
		
		//We keep the values in the rows and weights from 1 to n (here 8) in the columns
		//Set the first column as 0, this means that if we dont have any rod, we get 0 max value
		for(int i=0;i<=val.length;i++){
			solution[i][0] = 0;
		}
		
		//Fill first row with 0, this means that if we cant sell the rod, we get 0 max value
		for(int j=0; j<=L;j++){
			solution[0][j] = 0;
		}
		
		//Since we filled the first row and column with 0, start with i=0 and j=0
		for(int i=1; i<=val.length;i++){
			for(int j=1;j<=L;j++){
				int value = 0;
				//If the rods length is less than the length of the length of the piece that can be cut, then it means we cannot cut it in that size,
				//so it means we have to select the max value of the previous possible piece's max value
				if(j < wt[i-1]){
					value = solution[i-1][j];
				}else{
					//If the rod's length is greater than the length of the piece of rod that can be cut, then check if the value of the piece 
					//and the max value of remaining length is more than the max value of previous combination
					value = Math.max(solution[i-1][j], val[i-1] + solution[i-1][j-wt[i-1]]);
				}
				solution[i][j] = value;
			}
		}
		
		for(int i=0;i<=wt.length;i++){
	    	for(int j=0; j<=L;j++){
	    		System.out.print(solution[i][j]);
	    		System.out.print(" ");
	    	}
	    	System.out.println();
	    }
		
		System.out.println(solution[val.length][L]);

	}

}
