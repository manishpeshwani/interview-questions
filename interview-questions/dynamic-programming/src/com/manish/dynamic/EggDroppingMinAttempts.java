package com.manish.dynamic;

public class EggDroppingMinAttempts {

	public static void main(String[] args) {
		
		int floors = 100;
		
		int eggs = 2;
		
		int[][] results = new int[eggs][floors+1];
		
		for(int i=0;i<=floors;i++){
			//If there is only one egg then no of attempts equals to no of floors
			results[0][i] = i;
		}
		
		results[1][0] = 0;
		results[1][1] = 1;
		
		for(int i=2;i<=floors;i++){
			int minAttempt = Integer.MAX_VALUE;
			for(int k=1;k<=i;k++){
				int attempts = 1 + Math.max(results[0][k-1], results[1][i-k]);
				if(attempts < minAttempt){
					minAttempt = attempts;
				}
			}
			results[1][i] = minAttempt;
		}
		
		for(int i=0;i<2;i++){
			for(int j=0; j<=floors;j++){
				System.out.print(results[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
