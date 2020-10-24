package uni.sample.test;

import java.util.Arrays;

public class SubArray {
	public static void main(String[] args) {
		SubArray object = new SubArray();
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 0, 4))  + ", expected:null");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 0, 3))  + ", expected:{'a', 'b', 'c'}");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 0, 2))  + ", expected:{'a', 'b'}");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 0, 1))  + ", expected:{'a'}");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 1, 3))  + ", expected:null");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 1, 2))  + ", expected:{'b', 'c'}");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 2, 2))  + ", expected:null");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 2, 1))  + ", expected:{'c'}");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 3, 1))  + ", expected:null");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, 1, 0))  + ", expected:{}");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, -1, 2))  + ", expected:null");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {'a', 'b', 'c'}, -1, -2))  + ", expected:null");
		System.out.println("result:" + Arrays.toString(object.calculate(new char[] {}, 0, 1))  + ", expected:null");
		
	}
	public char[] calculate(char[] arr, int start, int len) {
		int end = start+len-1;
		if(len < 0 || start < 0 || end >= arr.length ) return null;
		char[] result = new char[len];
		for(int i = 0; i < len; i++) {
			result[i] = arr[start+i];
		}
		return result;
	}
}
