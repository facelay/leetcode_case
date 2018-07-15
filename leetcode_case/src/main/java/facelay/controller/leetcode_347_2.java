package facelay.controller;


import java.util.*;

/**
 * 347. 前K个高频元素
 * <p>
 * 第二种解法，使用java自带的PriorityQueue，并且重写Comparator比较器
 */
public class leetcode_347_2 {

    /*
    private class Freq {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq;
        }
    }
    */

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int key : nums) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        //匿名类
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }


        LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.add(pq.remove());
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
