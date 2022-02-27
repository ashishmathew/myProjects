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
		//insert
		double[] result = new double[nums.length -k + 1];
		for(int i = 0 ; i < nums.length ; i++) {
			
			if(maxHeap.isEmpty() || maxHeap.peek() >= nums[i])
				maxHeap.add(nums[i]);
			else
				minHeap.add(nums[i]);
			
			//rebalance the heap
			rebalanceHeaps();	
		/*
		 * 1.  Check window
		 * 1a. Find median
		 * 1b. Remove the element from the sliding window
		 * 1c. rebalance the heap
		 */
		
			if(i-k+1 >= 0) {
				if(maxHeap.size() == minHeap.size())
					result[i-k+1] = ((double)minHeap.peek() + (double)maxHeap.peek())/2.0;
				else
					result[i-k+1] = maxHeap.peek();
				
				int elementToBeRemoved = nums[i-k+1];
				if(elementToBeRemoved <= maxHeap.peek())
					maxHeap.remove(elementToBeRemoved);
				else
					minHeap.remove(elementToBeRemoved);
				
				rebalanceHeaps();
				
			}
			
		}
		return result;
	}

	public void rebalanceHeaps() {
		
		if(maxHeap.size() > minHeap.size() + 1)
			minHeap.add(maxHeap.poll());
		else if (minHeap.size() > maxHeap.size())
			maxHeap.add(minHeap.poll());
		
	}

}