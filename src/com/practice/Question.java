package com.practice;

import java.util.Arrays;




public class Question {

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

		MedianOfStream median = new MedianOfStream();
		median.insertNum(3);
		median.insertNum(1);
		System.out.println("Median : " + median.findMedian());
		median.insertNum(5);
		System.out.println("Median : " + median.findMedian());
		median.insertNum(4);
		System.out.println("Median : " + median.findMedian());

	}

}
