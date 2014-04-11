package Leetcode;

public class NQueens2 {
    int count = 0;
    public int totalNQueens(int n) {
        int[] rows = new int[n];
            NQueensHelper(rows, 0);
        return count;
    }
    
    private void NQueensHelper(int[] rows, int row){
        if (row == rows.length){
            count++;
            return;
        }
        for (int c = 0; c < rows.length; c++){
            if (isValidPosition(rows, row, c)){
                rows[row] = c;
                NQueensHelper(rows, row+1);    
            }
        }
    }
    
    private boolean isValidPosition(int[] rows, int row, int col){
        for (int r=0; r<row; r++){
            if(rows[r] == col) return false;
            
            if(row - r == Math.abs(col - rows[r])) return false;
        }
        return true;
    }
}
