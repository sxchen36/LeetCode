package Leetcode;
import java.util.ArrayList;
import java.util.Stack;


public class PathSum2 {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  /* Wrong. My 1st attemp try to copy PathSum1 but failed
	   * because in 1 it will return boolean right after it get an answer
	   * but for this one, we need to keep search the whole tree
	   * It's not suitable*/
//	    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
//	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//	        Stack<TreeNode> sta = new Stack<TreeNode>();
//	        Stack<Integer> staVal = new Stack<Integer>();
//	        Stack<ArrayList<Integer>> staList = new Stack<ArrayList<Integer>>();
//	   	 	ArrayList<Integer> curList = new ArrayList<Integer>();
//	        int curVal = 0;
//	        TreeNode cur = root;
//	        while (!sta.empty() || cur != null){
//	            if (cur != null){
//	                sta.push(cur);
//	                curVal += cur.val;
//	                staVal.push(curVal);
////	                staList.push(curList);
//	                 if (staList.empty()){ // not only in the first round could the staList be empty; when meet the last right node
//	                	 curList.add(cur.val);
//	                	 staList.push(curList);
//	                 } else {
//	                	 curList = new ArrayList<Integer>(staList.peek());
//	                	 curList.add(cur.val);
//	                	 staList.push(curList);
//	                 }
//	                cur = cur.left;
//	            } else {
//	                cur = sta.pop();
//	                curVal = staVal.pop(); // its parent might be leaf, or might not if has the other child
//	                curList = staList.pop();
//	                if (curVal == sum && cur.right == null && cur.left == null) {
//	                    result.add(curList);
//	                    if(sta.empty()) break;
//	                    if (cur == sta.peek().right) {
//	                        cur = sta.pop();
//	                        cur.right = null;
//	                    } else {
//	                        cur = sta.pop();
//	                        cur.left = null;
//	                        cur = cur.right;
//	                    }
//	                    curVal = staVal.pop();
//	                    curList = staList.pop();
//	                } else {
//	                    cur = cur.right; // keep track of parent according to stack
//	                }
//	            }
//	        }
//	        return result;
//	        
//	    }
	  
	  
	  /**
	   * DFS recursion solution should be better and easier
	   * Don't forget to reset the prePath
	   */
	    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        helper(res,new ArrayList<Integer>(), sum, root );
	        return res;
	    }
	    
	    void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> prePath, int sum, TreeNode root){
	        if (root == null) return;
	        
	        if (root.val == sum && root.left == null && root.right == null){ // Brilliant! use minus to calculate sum
	            prePath.add(root.val);
	            ArrayList<Integer> clone = new ArrayList<Integer>(prePath);
	            res.add(clone);
	            prePath.remove(prePath.size() -1);
	            return;
	        } 
	        
	        prePath.add(root.val);
	        helper(res, prePath, sum-root.val, root.left);
	        helper(res, prePath, sum-root.val, root.right);
	        prePath.remove(prePath.size()-1);
	    }
}
