package Leetcode;
import java.util.Stack;


public class LongestValidParentheses {
    /*Use a left count counting ( and countr counting ). add countl whenever meet (. add countr only when it's smaller than countl (only this time it is valid)
    Wrong: "()(()" should be 2. Should take interuption of multiple '('s into consideration
    Update1: use startIndex to mark the starting point of a valid parentheses
    Update2: 必须要存（ 的index。所以必须用到stack！
    Update3: use stack to track the indexs of left parenthese so that we can deal with "((((...". 
    use last to track the invalid ')', it marks the begin of next group*/
    public int longestValidParentheses(String s) {
        Stack<Integer> lefts = new Stack<Integer>();
        int last = -1;
        int maxLen = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    last = i;
                } else {
                    lefts.pop();
                    if (lefts.isEmpty()) {
                        maxLen = Math.max(maxLen, i - last); // last is excluded
                    } else {
                        maxLen = Math.max(maxLen, i - lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }
	
	
	 // Before update 1
//    public int longestValidParentheses(String s) {
//        int countl = 0;
//        int startIndex = 0;
//        int countr = 0;
//        int maxLen = 0;
//        for (int i=0; i<s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                startIndex = i;
//                countl++;
//            } else {
//                maxLen = Math.max(maxLen, i-startIndex+1);
//                if (countl > countr) {
//                    while (s.charAt(--startIndex) != '(');
//                    countr++;
//                }
//            }
//        }
//        return maxLen;
//    }
}
