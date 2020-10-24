package uni.sample.test;

import java.util.Arrays;

public class Equilibrium {

	public static void main(String[] args) {
		Equilibrium object = new Equilibrium();
		System.out.println("result:" + object.calculate(new int[]{1, 8, 3, 7, 10, 2})  + ", expected:3");
		System.out.println("result:" + object.calculate(new int[]{1, 5, 3, 1, 1, 1, 1, 1, 1}	)  + ", expected:2");
		System.out.println("result:" + object.calculate(new int[]{2, 1, 1, 1, 2, 1, 7})  + ", expected:5");
		System.out.println("result:" + object.calculate(new int[]{1, 2, 3})  + ", expected:-1");
		System.out.println("result:" + object.calculate(new int[]{3, 4, 5, 10})  + ", expected:-1");
		System.out.println("result:" + object.calculate(new int[]{1, 2, 10, 3, 4})  + ", expected:-1");

	}
	
	public int calculate(int[] arr) {
		int left = 0, right = arr.length-1, lSum = arr[0], rSum = arr[arr.length-1];
		while(left<right) {
			if(lSum > rSum) rSum += arr[--right];
			else lSum += arr[++left];
		}
		if(lSum == rSum && left == right) return left;
		else return -1;
	}

}
