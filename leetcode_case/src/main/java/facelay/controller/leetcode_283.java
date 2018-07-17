package facelay.controller;

/**
 * 283. 移动零
 * 
 * @author facelay
 * @date 2018年7月17日 下午1:38:21
 */
public class leetcode_283 {

	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 * 
	 * 示例:
	 * 
	 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
	 * 
	 * 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
	 * 
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				for (int j = i; j < nums.length - 1; j++) {
					nums[j] = nums[j + 1];
				}
				nums[nums.length - 1] = 0;
				i--;
			}
			n++;
			if (n == nums.length) {
				break;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	// 优化后的解答，此题的重点是要维护两个坐标点
	public void moveZeroes2(int[] nums) {
		int i = -1;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == 0) {
				i = i < 0 ? j : i;
			} else if (i >= 0) {
				nums[i++] = nums[j];
				nums[j] = 0;
			}
		}
		for (int j = 0; j < nums.length; j++) {
			System.out.println(nums[j]);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 5, 1, 0, 3, 12 };
		new leetcode_283().moveZeroes2(nums);
	}
}
