package Leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class WordLadder {

    /*Shortest means need to tranverse all the possibilities
    Recursion, DFS
    
    Update: wrong: fail to try the letter that doesn't exist in end word
    
    Learn: 1. How to use two queue to BFS the tree -- use a separate queue to keep the layer*/
	
	
	
	public int wordLadder(String start, String end, HashSet<String> dict) {
		if (start.length() != end.length())
			return 0;

		Queue<String> wordsPending = new ArrayDeque<String>();
		Queue<Integer> wordLayer = new ArrayDeque<Integer>();

		wordsPending.add(start);
		wordLayer.add(1);
		while (wordsPending.size() != 0) {
			String cur = wordsPending.poll();
			int layer = wordLayer.poll();

			if (cur.equals(end))
				return layer;

			for (int i = 0; i < cur.length(); i++) {
				char[] curChar = cur.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (curChar[i] == c)
						continue;
					curChar[i] = c;
					String child = new String(curChar);
					if (dict.contains(child)) {
						wordsPending.add(child);
						wordLayer.add(layer + 1);
						dict.remove(child);
					}
				}
			}
		}
		return 0;
	}
	
	
	
//    public int ladderLength(String start, String end, HashSet<String> dict) {
//        int res = helper(start, end, dict);
//        return res < 0 ? 0 : res;
//    }
//    
//    private int helper(String start, String end, HashSet<String> dict) {
//        if (start.equals(end)) return 1;
//        int min = Integer.MAX_VALUE;
//        for (int i=0; i<end.length(); i++) {
//            if(start.charAt(i) != end.charAt(i)) {
//                String newStart = start.substring(0,i) + end.charAt(i) + start.substring(i+1);
//                if (dict.contains(newStart)) {
//                    int tmp = helper(newStart, end, dict);
//                    if (tmp > 0) min = Math.min(min, tmp+1);
//                }
//            }
//        }
//        return (min == Integer.MAX_VALUE) ? -1 : min;
//    }
}
