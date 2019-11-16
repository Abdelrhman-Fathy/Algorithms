package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(new TopKFrequentElements().topKFrequent(new int[] {1,1,1,2,2,3,5,5,5,5,5}, 2));
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> count = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(count.get(nums[i]) != null) {
				count.put(nums[i], count.get(nums[i]) + 1);
			} else {
				count.put(nums[i], 1);
			}
		}
		PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->count.get(n1) - count.get(n2));
		for(int i : count.keySet()) {
			heap.add(i);
			if(heap.size() > k)
				heap.poll();
		}
		List<Integer> result = new LinkedList<>();
		while(!heap.isEmpty()) {
			result.add(heap.poll());
		}
		Collections.reverse(result);
        return result;
    }

}
//https://leetcode.com/problems/top-k-frequent-elements/solution/

/*Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/