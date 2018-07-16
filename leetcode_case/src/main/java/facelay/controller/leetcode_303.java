package facelay.controller;

import facelay.base.SegmentTree;

/**
 * 303. 区域和检索 - 数组不可变
 * 
 * @author facelay
 * @date 2018年7月16日 下午5:49:36
 */
public class leetcode_303 {

	private SegmentTree<Integer> segTree;

	/**
	 * 给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
	 * 
	 * 示例：
	 * 
	 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
	 * 
	 * sumRange(0, 2) -> 1
	 * 
	 * sumRange(2, 5) -> -1
	 * 
	 * sumRange(0, 5) -> -3
	 * 
	 * 说明:
	 * 
	 * 1、你可以假设数组不可变。
	 * 
	 * 2、会多次调用 sumRange 方法。
	 * 
	 * @param nums
	 * @return
	 */
	public leetcode_303(int[] nums) {
		if (nums.length > 0) {
			Integer[] data = new Integer[nums.length];
			for (int i = 0; i < nums.length; i++) {
				data[i] = nums[i];
			}
			segTree = new SegmentTree<>(data, (a, b) -> a + b);
		}
	}

	public int sumRange(int i, int j) {
		if (segTree == null) {
			throw new IllegalArgumentException("SegmentTree is null.");
		}
		return segTree.query(i, j);
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		int range = new leetcode_303(nums).sumRange(0, 3);
		System.out.println("返回结果：" + range);
	}

}
