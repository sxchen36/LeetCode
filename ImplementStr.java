package Leetcode;

public class ImplementStr {
	/* Doesn't work, Just leave it here because I've spend too much time on this... move on*/
    public String strStr(String haystack, String needle) {
        int[] T = KMPinit(needle);
        int hp = 0;
        int np = 0; //length of partial match -- exactly the number because is zero-based and when it's unequal it's the length
        while(hp + np < haystack.length()){
            if(haystack.charAt(hp) == needle.charAt(np)){
                if (np == needle.length()-1) return haystack.substring(hp);
                np++;
            } else {
                hp = hp + needle.length() - T[np-1]; // the index in T should be length -1
                np = T[np-1];
            }
        }
        return haystack;
    }
    
    /*KMP initialize
        needle.length()>=2
    */
    private int[] KMPinit(String needle){
        int[] T = new int[needle.length()];
        char[] W = needle.toCharArray();
        T[0] = 0;
        int pos = 1; // current position we are computing in T
        int cur = 0; // zero-based index in W of the next candidate substring
        while (pos<needle.length()) {
            if(W[cur] == W[pos]){ // a little bit different from wiki, cuz no -1
                cur++;
                T[pos] = cur; // longest proper prefix
                pos++;
            } else if (cur > 0){
                cur = T[cur];// call back to exam shorter longest proper prefix 
            } else {        // cur alreasy equals 0 here;
                T[pos] = 0; 
                pos++;
            }
        }
        return T;
    }
	
	
	/*Wrong Logic!!! 
	 * Can't deal with "mississippi", "issip". will return null cuz it miss the right beginning of i when check for ississ
	 * SHould be fine if we check the hp one by one be defining a var 'start', but TLE when meet "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa...."
	 * 
	 * */
//    public String strStr(String haystack, String needle) {
//        if (needle == "") return haystack;
//        if (haystack == "") return null;
//        
//        
//        int hp = 0;
//        int np = 0;
//        while (hp < haystack.length() && np < needle.length()) {
//            if (haystack.charAt(hp) == needle.charAt(np)) {
//                if (np == needle.length()-1) return haystack.substring(hp-(needle.length()-1));
//                hp++;
//                np++;
//            } else {
//                hp++;
//                np= 0;
//            }
//        }
//        
//        if (np == needle.length() && hp <= haystack.length()) return haystack.substring(hp-(needle.length()-1));
//        return null;
//        
//    }
    /*Wrong!    
    No better the former one
     * How about dynamic
    boolean dp[m][n] represent  index m in haystack ?= index n in needle
    if(dp[m-1][n-1])  and haystack.char(m) == needle.char(n) then dp[m][n] = true        else = false
    notice m>=n, only half of the matrix
    check is there is a true when n == needle.length
    
    Base: dp[m][0] initialize
    */
//    public String strStr(String haystack, String needle) {
//        
//        boolean[][] dp = new boolean[haystack.length()][needle.length()];
//        // consider "","" and so on later
//        
//        for (int i = 0; i< haystack.length(); i++){
//            if (haystack.charAt(i) == needle.charAt(0)) dp[i][0] = true;
//        }
//        
//        for (int m=0; m< haystack.length;){
//            for (int n=0; n<=m;) {
//                if (dp[m][n]){
//                    m = m+1;
//                    n = n+1;
//                }
//            }
//        }
//        
//        
//    }
}
