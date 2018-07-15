package facelay.controller;

import java.util.Stack;

/**
 * 9. 回文数
 */
public class leetcode_9 {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        if (str.equals(res.toString())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean flag = new leetcode_9().isPalindrome(121);
        System.out.println("返回结果：" + flag);
    }
}
