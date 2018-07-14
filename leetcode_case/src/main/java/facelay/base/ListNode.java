package facelay.base;

public class ListNode {
	// Definition for singly-linked list.
	public int val;

	public ListNode next;

	public ListNode(int x) {
		this.val = x;
	}

	// 将数组转化为链表
	// 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
	public ListNode(int[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException("arr can not be empty.");
		}
		this.val = arr[0];
		ListNode cur = this;
		for (int i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("ListNode: ");
		ListNode cur = this;
		while (cur != null) {
			res.append(cur.val + "->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
}
