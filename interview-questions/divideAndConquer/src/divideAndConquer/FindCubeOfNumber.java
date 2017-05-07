package divideAndConquer;

/**
 * http://www.geeksforgeeks.org/find-cubic-root-of-a-number/
 * 
 * 
 * @author manishpeshwani
 *
 */

public class FindCubeOfNumber {

	public static void main(String[] args) {
		double val = 3;
		
		double precisionVal = 0.0000001;
		
		double start =0;
		double end   =val;
		
		
		
		while(true){
			
			double mid = start + (end - start) / 2;
			double error = end - mid;
		
			if(error <= precisionVal){
				System.out.println(mid);
				break;
			}
			
			if(mid*mid*mid > val){
				end = mid;
			}else {
				start = mid;
			}
		}

	}

}
