package Leetcode;

public class SudokuSolution {
	
	public static final void main(String[] args){
		SudokuSolution t = new SudokuSolution();
		char[][] board = {{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}};
		//t.solveSudoku(board);
	}
	
	
	
//    public void solveSudoku(char[][] board) {
//        helper(board,0,0);
//    }
    // Wrong！！错了，如果传了row col做变量值，就别用for循环了，否则如果board[i][j]!='.'然后换了新行，j还从col开始，前边的就都遍历不着了
    // 所以要不就每次从j=0开始遍历，那还不如就直接不传row 和col了吧
//    private boolean helper (char[][] board, int row, int col){
//        for(int i=row; i<board.length; i++){
//            for (int j=col; j<board[0].length; j++){
//                if(board[i][j] == '.'){
//                    for (char k='1'; k<='9'; k++){ // <='9' !!!!!!
//                        if(valid(board, i, j, k)) {
//                            board[i][j] = k;
//                            boolean result = (j == board[0].length-1) ? helper(board, i+1, 0) : helper(board, i, j+1);
//                            if (result){
//                                return true;
//                            } else {
//                                board[i][j] = '.';//reset
//                            }
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    /*Validation method, 18 operations at most*/
//    private boolean valid(char[][] board, int r, int c, char num){
//        for (int j=0; j<board[0].length; j++){
//            if (board[r][j] == num) return false;
//        }
//        for (int i=0; i<board.length; i++){
//            if (board[i][c] == num) return false;
//        }
//        
//        for (int i=r/3*3; i<r/3*3+3; i++){
//            for (int j=c/3*3; j<c/3*3+3; j++){
//                if(board[i][j] == num) return false;
//            }
//        }
//        return true;
//    }
//    
//    
//    /*AC Brute force. check each board from 0,0  in each recursion.*/
//    public void solveSudoku(char[][] board) {
//        helper(board);
//    }
//    // board used to get the result immediately!
//    private boolean helper (char[][] board){
//        for(int i=0; i<board.length; i++){
//            for (int j=0; j<board[0].length; j++){
//                if(board[i][j] == '.'){
//                    for (char k='1'; k<='9'; k++){ // <='9' !!!!!!
//                        if(valid(board, i, j, k)) {
//                            board[i][j] = k;
//                            if (helper(board)){
//                                return true;
//                            } else {
//                                board[i][j] = '.';//reset
//                            }
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    /*Validation method, 18 operations at most*/
//    private boolean valid(char[][] board, int r, int c, char num){
//        for (int j=0; j<board[0].length; j++){
//            if (board[r][j] == num) return false;
//        }
//        for (int i=0; i<board.length; i++){
//            if (board[i][c] == num) return false;
//        }
//        
//        for (int i=r/3*3; i<r/3*3+3; i++){
//            for (int j=c/3*3; j<c/3*3+3; j++){
//                if(board[i][j] == num) return false;
//            }
//        }
//        return true;
//    }
    
	
	
    /*Backtracking
     * AC 是上边解法的优化。不用每次都从头找‘.’了，row和col标注出来的是开始扫描‘。’的起点*/
	 public void solveSudoku(char[][] board) {
	        helper(board, 0, 0);
	        
	    }
	    
	    private boolean helper(char[][] board, int row, int col) {
	        if (row == board.length) {
	            return true;
	        } else {
	            for (int i=row; i<board.length; i++) {
	                for (int j=0; j<board[0].length; j++) {
	                    if (i == row && j < col) continue;
	                    if (board[i][j] == '.') {
	                        for (int ni=1; ni<10; ni++) {
	                            char n = (char)('0'+ni);
	                            if (valid(board, i, j, n)) {
	                                board[i][j] = n;
	                                int nrow = 0;
	                                int ncol = 0;
	                                if (j == board[0].length-1){
	                                    nrow = i+1;
	                                    ncol = 0;
	                                } else {
	                                    ncol = j+1;
	                                }
	                                if (helper(board, nrow, ncol)) {
	                                    return true;
	                                }
	                            }
	                        }
	                        board[i][j] = '.';
	                        return false;
	                    }
	                }
	            }
	            return true;
	        }
	    }
	    
	    private boolean valid(char[][] board, int row, int col, char n) {
	        for (int i=0; i<board.length; i++) {
	            if (board[i][col] == n) return false;
	            if (board[row][i] == n) return false;
	        }
	        
	        int offset = board.length/3;
	        for (int i=row/offset*offset; i<row/offset*offset+offset; i++) {
	            for (int j=col/offset*offset; j<col/offset*offset+offset; j++) {
	                if (i == row && j == col) {
	                    continue;
	                } else {
	                    if (board[i][j] == n) return false;
	                }
	            }
	        }
	        return true;
	    }
}
