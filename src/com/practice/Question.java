package com.practice;

import java.util.Arrays;
import java.util.PriorityQueue;


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
		
		NextInterval nextInterval = new NextInterval();
		Interval[] intervals = new Interval[] {new Interval(2,3),new Interval(3,4),new Interval(5,6)};
		int[] result = nextInterval.findNextIntervals(intervals);
		print(result);
		
		intervals = new Interval[] {new Interval(3,4),new Interval(1,5),new Interval(4,6)};
		result = nextInterval.findNextIntervals(intervals);
		print(result);

	}
	
	public static void print(int[] result) {
		System.out.print("The indices are [");
		for(Integer nextIntervalIndex : result) {
			System.out.print(" " + nextIntervalIndex);
		}
		System.out.print(" ]");
		System.out.println();
	}

}
