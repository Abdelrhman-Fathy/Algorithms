package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
	static int count = 0 ;
	static int count1 = 0 ;
	public static void main(String[] args) {
		int[] in = new int[] {4,6,3,2,1,13,0,11};
		mergeSort(in);

		System.out.println(Arrays.toString(in));
	}
	
	
	public static void mergeSort(int[] in) {
		int n = in.length;
		if(n < 2)
			return;
		int mid = n/2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];
		for(int i = 0; i < mid; i++)
			l[i] = in[i];
		for(int i = mid; i < n; i ++)
			r[i - mid] = in[i];
		//System.out.println("call " + ++count + ": l Array:" + Arrays.toString(l) + ", r Array:" + Arrays.toString(r));
		mergeSort(l);
		mergeSort(r);
		merge(in,l,r);
	}
	public static void merge(int[] in, int[] l, int[] r) {
		int i = 0, j = 0, k = 0;
		while( i < l.length && j < r.length) {
			if(l[i]<r[j]) {
				in[k++] = l[i++];
			} else {
				in[k++] = r[j++];
			}
		}
		//System.out.println("merge call " + ++count1 + ": l Array:" + Arrays.toString(l) + ", r Array:" + Arrays.toString(r)+ ", in Array:" + Arrays.toString(in));
		while(i < l.length)
			in[k++] = l[i++];
		while(j < r.length)
			in[k++] = r[j++];
	}
	
}
