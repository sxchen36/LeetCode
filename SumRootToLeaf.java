package Leetcode;
import java.util.ArrayList;
import java.util.LinkedList;



public class SumRootToLeaf {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
//    /*Use preorder-tranverse, each time back to the current root
//    trancate the last letter and ready for the other possible child*/
//	
//	/*Should use int from the beginning*/
//	
//    ArrayList<String> ss = new ArrayList<String>();
//    public int sumNumbers(TreeNode root) {
//        if (root == null) return 0;
//        inorderTranverse(root, "");
//        int sum = 0;
//        for (String s: ss){
//            sum += Long.valueOf(s);
//        }
//        return sum;
//    }
//    private void inorderTranverse(TreeNode root, String s){
//        if (root.left == null && root.right == null) {
//            ss.add(s+root.val);
//            return;
//        }
//        String cur = s+root.val;
//        if (root.left != null) {
//            inorderTranverse(root.left, cur);
//        }
//        if (root.right != null) {
//            inorderTranverse(root.right, cur);
//        }
//    }
	
	/* Directly use int to do the calculate*/
//  public int sumNumbers(TreeNode root) {
//      if (root == null) return 0;
//      return inorderTranverse(root, 0);
//  }
//  private int inorderTranverse(TreeNode root, int preV){
//      if (root.left == null && root.right == null) {
//          return preV*10 + root.val;
//      }
//      int sum = 0;
//      if (root.left != null) {
//          sum += inorderTranverse(root.left, preV*10+root.val);
//      }
//      if (root.right != null) {
//          sum += inorderTranverse(root.right, preV*10+root.val);
//      }
//      return sum;
//  }
	
	/*Use Iterative method instead of recursion*/
	public int sumNumbers(TreeNode root){
	    if (root == null) return 0;
		int result = 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> sum = new LinkedList<Integer>();
		queue.addLast(root);
		sum.addLast(0);;
		while(!queue.isEmpty()){
			TreeNode curNode = queue.removeFirst();
			int curNum = sum.removeFirst();
			if (curNode.left == null && curNode.right == null) {
				result += curNum*10+curNode.val;
			} else {
				if(curNode.left != null) {
					queue.addLast(curNode.left);
					sum.addLast(curNum*10+curNode.val);
				}
				if(curNode.right != null) {
					queue.addLast(curNode.right);
					sum.addLast(curNum*10+curNode.val);
				}
			}
		}
		return result;
	}
	
	
}
