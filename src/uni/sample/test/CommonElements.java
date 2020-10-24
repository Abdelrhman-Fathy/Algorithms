package uni.sample.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CommonElements {

	public static void main(String[] args) {

		CommonElements object = new CommonElements();
		System.out.println("result:" + Arrays.toString(object.calculate(new int[]  {1, 8, 3, 2}, new int[]{4, 2, 6, 1}))  + ", expected:{1, 2}");
		System.out.println("result:" + Arrays.toString(object.calculate(new int[]{1, 8, 3, 2, 6}, new int[]{2, 6, 1}))  + ", expected:{2, 6, 1}");
		System.out.println("result:" + Arrays.toString(object.calculate(new int[]{1, 3, 7, 9}, new int[]{7, 1, 9, 3}))  + ", expected:{1, 3, 7, 9}");
		
		System.out.println("result:" + Arrays.toString(object.calculate(new int[]{1, 2}, new int[]{3, 4}))  + ", expected:{}");
		System.out.println("result:" + Arrays.toString(object.calculate(new int[]{}, new int[]{1, 2, 3}))  + ", expected:{}");
		System.out.println("result:" + Arrays.toString(object.calculate(new int[]{1, 2}, new int[]{}))  + ", expected:{}");
		
		System.out.println("result:" + Arrays.toString(object.calculate(new int[]{1, 2}, null))  + ", expected:null");
		System.out.println("result:" + Arrays.toString(object.calculate(null, new int[]{}))  + ", expected:null");
		System.out.println("result:" + Arrays.toString(object.calculate(null, null))  + ", expected:null");
		
	}
	public int[] calculate(int[] a, int[] b) {
		if(a==null||b==null) return null;
		HashSet<Integer> set = new HashSet<>();
		for(int x : b) set.add(x);
		ArrayList<Integer> common = new ArrayList<>();
		for(int x : a) if(set.contains(x)) common.add(x);
		int[] result = new int[common.size()];
		for(int i = 0; i < common.size();i++) result[i] = common.get(i);
		return result;
	}

}
