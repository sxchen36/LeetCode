package Leetcode;
import java.util.LinkedList;

import CC150.Node;

/* 只有接着边的O才不会变X
 * 如果用DFS的话，要用stack做iteration
 * 小总结： iteration的话，DFS用stack BFS用queue
 * 		  recursion的话， DFS直接挨个调用，BFS则用list一层一层存*/

/*第二次做： 思路是对的。但是纯用DFS的recursion stackoverflow了*/
public class SurroundedRegion {
	   class Node {
	        int row;
	        int col;
	        public Node(int r, int c){
	            row = r;
	            col = c;
	        }
	    }
	   
	   
	   public final static void main(String[] args){
		   SurroundedRegion t = new SurroundedRegion();
		   char[][] b = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		   t.solve(b);
	   }
	   
	    
	    public void solve(char[][] board) {
	        if(board.length == 0 || board[0].length == 0) return;
	        int row = board.length;
	        int col = board[0].length;
	        
	        for (int i=0; i<row; i++) {
	            for (int j=0; j<col; j++) {
	                if (i == 0 || j == 0 || i == row-1 || j == col-1) {
	                    bfs(board, i, j);
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
	    
	    private void bfs(char[][] board, int r, int c){
	        LinkedList<Node> queue = new LinkedList<Node>();
	        queue.add(new Node(r, c));
	        while (queue.size() != 0){
	            Node cur = queue.poll();
	            if (valid(cur, board.length, board[0].length) && board[cur.row][cur.col] == 'O') {
	            	int row = cur.row;
	            	int col = cur.col;
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
