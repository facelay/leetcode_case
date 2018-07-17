package facelay.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 
 * @author facelay
 * @date 2018年7月17日 上午9:34:29
 */
public class leetcode_1 {

	/**
	 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
	 * 
	 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
	 * 
	 * 示例:
	 * 
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * 
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3 };
		int[] twoSum = new leetcode_1().twoSum(nums, 6);
		System.out.println("返回结果：" + twoSum[0] + "--" + twoSum[1]);
	}
}
