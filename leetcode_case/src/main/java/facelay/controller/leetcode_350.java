package facelay.controller;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 350. 两个数组的交集 II
 * 
 * @author facelay
 * @date 2018年7月12日 下午2:16:35
 */
public class leetcode_350 {

	/**
	 * 给定两个数组，写一个方法来计算它们的交集。
	 * 
	 * 例如: 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
	 * 
	 * 注意：
	 * 
	 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 我们可以不考虑输出结果的顺序。 跟进:
	 * 
	 * 如果给定的数组已经排好序呢？你将如何优化你的算法？ 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
	 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : nums1) {
			if (map.containsKey(num)) {
				// map.put(num, map.get(num) + 1); // 此处使用replace语义方面比较合适
				map.replace(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int n : nums2) {
			if (map.containsKey(n)) {
				list.add(n);
				map.put(n, map.get(n) - 1);
				if (map.get(n) == 0) {
					map.remove(n);
				}
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
		int[] is = new leetcode_350().intersect(nums1, nums2);
		for (int i : is) {
			System.out.println(i);
		}
	}
}
