package com.facelay.leetcode.testController;

import java.util.ArrayList;

import facelay.base.Trie;
import facelay.common.FileOperation;
import facelay.inter.BST;

public class TrieTest {

	public static void main(String[] args) {
		System.out.println("pride-and-prejudice.txt");
		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
			System.out.println("total words size:" + words.size());

			long startTime = System.nanoTime();
			Trie trie = new Trie();
			for (String word : words) {
				trie.add(word);
			}
			System.out.println("Trie size:" + trie.getSize());
			long endTime = System.nanoTime();

			double time = (endTime - startTime) / 1000000000.0;
			System.out.println("Trie elapsed time:" + time);

			//////////////////////////////////////

			startTime = System.nanoTime();
			BST<String> bst = new BST<>();
			for (String word : words) {
				bst.add(word);
			}
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("BST elapsed time:" + time);
		}
	}
}
