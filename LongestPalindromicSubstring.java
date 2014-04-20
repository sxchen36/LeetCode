package Leetcode;

public class LongestPalindromicSubstring {
	
	public static final void main(String[] args){
		LongestPalindromicSubstring t = new LongestPalindromicSubstring();
		String s = "aaaa";
		t.longestPalindrome(s);
	}
	
    /* Accept 啦！！！貌似算法的最后一次作业做过嗯嗯嗯……NB！
     * let i be the beginning of the substring , j be the end. i<=j
     * dp[i][j] = true only if dp[i+1][j-1] = true and String[i] == String[j]
     * otherwise it's false.
     Initialization:
        when i=j, all are ture;
        then when i+1=j, check neighbor chars to see if they are same
        
     Iteration along the diagnose
     */

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        //Init
        // i == j
        for (int i=0; i<s.length(); i++){
            dp[i][i] = true;
        }
        //i + 1 == j
        for (int i=0; i<s.length()-1; i++){
            if (s.charAt(i) == s.charAt(i+1))  dp[i][i+1] = true;
        }
        // iterative along the diagnose
        
        for (int offset = 2; offset < s.length(); offset++){
			for (int row = 0; row < s.length(); row++) {
				if (row + offset  < s.length() && dp[row + 1][row + offset - 1] // be careful to check row+offset is valid
						&& s.charAt(row) == s.charAt(row + offset)) {
					dp[row][row + offset] = true;
				}
			}
        }
        int[] index = new int[2];
        int maxLen = 0;
        for (int i=0; i<s.length(); i++){
            for (int j=s.length()-1; j>=i; j--){
                if (dp[i][j] && j-i+1 > maxLen) {
                    index[0] = i;
                    index[1] = j;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(index[0], index[1]+1);
    }
	/**
	 * Correct but TML. It's O(3^n)
	 * Using dp[i,j] to save the start, end point, reduce to O(N^2)
	 * but String[][] cost too many spaces. could use boolean instead
	 */
	
//	String[][] dp = new String[1001][1001];
//	
//    public String longestPalindrome(String s) {
//        return help(s,0,s.length()-1);
//    }
//    
//    private String help(String s, int start, int end){
//    	if (dp[start][end] != null) return dp[start][end];
//        if (start == end) {
//        	dp[start][end] = s.charAt(start)+"";
//        	return s.charAt(start)+""; // actually can get rid of this
//        }
//        if (start+1 == end) {
//        	if(s.charAt(start) == s.charAt(end)){
//        		return dp[start][end] = s.substring(start, end+1);
//        	} else {
//        		return dp[start][end] = "";
//        	}
//        }
//        if (isPalindromic(s, start, end)){ // s length > 1
//            return dp[start][end] = s.substring(start, end+1);
//        }
//        
//        String s1 = help(s, start+1, end);
//        String s2 = help(s, start+1, end-1);
//        String s3 = help(s, start, end-1);
//        if (s1.length() > s2.length()) {
//            if (s1.length() > s3.length()) {
//                return dp[start][end] =s1;
//            } else {
//                return dp[start][end] =s3;
//            }
//        } else {
//            if (s2.length() > s3.length()) {
//                return dp[start][end] =s2;
//            } else {
//                return dp[start][end] =s3;
//            }
//        }
//    }
//    
//    private boolean isPalindromic(String s, int start, int end){
//        for (int i=0; i<=(end-start+1)/2; i++){
//            if(s.charAt(start+i) != s.charAt(end-i)) return false;
//        }
//        return true;
//    }
}
