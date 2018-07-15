package facelay.controller;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 */
public class leetcode_451 {

    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * "tree"
     * <p>
     * 输出:
     * "eert"
     * <p>
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq a, Freq b) {
                return b.freq - a.freq;
            }
        });

        for (Character n : map.keySet()) {
            pq.add(new Freq(n, map.get(n)));
        }

        LinkedList<Freq> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }

        StringBuilder res = new StringBuilder();
        for (Freq freq : list) {
            for (int i = 0; i < freq.freq; i++) {
                res.append(freq.e);
            }
        }

        return res.toString();
    }

    private class Freq {
        Character e;
        int freq;

        public Freq(Character e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }


    public static void main(String[] args) {
        String str = "AbbbaaaAAcdbBB";
        String s = new leetcode_451().frequencySort(str);
        System.out.println(" 执行结果：" + s);
    }
}
