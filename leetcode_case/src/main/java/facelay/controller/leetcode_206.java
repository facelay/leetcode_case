package facelay.controller;

import facelay.base.ListNode;

/**
 * 反转链表
 *
 * @author facelay
 * @date 2018年7月10日 下午5:38:18
 */
public class leetcode_206 {

    /**
     * 使用递归的方式反转链表
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode nextNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return nextNode;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode node = new leetcode_206().reverseList(listNode);
        System.out.println(node);
    }

}
