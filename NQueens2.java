package Leetcode;

public class NQueens2 {
	
	public static void main(String[] args){
		NQueens2 q = new NQueens2();
		q.totalNQueens(2);
	}
	
    int limit, ans;
    
    public int totalNQueens(int n) {
        limit = (1<<n) - 1;
        ans = 0;
        dfs(0,0,0);
        return ans;
    }
    
    private void dfs(int h, int r, int l) {
        if (h == limit) {
            ans++;
            return;
        }
        
        int pos = limit&(~(h|r|l));
        while (pos!= 0) {
            int mask = pos&(-pos);
            pos -= mask;
            dfs(mask+h, (r+mask)<<1, (l+mask)>>1);
        }

    }
	
	
//    int count = 0;
//    public int totalNQueens(int n) {
//        int[] rows = new int[n];
//            NQueensHelper(rows, 0);
//        return count;
//    }
//    
//    private void NQueensHelper(int[] rows, int row){
//        if (row == rows.length){
//            count++;
//            return;
//        }
//        for (int c = 0; c < rows.length; c++){
//            if (isValidPosition(rows, row, c)){
//                rows[row] = c;
//                NQueensHelper(rows, row+1);    
//            }
//        }
//    }
//    
//    private boolean isValidPosition(int[] rows, int row, int col){
//        for (int r=0; r<row; r++){
//            if(rows[r] == col) return false;
//            
//            if(row - r == Math.abs(col - rows[r])) return false;
//        }
//        return true;
//    }
}
