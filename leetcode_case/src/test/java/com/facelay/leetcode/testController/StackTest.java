package com.facelay.leetcode.testController;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {

		String str = "[{()()}]{}(){}";
		boolean valid = new StackTest().isValid(str);
		System.out.println("是否合格：" + valid);
	}

	/**
	 * 去除无用
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			if (charAt == '(' || charAt == '[' || charAt == '{') {
				stack.push(charAt);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (stack.peek() == '(' && charAt == ')') {
						stack.pop();
					} else if (stack.peek() == '[' && charAt == ']') {
						stack.pop();
					} else if (stack.peek() == '{' && charAt == '}') {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}
}
