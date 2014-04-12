package Leetcode;

public class Search2DMatrix {
	/* AC
	 * 1.end should be M*N-1
	 * 2. while loop, should be start<= end, if start < end then duplicate code to test whether start=end it's true
	 * 3. cuz start<= end, then end = mid-1 must, or dead-loop
	 * */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int start = 0;
        int end = matrix.length * matrix[0].length-1;
        while (start <= end) {
            int mid = (start + end)/2;
            int midV = matrix[mid/matrix[0].length][mid%matrix[0].length];
            if (midV == target) return true;
            if (midV > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
