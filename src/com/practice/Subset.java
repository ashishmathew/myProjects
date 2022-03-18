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
			result.add(currentPermutation);// [3 2 1] [2 3 1]

		} else {
			for (int i = 0; i <= currentPermutation.size(); i++) {
				List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);// [2 1]
				newPermutation.add(i, nums[index]);// [2 3 1]
				generatePermutation(nums, index + 1, result, newPermutation);

			}

		}

	}

	public List<String> stringPermutation(String str) {

		List<String> permutations = new ArrayList<String>();
		permutations.add(str);
		generateStringPermutations(str, 0, permutations);
		return permutations;

	}

	public void generateStringPermutations(String str, int index, List<String> permutations) {
		// TODO Auto-generated method stub

		if (index == str.length()) {
			permutations.add(str);
		}

		char ch = str.charAt(index);
		if (Character.isLowerCase(ch))
			ch = Character.toUpperCase(ch);
		else
			ch = Character.toLowerCase(ch);

		// How will I add the new case charater to the string

		// Skip numbers

		generateStringPermutations(str, index + 1, permutations);

	}

	public List<String> findLetterCaseStringPermutations(String str) {

		List<String> permutations = new ArrayList<>();

		if (str == null)
			return permutations;

		permutations.add(str);

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				int n = permutations.size();
				for (int j = 0; j < n; j++) {
					char[] chs = permutations.get(j).toCharArray();// 'a''b''7''c'
					if (Character.isLowerCase(chs[i]))
						chs[i] = Character.toUpperCase(chs[i]);// 'A''b''7''c'
					else
						chs[i] = Character.toLowerCase(chs[i]);
					permutations.add(String.valueOf(chs));
				}
			}
		}

		return permutations;

	}

	class Parenthesis {
		String str;
		int openCount;
		int closeCount;

		public Parenthesis(String s, int i, int j) {
			str = s;
			openCount = i;
			closeCount = j;

		}

	}

	public List<String> generateValidParentheses(int num) {

		List<String> permutations = new ArrayList<String>();
		Queue<Parenthesis> queue = new LinkedList<>();
		queue.add(new Parenthesis("", 0, 0));// ""
		// =======================================inside the queue
		// ("()",2,1)
		// =======================================

		// -----------------------------------------//pop
		// ("",0,0),("(",1,0),("((",2,0),
		// -----------------------------------------

		while (!queue.isEmpty()) {

			Parenthesis ps = queue.poll();

			if (ps.openCount == num && ps.closeCount == num)
				permutations.add(ps.str);
			else {

				if (ps.openCount < num)
					queue.add(new Parenthesis(ps.str + "(", ps.openCount + 1, ps.closeCount));

				if (ps.openCount > ps.closeCount)
					queue.add(new Parenthesis(ps.str + ")", ps.openCount, ps.closeCount + 1));
			}

		}
		return permutations;

	}

	public List<String> generateValidParenthesesRecursion(int num) {
		List<String> permutations = new ArrayList<String>();
		Parenthesis ps = new Parenthesis("", 0, 0);
		helperGenerateValidParenthesesRecursion(permutations, num, ps);
		return permutations;
	}

	public void helperGenerateValidParenthesesRecursion(List<String> permutations, int num, Parenthesis ps) {
		// TODO Auto-generated method stub

		if (ps.openCount == num && ps.closeCount == num)
			permutations.add(ps.str);

		if (ps.openCount < num)
			helperGenerateValidParenthesesRecursion(permutations, num,
					new Parenthesis(ps.str + "(", ps.openCount + 1, ps.closeCount));

		if (ps.openCount > ps.closeCount)
			helperGenerateValidParenthesesRecursion(permutations, num,
					new Parenthesis(ps.str + ")", ps.openCount, ps.closeCount + 1));
	}

}