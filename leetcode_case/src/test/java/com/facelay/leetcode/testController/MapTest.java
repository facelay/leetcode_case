package com.facelay.leetcode.testController;

import java.util.ArrayList;
import java.util.HashMap;

import facelay.base.LinkedListMap;
import facelay.common.FileOperation;
import facelay.inter.Map;

public class MapTest {

	public double retrieve(Map<String, Integer> map, String filename) {

		long startTime = System.nanoTime();

		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(filename, words)) {
			for (String word : words) {
				if (map.contains(word)) {
					map.set(word, map.get(word) + 1);
				} else {
					map.add(word, 1);
				}
			}
			System.out.println("Total diffent words:" + map.getSize());
			System.out.println("Frequency of PRIDE:" + map.get("pride"));
			System.out.println("Frequency of PREJUDICE:" + map.get("is"));
		}

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

	public static void main(String[] args) {
		System.out.println("pride and prejudice");
		String filename = "pride-and-prejudice.txt";
		java.util.Map<String, Integer> map2 = new HashMap<>();
		double time2 = new MapTest().retrieve(map2, filename);
		System.out.println("TreeMap time:" + time2);

		System.out.println();

		LinkedListMap<String, Integer> map1 = new LinkedListMap<>();
		double time1 = new MapTest().retrieve(map1, filename);
		System.out.println("LinkedListMap time:" + time1);
	}

	/**
	 * javaUtil自带的HashMap 树结构
	 * 
	 * @param map2
	 * @param filename
	 * @return
	 */
	private double retrieve(java.util.Map<String, Integer> map2, String filename) {
		long startTime = System.nanoTime();

		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(filename, words)) {
			for (String word : words) {
				if (map2.containsKey(word)) {
					map2.replace(word, map2.get(word) + 1);
				} else {
					map2.put(word, 1);
				}
			}
			System.out.println("Total diffent words:" + map2.size());
			System.out.println("Frequency of PRIDE:" + map2.get("pride"));
			System.out.println("Frequency of PREJUDICE:" + map2.get("is"));
		}

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

}
