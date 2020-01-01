package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectionSort(new int[] {4,6,3,2,1,13,0,11});
	}
	
	public static void selectionSort(int[] in) {
		
		for(int i = 0; i < in.length; i++) {
			int minIndex = i;
			for(int j = 0 + i; j < in.length; j++) {
				if(in[j] < in[minIndex]){
					minIndex = j;
				}
			}
			int temp = in[i];
			in[i] = in[minIndex];
			in[minIndex] = temp;
		}
		System.out.println(Arrays.toString(in));
	}
}
