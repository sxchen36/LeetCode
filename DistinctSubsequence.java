package Leetcode;

public class DistinctSubsequence {
    /*Wrong: Doesn't consider 不连续的subsequence: "ddd", "dd" should be 3
     * Use map[i][j] to record the number of distinct subsequences of T[0...i] in S[0...j]
     * Initialize:  map[0][0] depends on whether T(0) == S(0)
     *              map[0][j] number of first char of T in S[0...j]; O(S.length)
     *              map[i][0] set to 0;
     * map[i][j] = 0 if T[i] != S[j]
     * if T(i) = S(j), map[i][j] = map[i-1][j-1] + 
     */
	
	/**
	 * Update: 之前其实差了两点：
	 * 1.T[i] != S[j] map[i][j] = map[i][j-1] 即同样长度的T在之前的S里已经存在了多少次
	 * 2.T[i] == S[j]  map[i][j] = map[i-1][j-1] + map[i][j-1]
	 */
    public int numDistinct(String S, String T) {
        if (S.equals("") && T.equals("")) return 1;
        if (S.equals("") || T.equals("")) return 0;
        
        int[][] map = new int[T.length()][S.length()];
        // Initialize
        map[0][0] = (S.charAt(0) == T.charAt(0)) ? 1 : 0;
        for(int j=1; j<S.length(); j++){
            map[0][j] = map[0][j-1];
            if(S.charAt(j) == T.charAt(0)) map[0][j]++;
        }
        
        for(int i=1; i<T.length(); i++){
            for(int j=i; j<S.length(); j++){
                if(S.charAt(j) == T.charAt(i)) {
                    map[i][j] = map[i-1][j-1] + map[i][j-1]; // Takes me a long time to figure it out
                } else {
                    map[i][j] = map[i][j-1];
                }
            }
        }
        
        return map[T.length()-1][S.length()-1];
    }
}
