package Leetcode;
import java.util.ArrayList;


public class NQueens {
    /*
    Use col[i] to store the row index of the Q for each column
    For column i, check all previous col[x] to see if that row is occupied, if not, put Q here and recurse to next column
    don't forget to reset recursion when it returns back
    Ending point: i = length-1 if it's a result put into ArrayList, return
    */
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] rows = new int[n];
        NQueensHelper(res, rows, 0);
        return res;
    }
    
    private void NQueensHelper(ArrayList<String[]> res, int[] rows, int row){
        if (row == rows.length) {
            String[] strs = new String[rows.length];
            for (int r=0; r<rows.length; r++){
                String str = "";
                int col = rows[r];
                for (int c=0; c<rows.length; c++){
                    if(c != col){
                        str += ".";
                    } else {
                        str += "Q";
                    }
                }
                strs[r] = str;
            }
            res.add(strs);
        } else {
            for (int col=0; col < rows.length; col++){
                if(isValid(rows, row, col)){
                    rows[row] = col;
                    NQueensHelper(res, rows, row+1);
                    // no need to reset cuz isValid only care columns < col
                }
            }
        }
    

    }
    
    
    private boolean isValid(int[] rows, int row, int col){
        for (int preRow=0; preRow<row; preRow++){
            int preCol = rows[preRow];
            if (col == preCol) return false;
            
            /* Check diagonals*/
            if (row - preRow == Math.abs(col - preCol)) return false;
        }
        return true;
    }
}
