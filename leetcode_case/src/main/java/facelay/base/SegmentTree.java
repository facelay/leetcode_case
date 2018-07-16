package facelay.base;

import facelay.inter.Merger;

/**
 * 线段树
 * 
 * @author facelay
 * @date 2018年7月16日 下午3:51:12
 * @param <E>
 */
public class SegmentTree<E> {

	private E[] tree;
	private E[] data;
	private Merger<E> merger;

	@SuppressWarnings("unchecked")
	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger = merger;

		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		tree = (E[]) new Object[4 * arr.length]; // 使用线段树需要创建4n个空间

		buildSegmentTree(0, 0, data.length - 1);
	}

	// 在treeIndex的位置创建表示区间[l...r]的线段树
	private void buildSegmentTree(int treeIndex, int l, int r) {
		if (l == r) {
			tree[treeIndex] = data[r];
			return;
		}

		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);

		int mid = l + (r - l) / 2;
		buildSegmentTree(leftTreeIndex, l, mid);
		buildSegmentTree(rightTreeIndex, mid + 1, r);

		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}

	public int getSize() {
		return data.length;
	}

	public E get(int index) {
		if (index < 0 || index >= data.length) {
			throw new IllegalArgumentException("Index is illegal.");
		}
		return data[index];
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的左子树节点的索引
	@SuppressWarnings("unused")
	private int leftChild(int index) {
		return 2 * index + 1;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的右子树节点的索引
	@SuppressWarnings("unused")
	private int rightChild(int index) {
		return 2 * index + 2;
	}

	// 返回区间[queryL,queryR]的值
	public E query(int queryL, int queryR) {
		if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR > data.length) {
			throw new IllegalArgumentException("Index is Illegal.");
		}
		return query(0, 0, data.length - 1, queryL, queryR);
	}

	// 在以treeIndex为根的线段树中[l,r]的范围里，搜索区间[queryL,queryR]的值
	private E query(int treeIndex, int l, int r, int queryL, int queryR) {
		if (l == queryL && r == queryR) {
			return tree[treeIndex];
		}

		int mid = l + (r - l) / 2;
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);

		if (queryL >= mid + 1) { // 在右子树区间内
			return query(rightTreeIndex, mid + 1, r, queryL, queryR);
		} else if (queryR <= mid) { // 在左子树区间内
			return query(leftTreeIndex, l, mid, queryL, queryR);
		}

		// 分别在该节点的左右区间都存在部分值区间
		E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
		E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

		return merger.merge(leftResult, rightResult);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("[");
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null) {
				res.append(tree[i]);
			} else {
				res.append("null");
			}
			if (i != tree.length - 1) {
				res.append(",");
			}
		}
		res.append("]");
		return res.toString();
	}

	public static void main(String[] args) {

		Integer[] nums = { -2, 0, 3, -5, 2, -1 };
		SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);
		System.out.println(segTree);
		Integer query = segTree.query(0, 2);
		Integer query1 = segTree.query(2, 5);
		System.out.println("返回结果：" + query);
		System.out.println("返回结果：" + query1);
	}
}