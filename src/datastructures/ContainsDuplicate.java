package datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
	
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] {1,2,3,1}));
		System.out.println(containsDuplicate(new int[] {1,2,3,4}));
		System.out.println(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
		
		
	}

	public static boolean containsDuplicate(int[] nums) {
		Map<Integer, Boolean> previousItems = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(previousItems.get(nums[i]) != null)
				return true;
			else
				previousItems.put(nums[i], true);
		}
		return false;
	}

}

/*
 *Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true 
 * 
 * 
 * 
 * */

