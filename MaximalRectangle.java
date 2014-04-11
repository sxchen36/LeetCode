package Leetcode;
/*
 * Check row by row, for each row i, record all the uninterrupted 1's location
 * compare with row i-1, only keep overlaps location...
 * doesn't work
 * 
 * map[i][j] represent the largest rectangle containing all ones
 *  with the char[i][j] as the bottom-right spot.
 *  O(M+N)*MN = O(N^3)
 * if V(i,j)==0, map[i][j] = 0
 * if V(i,j)==1, depends on V(i-1,j-1) V(i,j-1) V(i-1,j)
 * 		if either of three == 0: map[i][j] = 0
 *      if all of them == 1: 
 *      	- count numbers of 1 in same column, c1 = min(map[i-1][j-1]+1, count(column) as height
 *      	- count numbers of 1 in same row,  c2 = min(map[i-1][j-1]+1, count(row))
 *      	- map[i][j] = Max(c1*c2, map[i-1][j]+1, map[i][j-1]+1)
 *
 *
 * DIdn't write code but it is too complicated and its O(N^3)
 */
/**
 * AC: map[i][j] represents the continuous 1s after [i][j]
 * go through the whole M*N
 * scan again, for each map[i][j],check all elements in same column(up/down), if (map[x][j]> map[i][j]) has a larger rect, then we + map[i][j], or just break
 * Update: be careful, you shouldn't change map[i][j] when calculate the max
 */
public class MaximalRectangle {
	
	public static final void main(String[] args){
		MaximalRectangle t = new MaximalRectangle();
		char[][] matrix = {{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
		System.out.println(t.maximalRectangle(matrix));
	}
	
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] map = new int[rows][cols];
        // set map[i][j] as the number of continuous 1 starting from index(i,j)
        for (int i=0; i<rows; i++){
            for (int j=cols-1; j>=0; j--){
                if (matrix[i][j] == '1'){
                    if (j == cols-1){
                        map[i][j] = 1;
                    } else {
                        map[i][j] = map[i][j+1]+1;
                    }
                } else {
                    map[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (map[i][j] != 0){
                    int k = 1;
                    int tmp = map[i][j];
                    int increase = map[i][j];
                    while (i-k >= 0 && map[i-k][j] >= map[i][j]){
                        tmp += increase;
                        k++;
                    }
                    k = 1;
                    while(i+k < rows && map[i+k][j] >= map[i][j]){
                        tmp += increase;
                        k++;
                    }
                    max = Math.max(tmp,max);
                } 

            }
        }
        return max;
    }
}
