package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SubstringConcatenationAllWords {
	public static final void main(String[] args){
		SubstringConcatenationAllWords t = new SubstringConcatenationAllWords();
		String[] L={"foo","bar"};
		for (Integer i : t.findSubstring("barfoothefoobarman",L)){
			System.out.println(i+", ");
		}
	}
	
	
	/*
    <0>Same length: mean something here.
    1. if length is n, check every n letters whether they are all the first letters in L, but what if the order matters? wrong solution
    2. count the length of the sum string of L as len, For each char in S, start at that point and count for len chars
        if doesn't match, move left pointer, deduct the count of the dropped char
        if count match, then check whether their order is right, if it is, return the left pointer,if not, move left pointer again
        end point: right pointer == S.length-1
        O(MN)
    Wrong!
        
    May be should use HashMap<String, Integer> and store L's element as the key instead of the single char
    
    */
	
	
	//<0> Wrong
//    public ArrayList<Integer> findSubstring(String S, String[] L) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        // initialize the map for whole L
//        for (String s : L){
//            for (int i=0; i<s.length(); i++) {
//                char c = s.charAt(i);
//                if (map.containsKey(c)) {
//                    map.put(c, map.get(c)+1);
//                } else {
//                    map.put(c, 1);
//                }
//            }
//        }
//        
//        int len = L[0].length()*L.length;
//        
//        // count from left pointer 
//        int left = 0;
//        int count = 0;
//        while (left < S.length() - len) {
//            for (int i=0; i<len; i++) {
//                char c = S.charAt(left + i);
//                if (map.containsKey(c)) {
//                    if (map.get(c) > 0){
//                        map.put(c, map.get(c)-1);  
//                        count++;
//                    } else { // no need for c, previous c is enough, then move left to the leftest c and add 1
//                        while (S.charAt(left) != c){
//                        	char l = S.charAt(left);
//                            map.put(l, map.get(l)+1);
//                            left++;
//                            count--;
//                        }
//                        left++;
//                        count--;
//                        break;
//                    }
//                } else { // index left+i is a char not in L, no start point available between left - left+i, thus set left to next possible index and reset count;
//                    left = left+i+1;
//                    count = 0;
//                    break;
//                }
//            }
//            if (count == len) {
//                // should judge whether chars are in right order
//                if (isOrder(left, S, len, L)) {
//                    res.add(left);
//                    char c = S.charAt(left);
//                    map.put(c, map.get(c)+1);
//                    left++;
//                    count--;     
//                }
//            }
//            
//        }
//        return res;
//    }
//    
//    private boolean isOrder(int left, String S, int len, String[] L) {
//        HashSet<String> set = new HashSet<String>();
//        for (String s: L){
//        	set.add(s);
//        }
//        for (int i=left; i<left+len; i+=3){
//            if(!set.contains(S.substring(i,i+3))) return false;
//        }
//        return true;
//    }
}
