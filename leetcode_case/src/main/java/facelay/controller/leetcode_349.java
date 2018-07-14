package facelay.controller;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 349. 两个数组的交集
 * 
 * @author facelay
 * @date 2018年7月12日 上午11:54:28
 */
public class leetcode_349 {

	/**
	 * 给定两个数组，写一个函数来计算它们的交集。
	 * 
	 * 例子:
	 * 
	 * 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
	 * 
	 * 提示:
	 * 
	 * 每个在结果中的元素必定是唯一的。 我们可以不考虑输出结果的顺序。
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : nums2) {
			if (set.contains(num)) {
				list.add(num);
				set.remove(num);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 2, 1, 4 };
		int[] nums2 = new int[] { 2, 2, 3, 4 };
		int[] is = new leetcode_349().intersection(nums1, nums2);
		for (int i : is) {
			System.out.println(i);
		}
	}
}
