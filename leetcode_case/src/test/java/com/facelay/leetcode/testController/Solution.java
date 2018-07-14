package com.facelay.leetcode.testController;

import java.util.Iterator;
import java.util.LinkedList;

import facelay.base.ListNode;

public class Solution {

	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = head;
		ListNode prv = dummyHead;
		while (prv.next != null) {
			if (prv.next.val == val) {
				// prv.next = prv.next.next;
				ListNode delNode = prv.next;
				prv.next = delNode.next;
				delNode.next = null;
			} else {
				prv = prv.next;
			}
		}
		return dummyHead;
	}

	/**
	 * 使用递归删除链表中的元素
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements2(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		head.next = removeElements2(head.next, val);
		return head.val == val ? head.next : head;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 6, 3, 4, 5, 6 };

		ListNode listNode = new ListNode(arr);
		System.out.println(listNode);

		ListNode node = new Solution().removeElements2(listNode, 6);
		System.out.println(node);

		// LinkedList<Integer> linkedList = new LinkedList<Integer>();
		// List<Integer> list = new ArrayList<>();
		// for (int i = 0; i < arr.length; i++) {
		// list.add(arr[i]);
		// }
		// boolean b = linkedList.addAll(list);
		//
		// Integer integer = linkedList.set(2, 666);
		// System.out.println(linkedList);

		// LinkedList specElem = new Solution().removeSpecElem(linkedList, 6);
		// System.out.println(specElem);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedList removeSpecElem(LinkedList linkedList, int val) {
		LinkedList list = new LinkedList();
		if (!linkedList.isEmpty()) {
			Iterator iterator = linkedList.iterator();
			while (iterator.hasNext()) {
				Object next = iterator.next();
				if (next.toString().equals(val + "")) {
					System.out.println("The element to be deleted is: " + next);
				} else {
					list.add(next);
				}
			}
		}
		return list;
	}
}
