package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question {

	public static int sum = 0;

	public static String upcase(String s) {
		return s.toUpperCase();
	}

	public static void reverse(int n) {
		// 1342 => 2431
		if (n == 0)
			return;
		int remainder = n % 10;
		sum = sum * 10 + remainder;
		reverse(n / 10);
	}

	public static int reverse1(int n) {
		// 1234
		int digits = (int) Math.log10(n) + 1;
		return helper(n, digits);

	}

	public static int helper(int n, int digits) {
		// TODO Auto-generated method stub
		if (n % 10 == n)
			return n;
		int remainder = n % 10;
		n = n / 10;
		return remainder * (int) Math.pow(10, digits - 1) + helper(n, digits - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Use this space for two pointer problems
		 */

		/*
		 * TwoPointer ans = new TwoPointer(); System.out.println("The two numbers are :"
		 * + Arrays.toString(ans.twoSum(new int[] { -3, 8, -8, 4, 3 }, 7)));
		 * System.out.println("The two numbers are :" +
		 * Arrays.toString(ans.twoSumHash(new int[] { -3, 8, -8, 4, 3 }, 7)));
		 */

		/*
		 * Use this space for Heap Problems
		 */

		// Find median of a stream
		/*
		 * MedianOfStream median = new MedianOfStream(); median.insertNum(3);
		 * median.insertNum(1); System.out.println("Median : " + median.findMedian());
		 * median.insertNum(5); System.out.println("Median : " + median.findMedian());
		 * median.insertNum(4); System.out.println("Median : " + median.findMedian());
		 */

		// Sliding window median

		/*
		 * SlidingWindowMedian median = new SlidingWindowMedian(); double[] result =
		 * median.slidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2); for (double i :
		 * result) { System.out.println(i + " "); } System.out.println();
		 * 
		 * median = new SlidingWindowMedian(); result = median.slidingWindowMedian(new
		 * int[] { 1, 2, -1, 3, 5 }, 3); for (double i : result) { System.out.println(i
		 * + " "); }
		 */

		/*
		 * Maximize capital
		 */

		/*
		 * MaximizeCapital maxCapital = new MaximizeCapital();
		 * System.out.println("The max profit is " + maxCapital.findMaximumCapital(new
		 * int[]{0,1,2}, new int[] {1,2,3}, 2, 1) );
		 * System.out.println("The max profit is " + maxCapital.findMaximumCapital(new
		 * int[]{0,1,2,3}, new int[] {1,2,3,5}, 3, 0) );
		 */

		/*
		 * NextInterval nextInterval = new NextInterval(); Interval[] intervals = new
		 * Interval[] {new Interval(2,3),new Interval(3,4),new Interval(5,6)}; int[]
		 * result = nextInterval.findNextIntervals(intervals); print(result);
		 * 
		 * intervals = new Interval[] {new Interval(3,4),new Interval(1,5),new
		 * Interval(4,6)}; result = nextInterval.findNextIntervals(intervals);
		 * print(result);
		 */

		/*
		 * Use this for Subset problems
		 */

		// find subsets
		
		//Revision revision = new Revision();
		/*
		 * List<List<Integer>> list = revision.subset(new int[] {1,2,3});
		 * System.out.println(list);
		 */
		
		
		/*
		 * List<List<Integer>> list = revision.subsetDuplicate(new int[] {1,2,2});
		 * System.out.println(list);
		 */
		//revision.permutations("abc", "");
		
		
		/*
		 * List<String> list = revision.permutationsArrayInBody("abc", "");
		 * System.out.println(list);
		 */
		
		/*
		 * Subset subset = new Subset(); List<List<Integer>> list =
		 * subset.findPermutationIntegerRecursion(new int[] {1,3,5});
		 * 
		 * for(List<Integer> list1 : list) { System.out.println(list1); }
		 */
		
		
		/*
		 * Subset subset = new Subset(); List<List<Integer>> subsets =
		 * subset.findSubsetDuplicate(new int[] {1,2,2});
		 * 
		 * System.out.println(subsets);
		 */
		
		// subset.findSubsequence("", "abc");
		/*
		 * List<String> list = subset.findSubsequenceArray("", "abc");
		 * System.out.println(list);
		 */
		 
		 //subset.findSubsequenceAscii("", "abc");
		
			/*
			 * Subset subset = new Subset(); subset.findPermutations("", "abc");
			 */
		
		
		/*
		 * Strings
		 */
//		String q = "howdy";
//		String qq = new String("howdy1");
//		System.out.println(q==qq);
//		
		/*
		 * Recursion
		 */
		
		
		//Revision revision = new Revision();
		/*
		 * String str = revision.skipApple("MyappleisaappleString");
		 * System.out.println(str);
		 */
		/*
		 * Revision revision = new Revision(); List<List<Integer>> list =
		 * revision.findPermuationRecursion(new int[] {1,2,3});
		 * System.out.println(list);
		 */
		/*
		 * Subset subset = new Subset(); List<String> permutations =
		 * subset.findLetterCaseStringPermutations("ab7c");
		 * System.out.println(permutations);
		 */
		//revision.subsequence("abc", "");
		
		
		/*
		 * Revision revision = new Revision(); List<String> list =
		 * revision.findLetterCaseStringPermutationsRecursion("ad52");
		 * System.out.println(list);
		 */
		 
		/*
		 * Subset subset = new Subset(); List<String> list =
		 * subset.generateValidParenthesesRecursion(3); System.out.println(list);
		 */
		/*
		 * Revision revision = new Revision(); List<String> list =
		 * revision.generateValidParenthesisRecursion(3); System.out.println(list);
		 */
		
		
		/*
		 * GeneralizedAbbreviation generalizedAbbreviation = new
		 * GeneralizedAbbreviation(); List<String> result =
		 * generalizedAbbreviation.generateGeneralizedAbbreviation("code");
		 * System.out.println("Generalized abbreviation are: " + result);
		 */
		
		
		  EvaluateExpression ev = new EvaluateExpression();
		  List<Integer> result =ev.diffWaysToEvaluateExpression("1+2*3");
		  System.out.println("Expression evaluations: " + result);

		 
		//revision.subsequenceArray("abc", "", list);
		/*
		 * List<String> list = revision.subsequenceArrayBody("abc", "");
		 * System.out.println(list);
		 */
		//Recursion recursion = new Recursion();
//		System.out.println(recursion.factorial(5));
		// System.out.println(recursion.sumOfDigits(1342));
		/*
		 * reverse(1342); System.out.println(sum);
		 */
		// System.out.println(isIntPalindrome(1234321));
		// System.out.println(recursion.countZeros(100006));
		// System.out.println(recursion.numberOfSteps(123));
		// System.out.println(recursion.isArraySorted(new int[] {1,2,3,4,5}));
		// System.out.println(recursion.isTargetPresent(new int[] {1,2,3,4,5},3));
		/*
		 * List<Integer> list = recursion.findTargetIndexes(new int[] {1,2,4,4,5},4);
		 * System.out.println(list);
		 */

		/*
		 * List<Integer> list = recursion.findTargetIndexesListInBody(new int[] { 1, 2,
		 * 4, 4, 5 }, 4); System.out.println(list);
		 */

		// System.out.println(recursion.skipStringAndReturn("bacacad"));
		// System.out.println(recursion.skipApple("badappmappleand"));
		//System.out.println(recursion.skipAppNotApple("badappmappleand"));
	}

	public static boolean isIntPalindrome(int n) {
		return n == reverse1(n);

	}

	public static void print(int[] result) {
		System.out.print("The indices are [");
		for (Integer nextIntervalIndex : result) {
			System.out.print(" " + nextIntervalIndex);
		}
		System.out.print(" ]");
		System.out.println();
	}

}
