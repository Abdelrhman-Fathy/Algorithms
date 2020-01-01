package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		insertionSort(new int[] {4,6,3,2,1,13,0,11});
	}
	
	public static void insertionSort(int[] in) {
		for(int i = 1; i < in.length; i++) {
			int j = i - 1;
			int val = in[i];
			while(j >= 0 && val < in[j]) {
				in[j+1] = in[j];
				j--;
			}
			in[j+1] = val;
		}
		System.out.println(Arrays.toString(in));
	}

}
