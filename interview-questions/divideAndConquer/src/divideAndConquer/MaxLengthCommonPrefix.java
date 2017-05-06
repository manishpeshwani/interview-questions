package divideAndConquer;

/**
 * 
 * 
Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"


http://www.geeksforgeeks.org/longest-common-prefix-set-3-divide-and-conquer/
 * 
 * 
 * 
 * @author manishpeshwani
 *
 */

public class MaxLengthCommonPrefix {

	public static void main(String[] args) {
		//String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
		String[] arr = {"apple","ape","april"};
		
		String prefix = commonPrefix(arr, 0, arr.length-1);
		System.out.println(prefix);
	}

	private static String commonPrefix(String[] arr, int start, int end) {
		
		if(start == end){
			return arr[0];
		}
		
		if(end - start == 1){
			StringBuilder prefix = new StringBuilder();
			//Find the min length
			int i = Math.min(arr[start].length(), arr[end].length());
			for(int k=0; k<i; k++){
				if(arr[start].charAt(k) == arr[end].charAt(k)){
					prefix.append(arr[0].charAt(k));
				}else {
					break;
				}
			}
			
			return prefix.toString();
		}
		
		//Divide in 2 halves
		int mid = start + (end - start)/2;
		String prefix1 = commonPrefix(arr, start, mid-1);
		String prefix2 = commonPrefix(arr, mid, end);
		
		String[] lastArr = {prefix1,prefix2};
		return commonPrefix(lastArr, 0, 1);
		
	}

}
