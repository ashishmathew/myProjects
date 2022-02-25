package com.practice;

import java.util.Arrays;

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
}
