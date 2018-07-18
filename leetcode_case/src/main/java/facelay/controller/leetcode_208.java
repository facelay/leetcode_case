package facelay.controller;

import java.util.TreeMap;

/**
 * 208. 实现 Trie (前缀树)
 * 
 * @author facelay
 * @date 2018年7月18日 下午2:34:50
 */
public class leetcode_208 {

	/**
	 * 
	 * 设计一个支持以下两种操作的数据结构：
	 * 
	 * void addWord(word)
	 * 
	 * bool search(word) search(word)
	 * 
	 * 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
	 * 
	 */

	private class Node {
		public boolean isWord;
		public TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			this.next = new TreeMap<>();
		}

		public Node() {
			this(false);
		}
	}

	private Node root;

	/** Initialize your data structure here. */
	public leetcode_208() {
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);

		}
		cur.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			} else {
				cur = cur.next.get(c);
			}
		}
		return cur.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			} else {
				cur = cur.next.get(c);
			}
		}
		return true;
	}
}
