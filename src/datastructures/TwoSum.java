package datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

public class TwoSum {
	public static void main(String[] args) {
		//Given nums = [2, 7, 11, 15], target = 9,
		int[] nums = {2, 7, 11, 15};
		System.out.println(Arrays.toString(solution(nums,9)));
	}
	
	public static int[] solution(int[] nums, int target){
		Map<Integer,Integer> previousItems = new HashMap<>();
		for(int i = 0; i<nums.length;i++) {
			if(previousItems.get(target-nums[i])!=null)
				return new int[] {previousItems.get(target-nums[i]).intValue(),i};
			else
				previousItems.put(nums[i], i);
		}
		return null;
	}

}
