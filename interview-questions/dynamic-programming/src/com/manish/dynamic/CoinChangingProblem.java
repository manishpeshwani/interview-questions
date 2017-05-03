package com.manish.dynamic;

import java.util.Arrays;

public class CoinChangingProblem {

	public static void main(String[] args) {
		int total = 13;
		int[] coinDenominations = new int[]{7,2,3,6};
		
		//initialize int array to capture min number of coins
		int[] minCoinArr = new int[total + 1];
		
		minCoinArr[0] = 0;
		for(int i=1; i<total+1;i++){
			minCoinArr[i] = 1000;//Dont set to MAX_VALUE
		}
		
		//initialize int array to capture the index of the coin contributing to the min number of coins
		int[] coinIndex = new int[total + 1];
		
		for(int i=0; i<coinIndex.length;i++){
			coinIndex[i] = -1;
		}
		
		for(int j=0;j<coinDenominations.length;j++){
			for(int i=0; i<minCoinArr.length;i++){
				int coinValue = coinDenominations[j];
				
				if(i < coinValue){
					continue;
				}
				
				if(minCoinArr[i] > minCoinArr[i-coinValue] + 1){
					minCoinArr[i] = minCoinArr[i-coinValue] + 1;
					coinIndex[i] = j;
				}
				
			}
		}
		
		System.out.println(Arrays.toString(minCoinArr));
		System.out.println(Arrays.toString(coinIndex));
		
		//Min coins required for total of 13 given 7,2,3 and 6 as coin denominations
		System.out.println(minCoinArr[total]);
		
		//Coins contributing to the min coins
		int k = 13;
		while(k>0){
			System.out.print(coinDenominations[coinIndex[k]]);
			System.out.print(" ");
			k = k - coinDenominations[coinIndex[k]];
		}

	}

}
