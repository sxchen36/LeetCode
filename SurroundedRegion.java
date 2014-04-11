package Leetcode;
import java.util.LinkedList;

import CC150.Node;


public class SurroundedRegion {
    class Node {
        int row;
        int col;
        public Node(int r, int c){
            row = r;
            col = c;
        }
    }
    
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if(row == 0 || col == 0) return;
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i == 0 || j == 0 || i == row-1 || j == col-1) {
                    bfs(board, i, 0);
                    //dfs(board, i, 0);
                }
            }
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(char[][] board, int row, int col){
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(row, col));
        while (queue.size() != 0){
            Node cur = queue.poll();
            if (valid(cur, board.length, board[0].length) && board[row][col] == 'O') {
                board[row][col] = 'V';
                queue.add(new Node(row+1,col));
                queue.add(new Node(row-1,col));
                queue.add(new Node(row,col+1));
                queue.add(new Node(row,col-1));
            }
        }
    }
    
    private boolean valid(Node n, int rlen, int clen){
        if(n.row < rlen && n.row >= 0 && n.col < clen && n.col >= 0) return true;
        return false;
    }
}
