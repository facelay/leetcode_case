package facelay.controller;

import java.util.Stack;

import facelay.base.ListNode;

/**
 * 234. 回文链表
 * 
 * @author facelay
 * @date 2018年7月27日 下午3:43:03
 */
public class leetcode_234 {

	/**
	 * 请判断一个链表是否为回文链表。
	 * 
	 * 示例 1:
	 * 
	 * 输入: 1->2 输出: false 示例 2:
	 * 
	 * 输入: 1->2->2->1 输出: true
	 * 
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
		// 如果链表为空或者仅有一个元素那么肯定是回文链表
		if (head == null || head.next == null) {
			return true;
		}

		ListNode cur = head;
		Stack<Integer> stack = new Stack<>();
		while (cur != null) {
			stack.push(cur.val);
			cur = cur.next;
		}
		while (head != null) {
			if (stack.pop() != head.val) {
				return false;
			}
			head = head.next;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 1 };
		ListNode node = new ListNode(arr);
		boolean res = new leetcode_234().isPalindrome(node);
		System.out.println(res);
	}
}
