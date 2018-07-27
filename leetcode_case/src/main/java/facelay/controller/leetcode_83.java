package facelay.controller;

import java.util.Iterator;
import java.util.TreeSet;

import facelay.base.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 
 * @author facelay
 * @date 2018年7月26日 下午1:50:51
 */
public class leetcode_83 {

	/**
	 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	 * 
	 * 示例 1:
	 * 
	 * 输入: 1->1->2 输出: 1->2 示例 2:
	 * 
	 * 输入: 1->1->2->3->3 输出: 1->2->3
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		TreeSet<Integer> set = new TreeSet<>();

		while (head != null) {
			set.add(head.val);
			head = head.next;

		}

		Object[] obj = set.toArray();
		int temp[] = new int[obj.length];
		for (int i = 0; i < obj.length; i++) {
			temp[i] = (int) obj[i];
		}

		ListNode node = new ListNode(temp);
		return node;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3 };
		ListNode node = new ListNode(arr);
		System.out.println(node);
		ListNode node2 = new leetcode_83().deleteDuplicates(node);
		System.out.println(node2);

		ListNode node3 = new leetcode_83().deleteSame(node);
		System.out.println(node3);
	}

	public ListNode deleteSame(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}

}
