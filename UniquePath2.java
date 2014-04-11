package Leetcode;

public class UniquePath2 {
	/*Similar Algorithm like 1, use only O(N) space*/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows =  obstacleGrid.length;
        int cols = obstacleGrid[0].length;
       
       if (obstacleGrid[0][0] == 1) return 0;
       
        int[] row = new int[cols];
        
        // initialize first row
        boolean check = true;
        for (int i=0; i<cols; i++){
            if (obstacleGrid[0][i] == 0 && check){
                row[i] = 1;
            } else {
                row[i] = 0;
                check = false;
            }
        }
        for (int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                if (obstacleGrid[i][j] == 0){
                    if (j>0) {
                        row[j] = row[j-1] + row[j]; // first column always equals the initial value unless there is obstracle
                    }
                } else {
                    row[j] = 0;
                }
            }
        }
        return row[cols-1];
    }
}
