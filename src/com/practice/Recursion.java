package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
//This is a test comment
	public void print(int n) {
		System.out.println(n);
		if (n == 1) {
			System.out.println(n);
			return;
		}
		print(n - 1);
		System.out.println(n);
	}

	public int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	public int sumOfDigits(int n) {
		// 1342
		// base
		if (n == 0)
			return 0;
		int remainder = n % 10;// 2
		n = n / 10;// 134
		return remainder + sumOfDigits(n);

	}

	public int countZeros(int n) {
		// 10006
		return helperCountZeros(n, 0);
	}

	public int helperCountZeros(int n, int count) {
		// TODO Auto-generated method stub
		if (n == 0)
			return count;

		int remainder = n % 10;

		if (remainder == 0)
			return helperCountZeros(n / 10, ++count);

		return helperCountZeros(n / 10, count);
	}

	public int numberOfSteps(int num) {
		return helperNumberOfSteps(num, 0);
	}

	public int helperNumberOfSteps(int num, int steps) {
		// TODO Auto-generated method stub
		// 14

		if (num == 0)
			return steps;

		if (num % 2 == 0)
			num = num / 2;
		else
			num -= 1;

		++steps;

		return helperNumberOfSteps(num, steps);

	}

	public boolean isArraySorted(int[] nums) {

		return helperIsArraySorted(nums, 0);

	}

	public boolean helperIsArraySorted(int[] nums, int i) {
		// TODO Auto-generated method stub

		if (i == nums.length - 1)
			return true;

		return nums[i] < nums[i + 1] && helperIsArraySorted(nums, i + 1);

	}

	public boolean isTargetPresent(int[] nums, int target) {
		return helperIsTargetPresent(nums, target, 0);
	}

	public boolean helperIsTargetPresent(int[] nums, int target, int i) {
		// TODO Auto-generated method stub
		// base
		if (nums[i] == target)
			return true;

		if (i == nums.length - 1)
			return false;

		return helperIsTargetPresent(nums, target, i + 1);

	}

	public List<Integer> findTargetIndexes(int[] nums, int target) {
		List<Integer> listOfTargetIndexes = new ArrayList<>();
		return helperfindTargetIndexes(listOfTargetIndexes, nums, target, 0);
	}

	public List<Integer> helperfindTargetIndexes(List<Integer> list, int[] nums, int target, int i) {
		// TODO Auto-generated method stub
		if (i == nums.length)
			return list;

		if (nums[i] == target)
			list.add(i);

		return helperfindTargetIndexes(list, nums, target, i + 1);
	}

	public List<Integer> findTargetIndexesListInBody(int[] nums, int target) {

		return helperFindTargetIndexesListInBody(nums, target, 0);
	}

	public List<Integer> helperFindTargetIndexesListInBody(int[] nums, int target, int i) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();

		if (i == nums.length)
			return list;

		if (nums[i] == target)
			list.add(i);// [3]

		List<Integer> ansFromBelowCall = helperFindTargetIndexesListInBody(nums, target, i + 1);
		// [4]
		list.addAll(ansFromBelowCall);

		return list;

	}

	/*
	 * assumption we are skipping a
	 */
	public void skip(String str) {
		helperSkip(str, "");
	}

	// baccad
	public void helperSkip(String unprocessed, String processed) {

		if (unprocessed.isEmpty()) {
			System.out.println(processed);
			return;
		}

		char ch = unprocessed.charAt(0);

		if (ch == 'a') {
			helperSkip(unprocessed.substring(1), processed);
		} else {
			helperSkip(unprocessed.substring(1), processed + ch);
		}

	}

	public String skipStringAndReturn(String str) {
		return helperSkipStringAndReturn(str);
	}

	public String helperSkipStringAndReturn(String unprocessed) {
		// base
		if (unprocessed.isEmpty()) {
			return "";
		}

		char ch = unprocessed.charAt(0);
		if (ch == 'a')
			return helperSkipStringAndReturn(unprocessed.substring(1));

		else

			return ch + helperSkipStringAndReturn(unprocessed.substring(1));

	}

	public String skipApple(String str) {
		if (str.isEmpty())
			return "";

		char ch = str.charAt(0);

		if (str.startsWith("apple"))
			return skipApple(str.substring(5));

		return ch + skipApple(str.substring(1));

	}
	
	public String skipAppNotApple(String str) {
		
		if (str.isEmpty())
			return "";

		char ch = str.charAt(0);

		//badappmappleand
		if (str.startsWith("app") && !str.startsWith("apple"))
			return skipAppNotApple(str.substring(3));

		return ch + skipAppNotApple(str.substring(1));

	}

}
