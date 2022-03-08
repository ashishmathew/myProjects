package com.practice;

import java.util.ArrayList;
import java.util.List;

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

}