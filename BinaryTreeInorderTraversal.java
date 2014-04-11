package Leetcode;
import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreeInorderTraversal {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	/*一次通过的recursion solution*/
//    public ArrayList<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        inorderHelper(res, root);
//        return res;
//    }
//    
//    private void inorderHelper(ArrayList<Integer> res, TreeNode root) {
//        if(root == null) return;
//        
//        inorderHelper(res, root.left);
//        res.add(root.val);
//        inorderHelper(res, root.right);
//    }
	
	/* iteration solution*/
	  /**
	   * Because we want to search left subtree, we need to keep record of the current node
	   * because all the left subtree node should be pior to current node, we use stack
	   * when we reach node.left == null, we add current node, then go through right subtree by 
	   * pushing right child into the stack.
	   */
    public ArrayList<Integer> inorderTraversal(TreeNode root){

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode pointer = stack.pop();
            while (pointer.left != null){
                TreeNode left= pointer.left;
                stack.push(pointer);
                pointer.left = null;
                pointer = left;
            }
            res.add(pointer.val);
            if (pointer.right != null) {
                stack.push(pointer.right);
                pointer.right = null;
            }
        }
        return res;
    }
}
