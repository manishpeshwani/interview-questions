package com.manish.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort sorter = new MergeSort();
		int[] arr = {89,56,76,3,5,900,15,2};
		sorter.mergeSort(arr);
		
		Arrays.stream(arr).forEach(System.out::println);

	}

	private int[] mergeSort(int[] arr) {
		//If there are no elements or only one element then return the array back
		if(arr == null || arr.length == 1 || arr.length == 0){
			return arr;
		}
		//Find the middle index
		int mIndex = arr.length / 2;
		
		//Create left array and right array
		int[] lArr = new int[mIndex];
		int[] rArr = new int[arr.length - mIndex];
		
		System.arraycopy(arr, 0, lArr, 0, lArr.length);
		System.arraycopy(arr, mIndex, rArr, 0, rArr.length);
		
		mergeSort(lArr);
		mergeSort(rArr);
		
		sort(lArr, rArr, arr);
		
		return arr;
		
	}

	private void sort(int[] lArr, int[] rArr, int[] arr) {
		
		int lStart = 0;
		
		int rStart = 0;
		
		int tStart = 0;//targetIndex
		
		while(lStart < lArr.length && rStart < rArr.length ){
			if(lArr[lStart] < rArr[rStart]){
				arr[tStart] = lArr[lStart];
				lStart ++;
			}else{
				arr[tStart] = rArr[rStart];
				rStart ++;
			}
			tStart++;
		}
		
		System.arraycopy(lArr, lStart, arr, tStart, lArr.length - lStart);
		System.arraycopy(rArr, rStart, arr, tStart + (lArr.length - lStart), rArr.length - rStart);
	}

}
