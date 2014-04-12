package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class UniqueBSTs2 {
	public static final void main (String[] args) {
		UniqueBSTs2 t= new UniqueBSTs2();
		t.generateTrees(3);
	}
	
	 /*
	How to implement BFS???
	for DFS, we choose each num in the range as root, then get arraylist l for numbers smaller than it and arraylist r for numbers larger than it, add l.element + n + r.element for each choice to the res list and return the arraylist 
	Base: start>end then return null
	
	Notice the reference variable! for each different tree you need to new a new root!!
	 */
	
    public ArrayList<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    
    private ArrayList<TreeNode> helper(int start, int end) {
        HashSet<TreeNode> res = new HashSet<TreeNode>();
        if (start > end){
            res.add(null);
            return new ArrayList<TreeNode>(res);
        } 
        for (int num = start; num <= end; num++){ // choose each num in range as root
            ArrayList<TreeNode> left = helper(start, num-1);
            ArrayList<TreeNode> right = helper(num+1, end);
                for (TreeNode l: left) {
                    for (TreeNode r : right){
                        TreeNode root = new TreeNode(num);
                        root.left = l; // can't do this because it's reference, you will change the ,left and .right all the time and only get the last change. Thus you have to new root for every possibility!!!
                        root.right = r;
                        res.add(root);
                    }
                }

        }
        return new ArrayList<TreeNode>(res);
    }
}
