package facelay.base;

import java.util.ArrayList;
import java.util.Random;

/**
 * 利用数组实现最大堆
 * 
 * @author facelay
 * @date 2018年7月12日 下午5:49:35
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

	public ArrayList<E> data;

	public MaxHeap(int capacity) {
		data = new ArrayList<>(capacity);
	}

	public MaxHeap() {
		data = new ArrayList<>();
	}

	// 构造函数，传入一个数组，然后heapify操作
	public MaxHeap(E[] arr) {
		data = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			data.add(arr[i]);
		}
		int n = parent(arr.length - 1);
		for (int i = n; i >= 0; i--) {
			siftDown(i);
		}
	}

	// 返回队堆中元素的个数
	public int size() {
		return data.size();
	}

	// 判断是否为空
	public boolean isEmpty() {
		return data.isEmpty();
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
	public int parent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException("index-0 doesn't have parent.");
		}
		return (index - 1) / 2;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的左子树节点的索引
	public int leftChild(int index) {
		return index * 2 + 1;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的右子树节点的索引
	public int rightChild(int index) {
		return index * 2 + 2;
	}

	// 向堆中添加元素
	public void add(E e) {
		data.add(e);
		siftUp(data.size() - 1);
	}

	// 判断加入的新元素的值是否符合完全二叉树的定义
	private void siftUp(int k) {
		while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
			swap(k, parent(k));
			k = parent(k);
		}
	}

	private void swap(int i, int j) {
		if (i < 0 || i > data.size() || j < 0 || j > data.size()) {
			throw new IllegalArgumentException("Index is illegal.");
		}
		// 首先获取i位置的元素值
		E t = data.get(i);
		// 向j位置添加i位置的元素，并返回j位置的元素
		E e = data.set(j, t);
		// 将j位置的元素添加到i位置，实现i、j 位置元素的交换
		data.set(i, e);
	}

	// 返回堆中最大元素
	public E findMax() {
		if (data.size() == 0) {
			throw new IllegalArgumentException("Can not findmax when heap is empty");
		}
		return data.get(0);
	}

	// 取出堆中最大的元素
	public E extractMax() {
		E ret = findMax();
		// 将堆中的最大值set到数组的末尾中去，并返回末尾的元素
		// 将末尾的元素set到数组的头位置，实现数组位置交换
		swap(data.size() - 1, 0);
		// 最终删除数组最后一个位置的元素
		data.remove(data.size() - 1);

		// 判断此时头位置的元素是否满足完全二叉树的定义，否则循环交换位置
		siftDown(0); // 下沉

		return ret;
	}

	public E replace(int index, E e) {
		if (data.get(index) == null) {
			throw new IllegalArgumentException("the MaxHeap have no index.");
		}
		return data.set(index, e);
	}

	// 下沉元素，找到合适的位置存放
	private void siftDown(int k) {
		while (leftChild(k) < data.size()) {
			int j = leftChild(k);
			if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
				j++; // 此时j就转移到右子树的位置上了
			}
			// 如果该节点的元素比它子节点的最大元素还大，则停止下沉
			if (data.get(k).compareTo(data.get(j)) >= 0) {
				break;
			}
			// 交换位置
			swap(j, k);
			k = j;
		}
	}

	public static void main(String[] args) {
		int n = 10;
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			maxHeap.add(random.nextInt(100));
		}
		System.out.println(maxHeap.data);
//
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = maxHeap.extractMax();
//		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		Integer integer = maxHeap.replace(10, 666);
		System.out.println(integer);
		System.out.println(maxHeap.data);
	}

}
