package facelay.base;

import java.util.Stack;
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

	// 使用递归的方式向Trie中添加一个新的单词word
	public void addRecursion(String word) {
		addRecursion(root, word, 0);
	}

	private void addRecursion(Node node, String word, int index) {
		if (index == word.length()) {
			if (!node.isWord) {
				node.isWord = true;
				size++;
			}
			return;
		}
		char c = word.charAt(index);
		if (node.next.get(c) == null) {
			node.next.put(c, new Node());
		}
		addRecursion(node.next.get(c), word, index++);

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

	// 方式一：
	// 删除Trie中的单词word
	public void delete(String word) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = root;
		// 首先判断word是否存在
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return;
			}
			cur = cur.next.get(c);
			if (i != word.length() - 1) {
				stack.push(cur); // 最后一个节点不用压入栈中
			}
		}
		// 此处判断cur节点的isWord是否为true
		if (cur.isWord) {
			// 代表word这个单词是存在的，现在判断cur下是否还有其他的节点，如果存在，则表示还有其他的单词,此时将isWord设置为false即可
			if (!cur.next.isEmpty()) {
				cur.isWord = false;
				stack.clear(); // 清空资源
			} else {
				// 自下而上删除每一个字符节点，如果遇到存在其它分支的节点或者isWord=true时，终止删除
				while (!stack.isEmpty()) {
					Node node = stack.pop();
					if (node.next.size() <= 1 && !node.isWord) {
						// 此时删除这个节点的子节点
						node.next = new TreeMap<>();
					} else {
						stack.clear();
						break;
					}
				}
			}
			size--;
		}
	}

	static class StopMsgException extends RuntimeException {
	}

	// 方式二：
	public void remove(String word) {
		try {
			remove(root, word, 0);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// 使用递归操作删除Trie中的单词word
	private void remove(Node node, String word, int offset) throws Exception {
		if (offset == word.length()) {
			if (node.isWord) { // 此时表示这个单词存在的，可以删除
				size--;
				if (!node.next.isEmpty()) { // 如果这个字母后面还有分支，那么设置该节点的isWord=false即可
					node.isWord = false;
					throw new StopMsgException(); // 强制终止递归
				}
				return;
			}
		}

		remove(node.next.get(word.charAt(offset)), word, offset + 1);
		// 此处判断该节点isWord是否为true，并且是否存在其他分支的子节点
		if (!node.isWord && node.next.size() <= 1) {
			node.next = new TreeMap<>();
		} else {
			throw new StopMsgException();
		}

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("apple");
		trie.add("apples");
		trie.add("app");
		trie.add("atc");
		trie.add("atce");
		trie.remove("apple");
		System.out.println(trie.query("apple"));
		System.out.println(trie.query("apples"));
		System.out.println(trie.query("app"));
		System.out.println(trie.query("atce"));
		System.out.println(trie.query("atc"));
		System.out.println(trie.getSize());

	}

}
