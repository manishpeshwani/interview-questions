package com.manish.bitops;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3};
		
		List<Set<Integer>> listOfSets = new ArrayList<>();
		
		for(int i=0; i < 1<<arr.length;i++){
			Set<Integer> set = new HashSet<>();
			for(int j=0; j<arr.length; j++){
				if((i & 1<<j) >0){
					set.add(arr[j]);
				}
			}
			listOfSets.add(set);
		}
		
		System.out.println(listOfSets);

	}

}
