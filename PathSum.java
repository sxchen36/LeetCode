package Leetcode;
import java.util.Stack;

/**
 * Deserve to re-do, thinking if we wanna the feedback when we reach the leaves, maybe we can 
 * use stacks to store the things as recursion do in memory
 * @author Angel_Death
 *
 */

public class PathSum {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  /* Wrong! Shouldn't use DFS, cus for one root, there could be several possible result,
	   * can't return as a singel value
	   * But I guess hashtable is good*/
//    public boolean hasPathSum(TreeNode root, int sum) {
//        HashMap<TreeNode , Integer > map = new HashMap<TreeNode , Integer >();
//        return
//    }
//    
//    private int helpSum(TreeNode root, HashMap<TreeNode, Integer> map){
//        if (root == null) return 0;
//        
//        if (map.containsValue(root)) return map.get(root);
//        
//        return root.val + helpSum(root.left, map) + helpSum(root.right, map);
//    }
	  
	  /* recursion end when reach leave, the program will end by creating a stack layer for each node, O(N)
	   * thus, no need to calculate according to return, so return boolean instead of int
	   * if it's equal to sum number and it's the leave, return it
	   * no need for map, cuz we'll pass preSum as a para*/
	  

//	    public boolean hasPathSum(TreeNode root, int sum) {
//	        if (root == null) return false;
//	        return helpSum(root, 0, sum);
//	    }
//	    
//	    private boolean helpSum(TreeNode root, int preSum, int sum){
//	        if (root == null) return false;
//	        if (root.right == null && root.left == null && root.val + preSum == sum) {
//	            return true;
//	        } else {
//	                boolean left = helpSum(root.left, root.val + preSum, sum);
//	                boolean right = helpSum(root.right, root.val + preSum, sum);
//	                return left || right;
//	            
//	        }
//	    }
	  
	/* Same idea (DFS). but no recursion
	 * Improved by using two stacks, to avoid keep useless stack layers in memory --  those stacks only waiting to be return actually.
	* Compared with last solution, this one avoid by release the stack layers(pop) and only 
	* store those we gonna use in the future */
	/* stack keep track of previous value, only values for the previous level, depends on the depth of .left*/
	    
	  public boolean hasPathSum(TreeNode root, int sum) {
	        if (root == null) return false;
	        Stack<TreeNode> sta = new Stack<TreeNode>();
	        Stack<Integer> staVal = new Stack<Integer>();
	        TreeNode cur = root; 
	        int curVal = 0;
	        // stack keep track of previous value, only values for the previous level, depends on the depth of .left
	        while (!sta.empty() || cur != null) {
	            if (cur != null) {
	                sta.push(cur);
	                curVal += cur.val;
	                staVal.push(curVal);
	                cur = cur.left;
	            } else { // cur == null, its parent is a leaf
	                cur = sta.pop();
	                curVal = staVal.pop();
	                if (curVal == sum && cur.right == null && cur.left == null) return true;
	                cur = cur.right;
	            }
	        }
	        return false;
	    }
	    
	  
}
