package Leetcode;

public class RotateImage {
	/*值得再多写几遍，多练几种不同的解法 leetcode上有很多解法嗯
	 * 这个是我写的，也是优势解法其中之一。注意第二个i loop, i<n-offset-1嗯！*/
    public void rotate(int[][] matrix) {
        int offset = 0;
        int n = matrix.length;
        for (int r=0; r<n/2 ; r++) {
            int[] tmp = new int[n];
            for (int i=offset; i<n-offset; i++) {
                tmp[i] = matrix[r][i];
            }
            /*Important!!! i< n-offset-1  because for each line, the last will be replaced by the first from the other side
            thus for each line there are only n-offset - 1 need to be check*/
            for (int i = offset; i< n-offset-1; i++){
                matrix[r][i] = matrix[n-1 - i][r];
                matrix[n-1 - i][r] = matrix[n-1 - r][n-1 - i];
                matrix[n-1 - r][n-1 - i] = matrix[i][n-1 - r];
                matrix[i][n-1 - r] = tmp[i];
            }
            offset++;
        }
    }
}
