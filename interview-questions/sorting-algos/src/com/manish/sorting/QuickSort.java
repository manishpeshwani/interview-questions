package com.manish.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		//int[] arr = new int[]{5, 8, 1, 3, 7, 9, 2};
		
		int[] arr = new int[]{1, 3, 9, 8, 2, 7, 5};
		
		sort(arr);
		
		//System.out.println(Arrays.toString(arr));

	}

	private static void sort(int[] arr) {
		quickSort(arr, 0,arr.length-1);
		
	}
	
	private static void quickSort(int[] arr, int l, int r){
		if(arr.length == 0|| arr.length == 1){
			System.out.println(arr[l]);
			return;
		}
		
		int lowerBound = l;
		int upperBound = r;
		
		//int pivotIndex = (l+r)/2;
		int pivotIndex = r;
		int pivot = arr[pivotIndex];
		
		while(l <= r){
			while(arr[l] < pivot){
				l++;
			}
			
			while(arr[r] > pivot){
				r--;
			}
			
			if(l <= r){
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}
		
		if(lowerBound < r){
			quickSort(arr, lowerBound, r);
		}
		
		if(upperBound > l){
			quickSort(arr, l, upperBound);
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

}
