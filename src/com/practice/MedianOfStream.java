package com.practice;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianOfStream {
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;

	public MedianOfStream() {
		maxHeap = new PriorityQueue<Integer>();
		minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

	public void insertNum(int num) {
		/*
		 * add to max heap first
		 */
		if (maxHeap.isEmpty() || maxHeap.peek() >= num)
			maxHeap.add(num);
		else
			minHeap.add(num);
		/*
		 * check imbalance in the heaps
		 */

		if (maxHeap.size() > minHeap.size() + 1)
			minHeap.add(maxHeap.poll());
		else if (maxHeap.size() < minHeap.size())
			maxHeap.add(minHeap.poll());

	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size())
			return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
		else
			return maxHeap.peek();
	}
}

class SlidingWindowMedian {

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public SlidingWindowMedian() {
		// TODO Auto-generated constructor stub
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

	public double[] slidingWindowMedian(int[] nums, int k) {
		// insert
		double[] result = new double[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {

			if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i])
				maxHeap.add(nums[i]);
			else
				minHeap.add(nums[i]);

			// rebalance the heap
			rebalanceHeaps();
			/*
			 * 1. Check window 1a. Find median 1b. Remove the element from the sliding
			 * window 1c. rebalance the heap
			 */

			if (i - k + 1 >= 0) {
				if (maxHeap.size() == minHeap.size())
					result[i - k + 1] = ((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0;
				else
					result[i - k + 1] = maxHeap.peek();

				int elementToBeRemoved = nums[i - k + 1];
				if (elementToBeRemoved <= maxHeap.peek())
					maxHeap.remove(elementToBeRemoved);
				else
					minHeap.remove(elementToBeRemoved);

				rebalanceHeaps();

			}

		}
		return result;
	}

	public void rebalanceHeaps() {

		if (maxHeap.size() > minHeap.size() + 1)
			minHeap.add(maxHeap.poll());
		else if (minHeap.size() > maxHeap.size())
			maxHeap.add(minHeap.poll());

	}

}

class MaximizeCapital {

	public int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
		/*
		 * capital [0 1 2] profits [1 2 3] project = 2 initial capacity = 1
		 */

		/*
		 * Step 1 create min heap - add projects under the available capital create max
		 * heap - add all the profits for the above projects
		 */
		int n = profits.length;
		PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<Integer>(n, (i1, i2) -> capital[i1] - capital[i2]);
		PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<Integer>(n, (i1, i2) -> profits[i2] - profits[i1]);

		/*
		 * Add all capitals to the minHeap ?
		 */

		for (int i = 0; i < n; i++)
			minCapitalHeap.add(i);// [0 1 2 ]

		/*
		 * add all eligible capitals per the initial capital and sum up their profits
		 */

		int avaialableCapital = initialCapital;
		for (int i = 0; i < numberOfProjects; i++) {

			while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= avaialableCapital)
				maxProfitHeap.add(minCapitalHeap.poll());

			if (maxProfitHeap.isEmpty())
				break;

			// [2 0]
			avaialableCapital += profits[maxProfitHeap.poll()];

		}
		return avaialableCapital;
	}

}

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class NextInterval {

	public int[] findNextIntervals(Interval[] intervals) {
		/*
		 * Input: Intervals [[2,3], [3,4], [5,6]] Output: [1, 2, -1] maxEndTime[]
		 * maxStartTime[]
		 */
		int[] result = new int[intervals.length];
		int n = intervals.length;
		PriorityQueue<Integer> maxEndTime = new PriorityQueue<Integer>(n,
				(i1, i2) -> intervals[i2].end - intervals[i1].end);
		PriorityQueue<Integer> maxStartTime = new PriorityQueue<Integer>(n,
				(i1, i2) -> intervals[i2].start - intervals[i1].start);
		/*
		 * intervals = [2,3], [3,4], [5,6] maxEndTime[] = [2 1 0] maxStartTime[] = [2 1
		 * 0]
		 */

		for (int i = 0; i < n; i++) {
			maxEndTime.offer(i);
			maxStartTime.offer(i);
		}

		for (int i = 0; i < n; i++) {
			int topEnd = maxEndTime.poll();
			result[topEnd] = -1; // this is the initial default interval

			if (intervals[maxStartTime.peek()].start >= intervals[topEnd].end) {
				int topStart = maxStartTime.poll();

				while (!maxStartTime.isEmpty() & intervals[maxStartTime.peek()].start >= intervals[topEnd].end)
					topStart = maxStartTime.poll();

				result[topEnd] = topStart;
				maxStartTime.offer(topStart);
			}
		}
		return result;
	}

}
