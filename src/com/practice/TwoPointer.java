package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TwoPointer {
	/*
	 * This is the solution to the two sum problem
	 * Time complexity - O(nlogn)
	 * Space complexity - O(n)
	 */
	public int[] twoSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			int first = nums[i];
			int second = nums[j];
			if (first + second == target)
				return new int[] { first, second };
			/*
			 * If the the sum is lesser than the target move the left pointer
			 * to the right
			 */
			else if (first + second < target)
				i++;
			/*
			 * else move the right pointer to the left
			 */
			else
				j--;
		}
		return new int[0];
	}
	
	public int[] twoSumHash(int[] nums, int target) {
		
		Set<Integer> set = new HashSet<>();
		
		for(Integer n : nums) {
			int potentialMatch = target  - n;
			if(!set.contains(potentialMatch)) {
				set.add(n);
			}
			else {
				return new int[] {potentialMatch,n};
			}
		}
		return new int[0];
	}
}
