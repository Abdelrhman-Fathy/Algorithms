package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bubbleSort(new int[] {4,6,3,2,1,13,0,11});
	}
	
	public static void bubbleSort(int[] in) {
		for(int i = 0; i < in.length; i++) {
			for(int j = 0 + i; j < in.length; j++) {
				if(in[i]>in[j]) {
					int temp = in[i];
					in[i] = in[j];
					in[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(in));
	}

}
