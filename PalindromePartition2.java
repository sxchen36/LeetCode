package Leetcode;

public class PalindromePartition2 {
    /*
     * map[i] represents minimum cuts needed until index i
     * from index 0, each time add a new char in index i, it will:
     *  - if is a palindrome start from k end with index i-1, check whether V[i] == V[k-1] (if "aaaaaa"??)
     *      - yes: map[i] = map[i-1]
     *      - no: map[i] = map[i-1] + 1, next palindrome starts from i (or i+1)?
     *  - if no palindrome end with index, check whether V[i] forms a palindrome start from palindrome start???
     * 
     * Don't think it will work...
     */
	/*
	 * map[i][j] keep whether it is a palindrome from index i to index j (i<=j)
	 * 	- if V[i] == V[j] map[i][j] = map[i-1][j-1] // means i>=1 j>=1
	 * 	- if V[i] != V[j] map[i][j] = false;
	 * 
	 * check map[][] by line from end, the first true it meet will be the longest palindrom for this i [i,j]
	 * then move to the j+1 line
	 * Until: j+1 >= map[0].length; 
	 * 
	 * Wrong reason: I think the map[][] could not be wrong, but the logic of choosing the min cut is not correct for "ababbbabbaba"
	 * 				because it may not be optimal starts the longest palindrome from index 0
	 * Update: it should be another DP. we try to cut after i, and count Cut(start,i)+Cut(i+1,end)+1 choose min
	 * Base: if map[x][y] is a palidrome, return 0;
	 * 
	 * Wrong reason: TLE O(n^3). but the algorithm is right
	 * Update: compute cut(start,end) only when the rest of the part it a palindrome!!
	 * 	- you have computed cut[i][j-1] now is computing cut[i][j], the new added letter may generate new palindrome
	 * 	- so compute cut[i][mid] only if cut[mid+1][j] is a palindrome
	 *  - because i never change, we can always starts from i=0, thus it's one-dimension to j's change
	 *  
	 * Wrong reason: still TLE O(n^2) should use DP for cut instead of just recursion
	 * 
	 * ACCEPTED!!!
	 * 
	 */
	public static final void main(String[] args){
		PalindromePartition2 t = new PalindromePartition2();
		System.out.println(t.minCut("dde"));
		System.out.println();
	}
	
	
    public int minCut(String s) {
        int n = s.length();

        boolean[][] map = new boolean[n][n];
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j>= i; j--){
                char ic = s.charAt(i);
                char jc = s.charAt(j);
                if (i == j){
                    map[i][j] = true;
                } else if (i + 1 == j) {
                    if(ic == jc) {
                        map[i][j] =true;
                    }
                } else {
                	if (ic == jc) {
                        map[i][j] = map[i+1][j-1]; //what if i = s.length()-1 or j = 0?  i=s.length() could be skip cuz there only is one time, and j = 0 when only i = 0;
                	}
                }
            }
        }
        
        /*Wrong1*/
//        /*Check how many cut needed before the current index*/
//        int count = 0;
//        for (int i=0; i<s.length();){
//            for(int j=s.length()-1; j>=i; j--){
//                if (map[i][j]) {
//                    if (i!=0) { 
//                        count++;
//                    }
//                        i = j+1;
//                        break; // this line is finished, move to next possible palindrome.
//                }
//            }
//        }
    	if (map[0][n-1]) return 0;
    	int[] cut = new int[n];
        return cutHelper(cut, map);
    }
    
    
    private int cutHelper(int[] cut, boolean[][] map){
    	int n = cut.length;
    	cut[0] = 0;
    	for (int i=1; i<n; i++){
    		cut[i] = n-1;
    	}
    	for (int j=1; j<n; j++){
        	for (int k = 0; k<=j; k++){
        		if (map[k][j]){       
        			if (k == 0) {
        				cut[j] = 0;
        			} else {
        				cut[j] = Math.min(cut[k-1] + 1, cut[j]);
        			}
        		}
        		
        	}
    	}

    	return cut[n-1];
    }
    
    
    /* 第二次做：Totally Wrong. It won't do better than brute force*/
//    public int minCut(String s) {
//        for (int i=0; i<s.length(); i++) {
//            List<Integer> indexs = new List<Integer>();
//            for (int j=i+1; j<s.length(); j++) {
//                if (isPalindrome(i,j,s)) {
//                    indexs.add(j);
//                }
//            }
//            map.put(i, indexs);
//        }
//        
//        int min = s.length();
//        for (Integer one : map.get(0)) {
//            int index = 0;
//            int count = 0;
//            while (index != s.length()-1) {
//                List<Integer> list = map.get(index);
//                for ()
//            }
//        }
//    }
//
//    private boolean isPalindrome(int start, int end, String s) {
//        if (start == end) return true;
//        
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) return false;
//            start++;
//            end--;
//        }
//        return true;
//        
//    }
}
