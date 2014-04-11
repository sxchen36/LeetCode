package Leetcode;

public class BinaryTreeMaxPathSum {
	
	public final static void main(String[] args){
		BinaryTreeMaxPathSum t = new BinaryTreeMaxPathSum();
		TreeNode root = new TreeNode(-2);
		TreeNode left = new TreeNode(1);
		root.left = left;
		System.out.println(t.maxPathSum(root));
	}
	
    /* AC： recursion, for each node, the largest path including this node should be including left part and right part
    - unless leftsubtree / right subtree's max is negative
   thus we calculate max path for each node and return the max to its parent node
   End Point: when node == null, return 0
   
   *Update: 边界条件好多。需要实时记录最大值，返回的是左边（或右边）经过root的最大值
   *注意考虑root.val是负数的情况，所以maxSum永远要和不加root.val的比 */
int max = Integer.MIN_VALUE; // keep record of the max sum. return must be either node.val or + leftchild or + right child
public int maxPathSum(TreeNode root) {
    int r = sumHelper(root);	
	r = Math.max(max,r);
    return r;
}

private int sumHelper(TreeNode root){
    if (root.left == null && root.right == null){
        return root.val;
    }
    int ret = root.val;
    int maxSum = root.val;
    int left = Integer.MIN_VALUE;
    int right = Integer.MIN_VALUE;
    if (root.left != null){
        left = Math.max(sumHelper(root.left), left);
    }
    if (root.right != null){
        right = Math.max(sumHelper(root.right), right);
    }
    int larger = Math.max(left, right);
    int smaller = Math.min(left,right);
    
    if (larger < 0){
        maxSum = Math.max(root.val, larger);
    } else if (smaller > 0){
        maxSum = Math.max(root.val+smaller+larger, larger);
    } else {
        maxSum = Math.max(root.val + larger, larger);
    }
    max = Math.max(maxSum, max);

    ret = Math.max(ret, ret+larger);
    return ret;
}
    
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
