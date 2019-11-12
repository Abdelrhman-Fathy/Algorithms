package datastructures;

import java.util.Arrays;

public class MergeSortedArrays {
	
	
	
	
	
	 private static int[] mergeArray(int[] arrayA, int[] arrayB)
	    {
	        int[] mergedArray = new int[arrayA.length + arrayB.length];
	         
	        int i=0, j=0, k=0;
	         
	        while (i < arrayA.length && j < arrayB.length)
	        {
	            if (arrayA[i] < arrayB[j]) 
	            {
	                mergedArray[k] = arrayA[i];
	                i++;
	                k++;
	            } 
	            else
	            {
	                mergedArray[k] = arrayB[j];
	                j++;
	                k++;
	            }
	        } 
	                 
	        while (i < arrayA.length) 
	        {
	            mergedArray[k] = arrayA[i];
	            i++;
	            k++;
	        } 
	                 
	        while (j < arrayB.length) 
	        {
	            mergedArray[k] = arrayB[j];
	            j++;
	            k++;
	        } 
	             
	        return mergedArray;
	    }
	     
	    public static void main2(String[] args) 
	    {
	       // int[] arrayA = new int[] {-7, 12, 17, 29, 41, 56, 79};
	         
	       // int[] arrayB = new int[] {-9, -3, 0, 5, 19};
	        
	        final int[] arrayA = {0,3,4,31};
			final int[] arrayB = {4,6,30};
	         
	        int[] mergedArray = mergeArray(arrayA, arrayB);
	         
	        System.out.println("Array A : "+Arrays.toString(arrayA));
	         
	        System.out.println("Array B : "+Arrays.toString(arrayB));
	         
	        System.out.println("Merged Array : "+Arrays.toString(mergedArray));
	    }
	    
	public static void main(String[] args) {
		final int[] arr1 = {0,3,4,31};
		final int[] arr2 = {4,6,30};
		System.out.println(Arrays.toString(merge2SortedArrays(arr1, arr2)));
		

	}
	
	public static int[] merge2SortedArrays(int[] arr1, int[] arr2) {
		int[] total = new int[arr1.length+arr2.length];
		if(arr1.length == 0)
			return arr2;
		if(arr2.length == 0)
			return arr1;
		int j=0,k=0,i=0;
		
		while(j < arr1.length && k < arr2.length) {
			//System.out.println("j:"+j + ",K:" + k);
			if(arr1[j]<arr2[k]) {
				total[i++] = arr1[j++];
			} else {
				total[i++] = arr2[k++];
			}	
		}
		
		while(j < arr1.length) {
			total[i++] = arr1[j++];
		}
		while(k < arr2.length) {
			total[i++] = arr2[k++];
		}
		return total;
	}

}
