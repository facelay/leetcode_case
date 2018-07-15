package facelay.controller;

import facelay.base.PriorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 347. 前K个高频元素
 */
public class leetcode_347 {

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * <p>
     * 例如，
     * <p>
     * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
     * <p>
     * 注意：
     * <p>
     * 你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.add(pq.dequeue().e);
        }

        return list;
    }

    // 自定义一个优先级规则，作为最大堆的定义
    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 9};
        List<Integer> list = new leetcode_347().topKFrequent(nums, 2);

        for (int num : list) {
            System.out.println(num);

        }
    }
}
