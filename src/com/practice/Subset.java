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

}