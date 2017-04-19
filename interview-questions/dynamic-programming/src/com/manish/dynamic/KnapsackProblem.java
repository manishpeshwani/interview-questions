package com.manish.dynamic;

/**
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java
 * 
 * @author manishpeshwani
 *
 */

public class KnapsackProblem {

	public static void main(String[] args) {
		
		// Value of the weights
		int val[] = {60, 100, 120};
		//Array of weights
	    int wt[] = {10, 20, 30};
	    //Total weight allowed
	    int  W = 50;
	    
	    int[][] solution = new int[wt.length+1][W+1];
	    
	    //Fill the first column for each row with 0
	    //This indicates that if we dont have a sack we cant pick any item
	    for(int i=0; i< wt.length;i++){
	    	solution[i][0]=0;
	    }
	    
	    //Fill the first row for each column with 0
	    //This indicates that if we have a sack but no item to pick then total value is 0
	    for(int i=0; i<=W;i++){
	    	solution[0][i] = 0;
	    }
	    
	    
	    //Since the first row and column are set to zero, start with i=1 and j=1
	    for(int i=1; i<=wt.length;i++){
	    	for(int j=1;j<=W; j++){
	    		int value = 0;
	    		//If the weight allowed is less than the weight of the item then 
	    		if(j < wt[i-1]){
	    			//This means that you cannot select the current item and whatever value was the best value
	    			//while selecting the previous item is the max value
	    			value = solution[i-1][j];
	    		}else {
	    			//If the value of j (i.e. allowed weight) is greater than the current items weight, then
	    			//the current item is eligible to be selected. In this case the value set should be the max of current
	    			//items weight + the max value of the weight left and the max value if this item is not selected
	    			value = Math.max(val[i-1] + solution[i-1][j-wt[i-1]], solution[i-1][j]);
	    		}
	    		solution[i][j] = value;
	    		//System.out.println(value);
	    	}
	    }
	    
	    for(int i=0;i<=wt.length;i++){
	    	for(int j=0; j<=W;j++){
	    		System.out.print(solution[i][j]);
	    		System.out.print(" ");
	    	}
	    	System.out.println();
	    }
	    
	    System.out.println(solution[wt.length][W]);

	}

}
