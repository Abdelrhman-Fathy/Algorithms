package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		//int[] in = new int[] {4,6,3,2,1,15,13,0,11};
		int[] in = new int[] {6,5,3,1,8,7,2,4};
		System.out.println(Arrays.toString(in));

		quickSort(in, 0, in.length-1);

		System.out.println(Arrays.toString(in));
	}
	
	public static void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);
	 
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private static int partition(int arr[], int begin, int end) {
		System.out.println("===partition===");
	    int pivot = arr[end];
	    int i = (begin-1);
	    for (int j = begin; j < end; j++) {
	    	System.out.println("i:" + i +", j:" + j+ " ,array:" + Arrays.toString(arr));
	        if (arr[j] <= pivot) {
	            i++;
	            System.out.println("swap");
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	            
	        }
	    }
	 
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	    System.out.println("pivot:"+ pivot + " ,i:" + i + " ,begin:" + begin + " , end:" + end+ " ,array:" + Arrays.toString(arr));
	    return i+1;
	}

}
