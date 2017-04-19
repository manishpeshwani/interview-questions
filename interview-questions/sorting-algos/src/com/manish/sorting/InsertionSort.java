package com.manish.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort sorter = new InsertionSort();
		int[] arr = {89,56,76,3,5,900,15,2};
		sorter.sort(arr);
		
		Arrays.stream(arr).forEach(System.out::println);

	}

	private void sort(int[] arr) {
		for(int i=0; i<arr.length;i++){
			for(int j=0; j<=i;j++){
				if(arr[i]<arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}

}
