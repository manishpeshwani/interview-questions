package com.manish.sorting;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertLastElementToSortedArray {

	public static void insertIntoSorted(int[] ar) {
		int lastVal = ar[ar.length - 1];
		boolean placed = false;
		for (int i = ar.length - 1; i > 0; i--) {
			if (ar[i-1] >= lastVal) {
				ar[i] = ar[i - 1];

			} else {

				ar[i] = lastVal;
				placed = true;	
				break;
			}

			printArray(ar);

		}
		
		if(!placed){
			ar[0] = lastVal;
		}
		printArray(ar);
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
