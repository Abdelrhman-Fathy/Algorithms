package datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompareArrays {

	public static void main(String[] args) {
		final String[] arr1 = {"a","b","c","d","e"};
		final String[] arr2 = {"f","g","c","h","i"};
		System.out.println(contains(arr1, arr2));
		

	}
	//check if 2 arrays contains any shared element.
	
	public static boolean contains(String[] arr1, String[] arr2) {
		
		for(int i = 0; i<arr1.length; i++) {
			for(int j = 0; j < arr1.length; j++) {
				if(arr1[i] == arr2[j])
					return true;
			}
			
		}
		return false;
		
	}
	
	
	public static boolean contains2(String[] arr1, String[] arr2) {
		HashMap<String, Boolean> m = new HashMap<>();
		
		
		
		for(int i = 0; i<arr1.length; i++) {
			if(m.get(arr1[i]) != true) {
				m.put(arr1[i], true);
			}
		}
		
		for(int i = 0; i<arr2.length; i++) {
			if(m.get(arr2[i]) == true) {
				return true;
			}
		}
		return false;
		
	}

}
