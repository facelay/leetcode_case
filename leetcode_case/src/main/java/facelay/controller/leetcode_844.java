package facelay.controller;

import java.util.Stack;

public class leetcode_844 {

	public static void main(String[] args) {

		boolean compare = new leetcode_844().backspaceCompare("a#bc", "a#bb#c");
		System.out.println("是否正确：" + compare);

	}

	/** 844. 比较含退格的字符串 */
	public boolean backspaceCompare(String S, String T) {

		return convert(S).equals(convert(T));

		// return backspace(S).equals(backspace(T));
	}

	// 最佳解决方案
	private String convert(String str) {
		int index = 0;
		char[] chars = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != '#')
				chars[index++] = c;
			else {
				if (index > 0)
					index--;
			}
		}
		return new String(chars, 0, index);
	}

	// 自己写的最佳
	@SuppressWarnings("unused")
	private Stack<Character> backspace(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '#') {
				stack.push(c);
			} else {
				if (!stack.empty()) {
					stack.pop();
				}
			}
		}
		return stack;
	}

}
