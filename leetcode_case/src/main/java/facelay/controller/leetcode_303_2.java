package facelay.controller;

/**
 * 303. 区域和检索 - 数组不可变
 * 
 * @author facelay
 * @date 2018年7月16日 下午5:49:36
 */
public class leetcode_303_2 {
	/**
	 * sum[i]存储前i个元素的和,sum[0]=0;
	 * 
	 * sum[i]存储nums[0...i-1]的和。
	 */
	private int[] sum;

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
	public leetcode_303_2(int[] nums) {
		sum = new int[nums.length + 1]; // 此处因为sum[0]=0，所以会有一个偏移量
		sum[0] = 0;
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		int range = new leetcode_303_2(nums).sumRange(0, 3);
		System.out.println("返回结果：" + range);
	}

}
