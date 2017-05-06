package com.manish.dynamic;
/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * 
 * @author manishpeshwani
 *
 */
public class MaximumEditDistance {

	public static void main(String[] args) {
		String s1 = "aebcdf";
		String s2 = "abcd";
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int[][] result = new int[s1.length() + 1][s2.length() + 1];
		
		
		for(int i=0; i<s1.length()+1; i++){
			for(int j=0;j<s2.length()+1;j++){
				if(i==0 && j==0){
					result[i][j] = 0;
					continue;
				}
				
				if(i==0){
					result[i][j] = i;
					continue;
				}
				
				if(j == 0){
					result[i][j] = j;
					continue;
				}
				
				if(c1[i-1] == c2[j-1]){
					result[i][j] = result[i-1][j-1];
				}else {
					result[i][j] = Math.min(result[i-1][j-1], Math.min(result[i-1][j], result[i][j-1])) + 1;
				}
			}
		}
		
		for(int i=0; i<s1.length()+1; i++){
			for(int j=0;j<s2.length()+1;j++){
				System.out.print(result[i][j]);
				System.out.print(" ");
			}
			
			System.out.println();
		}
		
		//Minimum operations required is the last value in the result array
		System.out.println(result[s1.length()][s2.length()]);

	}

}
