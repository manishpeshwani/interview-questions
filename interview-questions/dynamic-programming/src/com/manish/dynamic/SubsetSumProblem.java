package com.manish.dynamic;

public class SubsetSumProblem {

	public static void main(String[] args) {
		int sum = 11;
		
		int[] numbers = {2,3,8,10};
		
		//Create a 2 dimension matrix to capture 1 for true and 0 for false
		int[][] result = new int[numbers.length+1][sum+1];
		
		//Populate the 1st row with false i.e. 0 
		//This indicates that if there are no numbers then you dont have any subset and hence 0
		for(int i=0; i<sum+1;i++){
			result[0][i] = 0;
		}
		
		//Populate the 1st column as 1
		for(int i=0; i<numbers.length + 1; i++){
			result[i][0] = 1;
		}
		
		for(int i=0; i<numbers.length; i++){
			for(int j=1; j<sum+1; j++){
				//If the sum (i.e. value of j) is less than the number then the result is
				//result of the row above
				if(j<numbers[i]){
					result[i+1][j] = result[i][j];
				}else {
					//If the result of the row above is 1 then then the result is 1
					if(result[i][j] == 1){
						result[i+1][j] = 1;
					}else{
						//The result is result of sum - number from the row above.
						result[i+1][j] = result[i][j-numbers[i]];
					}
				}
			}
		}
		
		for(int i=0; i<numbers.length+1; i++){
			for(int j=0; j<sum+1; j++){
				System.out.print(result[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
