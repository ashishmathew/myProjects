package com.practice;
import java.util.PriorityQueue;
class MedianOfStream {
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;

	public MedianOfStream() {
		maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
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
		if(maxHeap.size() == minHeap.size())
			return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
		else 
			return maxHeap.peek();
	}
}