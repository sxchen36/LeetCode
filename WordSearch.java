package Leetcode;

public class WordSearch {
    /*AC
     * Use the thinking of Tree. Each letter in the board have several neighbor -- not easy to identify whether there is a circle
    Use the thinking of matrix, which could be boolean to indicate whether a cell has been used or not
    recursion because the result can be decided only in the end of the path; need row col start point for the target word
    DFS is better cuz it needs to reach the end of the path anyway
  */
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean res = false;
        // We must check each element, thus this iteration could save us from a lot of recursion
        for (int i=0; i< board.length; i++){
            for (int j=0; j<board[0].length; j++){
                res |= helper(board, used, i, j, 0, word);
                if (res) break;
            }
        }
        return res;
    }
    
    // return whether it is a path containning substring from sp to end of word
    private boolean helper(char[][] board, boolean[][] used, int row, int col, int sp, String word){
        if(sp == word.length()) return true; // already contains the whole word in the previous layer
        if(row >= board.length || row < 0 || col >= board[0].length || col <0 || used[row][col]) return false; // if doesn't contain, and this cell is used, no path possible through this way
        
        if(board[row][col] == word.charAt(sp)) {
            used[row][col] = true;
            boolean res =  helper(board, used, row+1, col, sp+1, word) || helper(board, used, row, col+1, sp+1, word) || helper(board, used, row-1, col, sp+1, word) || helper(board, used, row, col-1, sp+1, word);
            if (!res) used[row][col] = false;
            return res;
        } else {
            return false;
        }
    }
}
