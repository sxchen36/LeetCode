package Leetcode;

public class LongestPalia {
	
	public static final void main(String[] args){
		LongestPalia t = new LongestPalia();
		System.out.println(t.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	
	/**
	 * Correct but TML. It's O(3^n)
	 * Using dp[i,j] to save the start, end point, reduce to O(N^2)
	 * but String[][] cost too many spaces. could use boolean instead
	 */
	
	String[][] dp = new String[1001][1001];
	
    public String longestPalindrome(String s) {
        return help(s,0,s.length()-1);
    }
    
    private String help(String s, int start, int end){
    	if (dp[start][end] != null) return dp[start][end];
        if (start == end) {
        	dp[start][end] = s.charAt(start)+"";
        	return s.charAt(start)+""; // actually can get rid of this
        }
        if (start+1 == end) {
        	if(s.charAt(start) == s.charAt(end)){
        		return dp[start][end] = s.substring(start, end+1);
        	} else {
        		return dp[start][end] = "";
        	}
        }
        if (isPalindromic(s, start, end)){ // s length > 1
            return dp[start][end] = s.substring(start, end+1);
        }
        
        String s1 = help(s, start+1, end);
        String s2 = help(s, start+1, end-1);
        String s3 = help(s, start, end-1);
        if (s1.length() > s2.length()) {
            if (s1.length() > s3.length()) {
                return dp[start][end] =s1;
            } else {
                return dp[start][end] =s3;
            }
        } else {
            if (s2.length() > s3.length()) {
                return dp[start][end] =s2;
            } else {
                return dp[start][end] =s3;
            }
        }
    }
    
    private boolean isPalindromic(String s, int start, int end){
        for (int i=0; i<=(end-start+1)/2; i++){
            if(s.charAt(start+i) != s.charAt(end-i)) return false;
        }
        return true;
    }
	
	/**
	 * Try O(N^2)
	 */
}
