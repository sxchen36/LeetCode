package Leetcode;

public class MInimumPathSum {
	/*
	 * 1st thinking:
	 * 1. Top-down, the min sum to reach the ending point should be either
	 * - min sum to reach its left point + leftpoint number
	 * or
	 * - min sum to reach its upper point + upper point number
	 * 
	 * choose the smaller one
	 * 
	 * Should not use recuresion. Use bottom up!! (don't write code but it's easy)
	 * */
	public static final void main(String[] args){
		MInimumPathSum t= new MInimumPathSum();
//		int[][] grid = {{5,0,1,1,2,1,0,1,3,6,3,0,7,3,3,3,1},{1,4,1,8,5,5,5,6,8,7,0,4,3,9,9,6,0},{2,8,3,3,1,6,1,4,9,0,9,2,3,3,3,8,4},{3,5,1,9,3,0,8,3,4,3,4,6,9,6,8,9,9},{3,0,7,4,6,6,4,6,8,8,9,3,8,3,9,3,4},{8,8,6,8,3,3,1,7,9,3,3,9,2,4,3,5,1},{7,1,0,4,7,8,4,6,4,2,1,3,7,8,3,5,4},{3,0,9,6,7,8,9,2,0,4,6,3,9,7,2,0,7},{8,0,8,2,6,4,4,0,9,3,8,4,0,4,7,0,4},{3,7,4,5,9,4,9,7,9,8,7,4,0,4,2,0,4},{5,9,0,1,9,1,5,9,5,5,3,4,6,9,8,5,6},{5,7,2,4,4,4,2,1,8,4,8,0,5,4,7,4,7},{9,5,8,6,4,4,3,9,8,1,1,8,7,7,3,6,9},{7,2,3,1,6,3,6,6,6,3,2,3,9,9,4,4,8}};
		int[][] grid = {{3,5,4},{9,1,1},{1,2,3}};
		System.out.println(t.minPathSum(grid));
	}
	
	
//    public int minPathSum(int[][] grid) {
//        return minPathDivider(grid, grid.length-1, grid[0].length-1);
//    }
//    
//    private int minPathDivider(int[][] grid, int i, int j) {
//        if (i == 0 && j == 0) return grid[i][j]; // actually it's included in following assumption
//        int sumToHere = 0;
//        if (i == 0) {
//            for (int k = 0; k <= j; k++){
//                sumToHere += grid[i][k];
//            }
//            return sumToHere;
//        }
//        if (j == 0) {
//            for (int k = 0; k <= i; k++){
//                sumToHere += grid[k][j];
//            }
//            return sumToHere;
//        }
//        
//        int sumbefore = Math.min(minPathDivider(grid, i-1, j) + grid[i-1][j], minPathDivider(grid, i, j-1) + grid[i][j-1]); 
//        return sumbefore + grid[i][j];
//    }
	
	/** 
	 * Improve: Given the dynamic programming formula f[i][j]=min(f[i-1][j],f[i][j-1])+grid[i][j]:
		Assume that you are populating the table row by row, the current value (f[i][j]) will be used immediately in the calculation
 		of f[i][j+1], so there is no need to store all the previous column values.*/
	
    public int minPathSum(int[][] grid) {
        // must to create a new variable to calculate
    
        int[] rows = new int[grid[0].length+1];
        for (int i=0; i<rows.length; i++){
            rows[i] = Integer.MAX_VALUE; // 只存一行的值
        }
        rows[1] = 0; 
        for (int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                rows[j+1] = Math.min(rows[j+1],rows[j]) + grid[i][j];//rows[j+1]存的还是上一行j+1的值呢！！！
            }
        }
        return rows[rows.length-1];
    }
}
