package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class WordLadder2 {
    /*BFS, but a third queue to keep the path reach this node
     * Wrong because it remove words from dict which disable other path in the same layer...*/
//    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
//        		Queue<String> words = new ArrayDeque<String>();
//		Queue<ArrayList<String>> paths = new ArrayDeque<ArrayList<String>>();
//
//		words.add(start);
//		ArrayList<String> path = new ArrayList<String>();
//		path.add(start);
//		paths.add(path);
//
//		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
//		int resultLayer = 0;
//
//		while (words.size() != 0) {
//			String cur = words.poll();
//			ArrayList<String> p = paths.poll();
//			int layer = p.size();
//			if (cur.equals(end)) {
//				if (resultLayer == 0) {
//					resultLayer = layer;
//					res.add(p);
//				} else if (layer == resultLayer) {
//					res.add(p);
//				} else {
//					break;
//				}
//			}
//
//			for (int i = 0; i < cur.length(); i++) {
//				char[] chars = cur.toCharArray();
//				for (char c = 'a'; c <= 'z'; c++) {
//					if (chars[i] == c)
//						continue;
//					chars[i] = c;
//					String ns = new String(chars);
//					if (dict.contains(ns)) {
//						words.add(ns);
//						ArrayList<String> np = new ArrayList<String>(p);
//						np.add(ns);
//						paths.add(np);
//						if (!ns.equals(end)) dict.remove(ns);
//					}
//				}
//			}
//		}
//		return res;
//    }

}
