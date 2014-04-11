package Leetcode;

public class InterleavingString {
	
	public static final void main(String[] args){
		InterleavingString t = new InterleavingString();
		System.out.print(t.isInterleave("abba", "b", "abbba"));
	}
	
	
	
    /*
    Dynamic Problem. To see whether s1 exist in s3, if it is, subtract it from s3 to get s3', to see whether s2 exist in s3'
    DP: how to check whether s1 exist in s3
        B is s3, A is s1
        dp[i,j] = dp[i-1,j-1] if A[i] == B[j]
        dp[i,j] = dp[i, j-1] if !=
        Base Case: i==0 or j==0  
    */
//    public boolean isInterleave(String s1, String s2, String s3) {
//        
//    }
//    
//    // test whether s2 has s1 in it
//    private boolean isInter(boolean[][] map, String s1, int i, String s2, int j){
//        
//        if (j == 0) {
//            if (i != 0) return false;
//            return (s2.charAt(j) == s1.charAt(i));
//        } else if (i == 0) {
//            for (int x=0; x<=j; x++) {
//                if (s1.charAt(0) == s2.charAt(x)) return true;
//            }
//            return false;
//        }
//        
//        
//        String t1 = s1.subString(i);
//            String t2 = s2.subString(j);
//            return t1.equals(t2)
//    }
	
	
	/*
	 * Second thought: have a map[i] 是 int， 扫一遍s1,每个字符，从上一个字符存在的位置找起，如果碰到了，就存下来这个字符的位置
	 * Wrong! 逻辑错了，比如 “aa” "ab" "aaba" 就没法判断了因为我默认为s1在s3中只有一种存在形式
	 */
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s3.length() != s1.length()+s2.length()) {
//            return false;
//        } else if (s3 == "") {
//            return true;
//        }
//        
//        
//        int[] map = new int[s1.length()];
//        boolean s1Ins3 = interleaveOneString(s1,s3,map);
//        if (s1Ins3) {
//            // make a copy of s3
//            String s4 = new String(s3);
//            for(int i=0; i<map.length-1; i++){
//               s4 = s4.replace(""+s3.charAt(map[i]), "");
//            }
//            int[] map2 = new int[s2.length()];
//            return(interleaveOneString(s2,s4,map2));
//        } else {
//            return false;
//        }
//    }
//    
//    // whether s1 is in s3
//    private boolean interleaveOneString(String s1, String s3, int[] map){
//        
//        if (s1.equals("")) return true;
//        
//        int len1 = map.length;
//
//        //initial
//        for(int i=0; i<map.length; i++){
//            map[i] = -1;
//        }
//        
//        int start = 0;
//        for(int i=0; i<len1; i++){
//            char cur = s1.charAt(i);
//            for (int j=start; j<s3.length(); j++) {
//                if (s3.charAt(j) == cur) {
//                    map[i] = j;
//                    start = j+1;
//                    break; // record index of found place, reset start to next index, move to next char in s1;
//                }
//            }
//            if (map[i] == -1) break; // cur is not found! s1 doesn't exist in s3
//        }
//        return map[len1-1] != -1;
//    }
    
    
    
    
    /*
     1. s1.length+s2.length = s3.length
     2. s3 must be consists exactly letters from s1 and s2, no redundancy.
     3. i is pointer for s1, j is pointer for s2. iterate s3 as n
     	- if [n] != [i] or [j] false
     	- if [n] == [i] but != [j] i++ next turn(n+1)  same for j
     	- if [n] == [i] == [j]  return recursion result ( i++,n++ || j++ n++)
    */
	/*DP map[i][j] means s3[0...i+j-1] contains s1[0...i-1] and s2[0...j-1] -- i and j starts from 1*/
	/* 大体正确，只是注意初始条件！！！*/
//	boolean[][] map;
//    public boolean isInterleave(String s1, String s2, String s3) {
//        // Assert same length
//        if (s3.length() != s1.length()+s2.length()) {
//            return false;
//        }
//        map = new boolean[s1.length()+1][s2.length()+1];
//        map[0][1] = (s3.charAt(0) == s2.charAt(0));
//        map[1][0] = (s3.charAt(0) == s1.charAt(0));
//        int p3 = 0;
//        int p1 = 1;
//        int p2 = 1;
//        while(p3 < map.length+map[0].length){
//        	if(s3.charAt(p3) == s1.charAt(p1)){
//        		map[p1+1][p2] = map[p1][p2] || map[p1+1][p2-1];
//        		p3++;
//        		p1++;
//        	}
//        	if(s3.charAt(p3) == s2.charAt(p2)){
//        		map[p1][p2+1] = map[p1][p2] || map[p1-1][p2+1];
//        		p2++;
//        		p3++;
//        	}
//        }
//        return map[s1.length()][s2.length()];
//        
//    }
	
	/**
	 * AC!!!!! 太TM不容易了……
	 * 想明白初始化条件！！！在for循环之前初始化！！
	 * 注意xth和index的互相转换，边界条件。
	 * DP的思想就是bottom up 用[][] 来做。继续练！
	 */
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s3 == "") {
            if (s1 == "" && s2 == "") return true;
            return false;
        } else if (s1 == ""){
            return s2.equals(s3);
        } else if (s2 == ""){
            return s1.equals(s3);
        }
        
        // Assert same length
        if (s3.length() != s1.length()+s2.length()) {
            return false;
        }
        boolean[][] map = new boolean[s1.length()+1][s2.length()+1];
        // initialize  0 represent "", 1 represent first number; index should be i-1
        map[0][0] = true;
       for (int j=1; j<s2.length()+1; j++){
                if (s3.charAt(j-1) == s2.charAt(j-1)) {
                    map[0][j] |= map[0][j-1];
                } else {
                    map[0][j] = false;
                }
        }
        for (int i=1; i<s1.length()+1; i++){
                if (s3.charAt(i-1) == s1.charAt(i-1)) {
                    map[i][0] |= map[i-1][0];
                } else {
                    map[i][0] = false;
                }
        }
        for(int i=1; i<s1.length()+1; i++){
            for (int j = 1; j<s2.length()+1; j++){
                map[i][j] = (map[i-1][j] && (s3.charAt(i+j-1) == s1.charAt(i-1))) || (map[i][j-1] && (s3.charAt(i+j-1) == s2.charAt(j-1)));
            }
        }
        return map[s1.length()][s2.length()];
    }
        
}
