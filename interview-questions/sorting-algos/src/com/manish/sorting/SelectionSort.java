package com.manish.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort sorter = new SelectionSort();
		int[] arr = {89,56,76,3,5,900,15};
		sorter.sort(arr);
		
		Arrays.stream(arr).forEach(System.out::println);
	}
	
	public void sort(int[] arr){
		
		//Iterate through the loop, find the smallest value and place it at the ith index
		for(int i=0; i<arr.length-1;i++){
			int minIndex =i;
			for(int j=i;j<arr.length;j++ ){
				if(arr[j] < arr[minIndex]){
					int temp = arr[j];
					arr[j] = arr[minIndex];
					arr[minIndex] = temp;
					
				}
			}
		}
	}

}
