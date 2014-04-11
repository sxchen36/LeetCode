package Leetcode;

public class UniquePath {
	/*最基本的思路了， memory O(N^2)*/
//    public int uniquePaths(int m, int n) {
//        int[][] steps = new int[m][n];
//        for (int j=0; j<n; j++){
//            steps[0][j] = 1;
//        }
//        for (int i=0; i<m; i++){
//            steps[i][0] = 1;
//        }
//        for (int i=0; i<m; i++){
//            for (int j=0; j<n; j++){
//                if(i!= 0 && j!=0) {
//                    steps[i][j] = steps[i-1][j] + steps[i][j-1]; 
//                }
//            }
//        }
//        return steps[m-1][n-1];
//    }
    
	/**
	 * 和之前的minimumPathSum同样思路。
	 * @param m
	 * @param n
	 * @return
	 */
    public int uniquePaths(int m, int n) {
        int size = (m>n) ? n:m;
        int count = (m>n) ? m:n;
        int[] steps = new int[size+1];
        steps[1] = 1;
        for (int i=0; i<count; i++){
            for (int j=1; j<size+1; j++) {
                steps[j] = steps[j-1] + steps[j];// old steps[j] is the number from upper level same column
            }
        }
        return steps[size];
    }
}
