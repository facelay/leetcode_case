package facelay.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 169. 求众数
 * 
 * @author facelay
 * @date 2018年7月31日 下午2:41:42
 */
public class lc_169 {

	/**
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	 * 
	 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
	 * 
	 * 示例 1:
	 * 
	 * 输入: [3,2,3] 输出: 3
	 * 
	 * 示例 2:
	 * 
	 * 输入: [2,2,1,1,1,2,2] 输出: 2
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		double half = nums.length / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iter = keySet.iterator();
		while (iter.hasNext()) {
			Integer next = iter.next();
			if (map.get(next) > half) {
				return next;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 1, 1, 1, 2, 2 };
		int res = new lc_169().majorityElement_2(arr);
		System.out.println("返回结果：" + res);
	}

	/**
	 * 最优解法
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement_2(int[] nums) {
		int result = nums[0], count = 0;
		for (int num : nums) {
			if (count == 0) {
				result = num;
				count++;
			} else {
				if (result == num) {
					count++;
				} else {
					count--;
				}
			}
		}
		return result;
	}
}
