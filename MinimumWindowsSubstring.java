package Leetcode;

import java.util.HashMap;

public class MinimumWindowsSubstring {
	
	public static final void main(String[] args) {
		MinimumWindowsSubstring t = new MinimumWindowsSubstring();
//		System.out.print(t.minWindow("aoiwjljwbvyuwid;oqwijflqkebqvywiudhojwijjkdjvbdskudhoqiweqwdojwkvf", "jwijjkdjvbd"));
	}
	public class Solution {
	    /*
	    Use mapT to record the frequency of existing chars in T
	    check S char by char with right edge pointer - for loop
	    if the char is in T, decrease the frequency, and increase the count number.
	    when count number == T.length, that means T is included in the prev window,
	    then move left edge pointer until it no longer contains T.
	    
	    A typical thinkning is maintain a HashMap 
	    1.Substring with Concatenation of All Words
	    2.Longest Substring Without Repeating Characters
	    */
	    
	    public String minWindow(String S, String T) {
	        // Mark the number of unfounded T chars
	        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
	        //Initialize mapT with String T
	        for (int i=0; i<T.length(); i++){
	            char c = T.charAt(i);
	            if (mapT.containsKey(c)) {
	                mapT.put(c, mapT.get(c)+1);
	            } else {
	                mapT.put(c, 1);
	            }
	        }
	        
	        int count = 0; // count the number of chars in S which are also in T
	        int left = 0; // left pointer of the window.
	        int lenMin = S.length()+1;
	        String res = "";
	        
	        
	        //Go through S, i is the right pointer for the 'window'
	        for (int i=0; i<S.length(); i++) {
	            char c = S.charAt(i);
	            if (mapT.containsKey(c)){
	                mapT.put(c, mapT.get(c)-1); // Mark founded by deduction. allow it to be negative cuz when 'aaaaabc' and 'abc', later when we add 'a' to zero, it will be the last possible 'a' we can get, which garuantee the shortest.
	                if (mapT.get(c) >= 0) count++; // only count the valid number. If is negative, it's duplicate number.
	                
	                while (count == T.length()) {// all T are included in left pointer to right pointer(current i), Integers in map either is 0 or is negative
	                    char lc = S.charAt(left);
	                    if (mapT.containsKey(lc)) {
	                        mapT.put(lc,mapT.get(lc)+1);
	                        if (mapT.get(lc) > 0) { // Change it to be unfound. normally it should be 0 -> 1, but for negative, when it > 0 means the right most one for that char to contribute to T. Can't move anymore otherwise it won't covers all T
	                            if (i-left+1 < lenMin) {
	                                lenMin = i-left+1;
	                                res = S.substring(left, i+1);
	                            }
	                            count--; // remove this discovered char from count, end the while loop. Only found the right char again could we add the count
	                        }
	                    }
	                    left++; //move left pointer of window to new place
	                            //is invalid char or valid char but we need a new start place now
	                }
	                
	            }
	            // if mapT doesn't contain that char, or all that char in T has already be found in S, just move right pointer to next char
	        }
	        return res;
	    }
	
	
	
	
	
	
    /*Brute force: use each char which in T as the start point, calculate the window, compare with the shortest, update the index. it's O(N*M) complexity*/
    /* For complexity O(n), allows to scan T for once -- guess use hashtable<char boolean> O(M)  -- M < N
       1.Create a new hashtable<char, ArrayList<Integer>-- to store the appearing indexes>. Go through S once, for each char in index i, check whether it is in the hashtable<char boolean>, if it is, add the appearing indexes into the arraylist. O(N)
       2. go through hashtable, largest index - smallest index. then update the appearing index of the smallest index to the next, recalculate < O(N)
       -- question: what if T contains duplicate letters? -- use the first hashtable to store frequency
    
    *怀疑思路错了。觉得用Map肯定是对的，但leftletter, rightletter, leftindex, rightindex那块可能有错误
    *
    */
//    public String minWindow(String S, String T) {
//        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
//        for (int i=0; i<T.length(); i++) {
//            char ch = T.charAt(i);
//            if (!mapT.containsKey(ch)){
//                mapT.put(ch, 1);                
//            } else {
//                mapT.put(ch, mapT.get(ch)+1);
//            }
//        }
//        
//        HashMap<Character, ArrayList<Integer>> mapS = new HashMap<Character, ArrayList<Integer>>();
//        for (int i=0; i<S.length(); i++) {
//            char ch = S.charAt(i);
//            if (mapT.containsKey(ch)) {
//                if (!mapS.containsKey(ch)) {
//                    ArrayList<Integer> indexs = new ArrayList<Integer>();
//                    indexs.add(i);
//                    mapS.put(ch, indexs);
//                } else {
//                    ArrayList<Integer> indexs = mapS.get(ch);
//                    indexs.add(i);
//                    mapS.put(ch, indexs);
//                }
//            }
//        }
//        int leftIndex = S.length();
//        int rightIndex = 0;
//
//        int minLen = Integer.MAX_VALUE;
//        while(true) {
//            ArrayList<Integer> leftLetter = null;
//            ArrayList<Integer> rightLetter = null;
//            for (int i=0; i<T.length(); i++) {
//                char ch = T.charAt(i);
//                ArrayList<Integer> indexlist = mapS.get(ch);
//                
//                if(indexlist.size() == 0) {
//                    return S.substring(leftIndex, rightIndex+1);
//                }
//                // find the lowest index and highest index
//                if (leftLetter == null || indexlist.get(0) < leftLetter.get(0)) {
//                    leftLetter = indexlist;
//                }
//                if (rightLetter == null || indexlist.get(0) > rightLetter.get(0)) {
//                    rightLetter = indexlist;
//                }
//            }
//            if (rightLetter.get(0) - leftLetter.get(0) + 1 < minLen) {
//                leftIndex = leftLetter.get(0);
//                rightIndex = rightLetter.get(0);
//            }
//            leftLetter.remove(0);
//        }
    }
	
	
	
	
}
