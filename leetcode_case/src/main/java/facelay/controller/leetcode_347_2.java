package facelay.controller;


import java.util.*;

/**
 * 347. 前K个高频元素
 * <p>
 * 第二种解法，使用java自带的PriorityQueue，并且重写Comparator比较器
 */
public class leetcode_347_2 {

    private class Freq {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    //自定义比较器
    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq;
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int key : nums) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }


        LinkedList<Integer> list = new LinkedList<>();
        for (int num : list) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 9};
        List<Integer> list = new leetcode_347().topKFrequent(nums, 2);

        for (int num : list) {
            System.out.println(num);
        }
    }
}
