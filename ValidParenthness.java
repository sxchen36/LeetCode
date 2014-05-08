package Leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthness {
	public boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			if (map.containsValue(sc)) {
				stack.push(sc);
			} else {
				if (stack.empty())
					return false;
				char c = stack.peek();
				if (map.get(sc) == c) {
					stack.pop();
				} else {
					return false;
				}
			}

		}
		return stack.empty();
	}
}
