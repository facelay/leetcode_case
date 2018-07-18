package facelay.base;

import java.util.TreeMap;

/**
 * Trie (字典树、前缀树)
 * 
 * @author facelay
 * @date 2018年7月18日 上午9:37:52
 */
public class Trie {

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
	private int size;

	public Trie() {
		root = new Node();
		size = 0;
	}

	public int getSize() {
		return size;
	}

	// 向Trie中添加一个新的单词word
	public void add(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);

		}
		if (!cur.isWord) {
			cur.isWord = true;
			size++;
		}
	}

	// 查询Trie中的某个单词是否存在
	public boolean query(String word) {
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

	// 查询单词的前缀
	public boolean prefix(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			} else {
				cur = cur.next.get(c);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("apple");
		System.out.println(trie.query("apple"));
		System.out.println(trie.query("app"));
		System.out.println(trie.prefix("app"));
		trie.add("app");
		System.out.println(trie.query("app"));
	}

}
