package uni.sample.test;

import java.util.HashMap;
import java.util.Map;

public class CenteredElements {
	/*
	 * public static void main(String[] args) { CenteredElements object = new
	 * CenteredElements(); System.out.println("result:" + object.isCentered(new
	 * int[] {1, 2, 3, 4, 5}) + ", expected:0"); System.out.println("result:" +
	 * object.isCentered(new int[] {3, 2, 1, 4, 5}) + ", expected:1");
	 * System.out.println("result:" + object.isCentered(new int[] {3, 2, 1, 4, 1}) +
	 * ", expected:0"); System.out.println("result:" + object.isCentered(new int[]
	 * {1, 2, 3, 4}) + ", expected:0"); System.out.println("result:" +
	 * object.isCentered(new int[] {}) + ", expected:0");
	 * System.out.println("result:" + object.isCentered(new int[] {10}) +
	 * ", expected:1");
	 * 
	 * }
	 * 
	 * public int isCentered(int[] elm){ if(elm == null || elm.length == 0 ||
	 * elm.length%2 == 0) return 0; int mid = elm.length/2; for(int i = 0; i <
	 * elm.length; i++) { if(i!= mid && elm[i] <= elm[mid]) return 0; } return 1; }
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("result:" + hasSingleMaximum (new int[] {1, 2, 3, 1, 0}) +
	 * ", expected:1"); System.out.println("result:" + hasSingleMaximum (new int[]
	 * {18}) + ", expected:1"); System.out.println("result:" + hasSingleMaximum (new
	 * int[] {1, 2, 3, 0, 1, 3}) + ", expected:0"); System.out.println("result:" +
	 * hasSingleMaximum (new int[] {13, 1, 13, 2, 13, 0, 13, 1, 13}) +
	 * ", expected:0"); System.out.println("result:" + hasSingleMaximum (new int[]
	 * {}) + ", expected:0"); System.out.println("result:" + hasSingleMaximum (new
	 * int[] {-6, -6, -6, -6, -6, -6, -6}) + ", expected:0");
	 * 
	 * }
	 * 
	 * public static int hasSingleMaximum (int[] a){ if(a == null || a.length == 0)
	 * return 0; int max = a[0]; int loc = 0; for(int i = 0; i < a.length; i++) {
	 * if(a[i]> max) { max = a[i]; loc = i; } } for(int i = 0; i < a.length; i++) {
	 * if(a[i] == max && loc != i) { return 0; } } return 1; }
	 */

	/*
	 * public static void main(String[] args) { System.out.println("result:" +
	 * isOnionArray (new int[] {1, 2, 19, 4, 5}) + ", expected:1");
	 * System.out.println("result:" + isOnionArray (new int[] {1, 2, 3, 4, 15}) +
	 * ", expected:0"); System.out.println("result:" + isOnionArray (new int[] {1,
	 * 3, 9, 8}) + ", expected:0"); System.out.println("result:" + isOnionArray (new
	 * int[] {2}) + ", expected:1"); System.out.println("result:" + isOnionArray
	 * (new int[] {}) + ", expected:1"); System.out.println("result:" + isOnionArray
	 * (new int[] {-2, 5, 0, 5, 12}) + ", expected:1");
	 * 
	 * }
	 * 
	 * public static int isOnionArray (int[] a){ if(a == null || a.length < 2)
	 * return 1; int left = 0; int right = a.length-1; while(left<right)
	 * if(a[left++] + a[right--] > 10) return 0; return 1; }
	 */

	public static void main(String[] args) {
		System.out.println("result:" + isDigitIncreasing(7) + ", expected:1");
		System.out.println("result:" + isDigitIncreasing(36) + ", expected:1");
		System.out.println("result:" + isDigitIncreasing(984) + ", expected:1");
		System.out.println("result:" + isDigitIncreasing(7404) + ", expected:1");
		System.out.println("result:" + isDigitIncreasing(37) + ", expected:0");

	}
	
	public static int isDigitIncreasing(int n) {
		for (int i = 1; i <= 9; i++) {
			int sum = 0;
			int product = 0;
			while (sum < n) {
				product = (product * 10) + i;
				sum += product;
			}
			if (sum == n)
				return 1;
		}
		return 0;
	}
}
