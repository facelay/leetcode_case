package com.facelay.leetcode.testController;

import java.util.Random;

import facelay.base.MaxHeap;

public class MaxHeapTest {

	public static double heapInit(Integer[] arr, boolean isHeapify) {

		long startTime = System.nanoTime();
		MaxHeap<Integer> maxHeap;
		if (isHeapify) { // 使用堆化方式
			maxHeap = new MaxHeap<>(arr);
		} else {
			// 使用正常循环添加方式
			maxHeap = new MaxHeap<Integer>();
			for (int i = 0; i < arr.length; i++) {
				maxHeap.add(arr[i]);
			}
		}
		/*int[] extr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			extr[i] = maxHeap.extractMax();
		}
		for (int i = 0; i < extr.length - 1; i++) {
			if (extr[i] < extr[i + 1]) {
				throw new IllegalArgumentException("the maxHeap add method errors");
			}
		}*/

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		int n = 10000;
		Random random = new Random();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(Integer.MAX_VALUE);
		}

		double time1 = new MaxHeapTest().heapInit(arr, true);
		System.out.println("heapify time:" + time1);
		
		double time2 = new MaxHeapTest().heapInit(arr, false);
		System.out.println("array add time:" + time2);
		
	}

}
