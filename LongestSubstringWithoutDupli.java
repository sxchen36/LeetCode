package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDupli {
	
	public static final void main(String[] args){
		LongestSubstringWithoutDupli t = new LongestSubstringWithoutDupli();
		System.out.print(t.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}
	
    /*Scan the array only once. use a set to store appeared chars for current substring
    if the char is already in set, check whether the finished substring is longer than the max one, update if needed, and reset everything and begin with the next char
    if the char is not there, length+1 and move to next char*/
    /* O(N) space and O(N) time complexity*/
    /*1.Update: should not reset the set, should not use set actually. ex "abcaekfs", 
     * if just cut everything and start from a, then we abundand "bc" before a which is also unique. 
     * Thus should use hashtable to store the char with their index, char is the key*/
	
    /*2.TLE because I spend too much time copying the map. How about just store the beginning index of the substring, 
     * if the value in map smaller than beginning index, just ignore the duplicate*/
	/*注意！！包含c的情况下，找到上个c的位置，+1设为起始位置，计算长度，以及！！要记得在*最后* update c的新位置！！！*/
	//2.
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c) || map.get(c) < start){
                map.put(c, i);
                curLen++;
            } else {
                start = map.get(c)+1;
                curLen = i-start+1;
                map.put(c, i);
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
	
	
	//1.
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        int maxLen = 0;
//        int curLen = 0;
//        for (int i=0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if (!map.containsKey(c)){
//                map.put(c, i);
//                curLen++;
//            } else {
//                maxLen = Math.max(maxLen, curLen);
//                int start = map.get(c);
//                int point = start+1;
//                map.clear();
//                curLen = i-start;
//            }
//        }
//        return curLen;
//    }
	
	
}
