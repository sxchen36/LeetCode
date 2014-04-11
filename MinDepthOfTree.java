package Leetcode;
import java.util.LinkedList;


public class MinDepthOfTree {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    /*Accepted: BFS find the nearest leaf  O(N)
                DFS find that leaf O(N)*/
//  public int minDepth(TreeNode root) {
//      if(root == null) return 0;
//      /*BFS find leaf*/
//      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//      queue.addLast(root);
//      TreeNode resLeaf = null;
//      while(queue.size() != 0){
//          TreeNode cur = queue.removeFirst();
//          if (cur.right == null && cur.left == null) {
//              resLeaf = cur;
//              break;
//          } else {
//              if (cur.left != null) queue.addLast(cur.left);
//              if (cur.right != null) queue.addLast(cur.right);
//          }
//      }
//      return dfs(resLeaf, root);
//  }
//  
//  int dfs(TreeNode aim, TreeNode root){
//      if (root == aim) return 1;
//      if (root == null) return -1;
//      
//      int left = dfs(aim, root.left);
//      int right = dfs(aim, root.right);
//      if (left < 0 && right < 0) return -1;
//      int result = 1 + ((left > 0) ? left:right);
//      return (left > 0) ? left:right;
//  }
	  
	   /**
	    * Simpler:!DFS to get the two depths of the subtree directly and return min*/
	    public int minDepth(TreeNode root) {
	       if (root == null) return 0;
	       
	       int i = minDepth(root.left);
	       int j = minDepth(root.right);
	       if (i == 0 || j == 0) return 1+Math.max(i,j);
	       return Math.min(i,j)+1;
	    }
}
