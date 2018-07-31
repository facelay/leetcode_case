package facelay.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 
 * @author facelay
 * @date 2018年7月31日 上午9:29:55
 */
public class leetcode_94 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode root;

	// 向二分搜索树中添加新的元素
	public void add(int e) {
		root = add(this.root, e);
	}

	// 向以node为根的二分搜索树中插入元素e，递归算法
	// 返回插入新节点后二分搜索树的根
	private TreeNode add(TreeNode node, int e) {

		if (node == null) {
			return new TreeNode(e);
		}

		if (e < node.val) {
			node.left = add(node.left, e);
		} else {
			node.right = add(node.right, e);
		}
		return node;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		list = inOrder(root, list);
		return list;
	}

	private List<Integer> inOrder(TreeNode node, List<Integer> list) {

		if (node == null) {
			return list;
		}
		inOrder(node.left, list);
		list.add(node.val);
		inOrder(node.right, list);
		return list;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 3 };
		leetcode_94 lc = new leetcode_94();
		for (int i = 0; i < arr.length; i++) {
			lc.add(arr[i]);
		}
		List<Integer> list = new ArrayList<>();
		list = lc.inOrder(lc.root, list);
		System.out.println("list size:" + list.size());
		for (Integer num : list) {
			System.out.println(num);
		}
	}
}
