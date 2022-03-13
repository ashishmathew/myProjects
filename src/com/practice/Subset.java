package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subset {

	public List<List<Integer>> findSubsets(int[] nums) {
		/*
		 * [1 2 3]
		 * 
		 * [] [1] [3] [1 3]
		 */
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for (int currentNumber : nums) {
			int n = result.size();
			for (int i = 0; i < n; i++) {
				List<Integer> list = new ArrayList<Integer>(result.get(i));
				list.add(currentNumber);
				result.add(list);
			}
		}
		return result;
	}

	public List<List<Integer>> findSubsetsDuplicate(int[] nums) {
		/*
		 * [1 2 3]
		 * 
		 * [] [1] [3] [1 3]
		 */
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for (int currentNumber : nums) {
			int n = result.size();
			for (int i = 0; i < n; i++) {
				List<Integer> list = new ArrayList<Integer>(result.get(i));
				list.add(currentNumber);
				result.add(list);
			}
		}
		return result;
	}

	// abc
	public void findSubsequence(String p, String up) {

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		char ch = up.charAt(0);
		findSubsequence(p + ch, up.substring(1));
		findSubsequence(p, up.substring(1));

	}

	public List<String> findSubsequenceArray(String p, String up) {
		List<String> list = new ArrayList<String>();
		return helperFindSubsequenceArray(p, up, list);
	}

	public List<String> helperFindSubsequenceArray(String p, String up, List<String> list) {
		// TODO Auto-generated method stub

		if (up.isEmpty()) {
			return list;
		}

		char ch = up.charAt(0);
		list.add(p + ch);
		helperFindSubsequenceArray(p + ch, up.substring(1), list);
		helperFindSubsequenceArray(p, up.substring(1), list);
		return list;

	}

	public List<String> findSubsequenceArrayInside(String p, String up) {
		if (up.isEmpty()) {
			List<String> list = new ArrayList<String>();
			list.add(p);
			return list;
		}

		char ch = up.charAt(0);
		List<String> left = findSubsequenceArrayInside(p + ch, up.substring(1));
		List<String> right = findSubsequenceArrayInside(p, up.substring(1));
		left.addAll(right);
		return left;
	}

	public void findSubsequenceAscii(String p, String up) {

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		char ch = up.charAt(0);
		findSubsequenceAscii(p + ch, up.substring(1));
		findSubsequenceAscii(p + (ch + 0), up.substring(1));
		findSubsequenceAscii(p, up.substring(1));

	}

	public List<List<Integer>> findSubset(int[] nums) {
		List<List<Integer>> outer = new ArrayList<>();
		outer.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			int n = outer.size();

			for (int j = 0; j < n; j++) {
				List<Integer> inner = new ArrayList<Integer>(outer.get(j));
				inner.add(nums[i]);
				outer.add(inner);
			}

		}
		return outer;
	}

	public List<List<Integer>> findSubsetDuplicate(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> outer = new ArrayList<>();
		outer.add(new ArrayList<Integer>());
		int start = 0;
		int end = 0;

		for (int i = 0; i < nums.length; i++) {
			int n = outer.size();

			if (i > 0 && nums[i] == nums[i - 1]) {
				start = end + 1;
			}
			end = outer.size() - 1;

			for (int j = start; j < n; j++) {
				List<Integer> internal = new ArrayList<Integer>(outer.get(j));
				internal.add(nums[i]);
				outer.add(internal);
			}

		}

		return outer;
	}

	public void findPermutations(String p, String up) {
		// abc
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);
		// a
		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			findPermutations(first + ch + second, up.substring(1));
		}

	}

	// [1 2 3]

	public List<List<Integer>> findPermutationInteger(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();// [3 2 1] [2 3 1][2 1 3][3 1 2][1 3 2][1 2 3]
		Queue<List<Integer>> permutations = new LinkedList<>();//
		permutations.add(new ArrayList<Integer>());
		for (Integer currentNum : nums) {// 2
			int n = permutations.size();
			for (int i = 0; i < n; i++) {
				List<Integer> oldPermutation = permutations.poll();// [1 2]
				for (int j = 0; j <= oldPermutation.size(); j++) {
					List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);// [1 2]
					newPermutation.add(j, currentNum);// [1]
					if (newPermutation.size() == nums.length)
						result.add(newPermutation);
					else
						permutations.add(newPermutation);
				}

			}
		}
		return result;
	}

	public List<List<Integer>> findPermutationIntegerRecursion(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		generatePermutation(nums, 0, result, new ArrayList<>());
		return result;
	}

	public void generatePermutation(int[] nums, int index, List<List<Integer>> result,
			List<Integer> currentPermutation) {
		// TODO Auto-generated method stub

		if (index == nums.length) {
			result.add(currentPermutation);//[3 2 1] [2 3 1]

		} else {
			for (int i = 0; i <= currentPermutation.size(); i++) {
				List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);// [2 1]
				newPermutation.add(i,nums[index]);// [2 3 1]
				generatePermutation(nums, index + 1, result, newPermutation);

			}

		}

	}

}