package facelay.controller;

import facelay.base.ListNode;

/**
 * 237. 删除链表中的节点
 * 
 * @author facelay
 * @date 2018年7月25日 下午3:38:59
 */
public class leetcode_237 {

	/**
	 * 
	 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
	 * 
	 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
	 * 
	 * 4 -> 5 -> 1 -> 9
	 * 
	 * 示例 1:
	 * 
	 * 输入: head = [4,5,1,9], node = 5 输出: [4,1,9]
	 * 
	 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
	 * 
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	/**
	 * 此例好像没有办法可以做测试用例，但是两行代码就可以解决这个问题
	 */
	public static void main(String[] args) {

	}

}
