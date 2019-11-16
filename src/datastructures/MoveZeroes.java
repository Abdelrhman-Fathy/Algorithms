package datastructures;

import java.util.Arrays;

public class MoveZeroes {
	public static void main(String[] args) {
		moveZeroes(new int[]{1,0,1,0,3,12});
		
	}
	
	public static void moveZeroes(int[] nums) {
		int firstZero = 0, temp = 0;
		for(int i = 0 ; i < nums.length; i++) {
			//System.out.println(Arrays.toString(nums));
			//System.out.println("first zero:" + nums[firstZero] + ",current:"+ nums[i]);

			if(nums[i] != 0) {
				temp = nums[firstZero];
				nums[firstZero++] = nums[i];
				nums[i]= temp;
			}
		}
		System.out.println(Arrays.toString(nums));
    }
}
/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Input: [1,0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * 
 * 
 * */
 