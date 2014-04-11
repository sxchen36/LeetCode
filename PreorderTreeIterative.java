package Leetcode;
import java.util.ArrayList;
import java.util.Stack;




public class PreorderTreeIterative {
	public static void main(String[] args){
		TreeNode f = new TreeNode(1);
		TreeNode s = new TreeNode(2);
		TreeNode t = new TreeNode(3);
		f.right = s;
		s.left = t;
		System.out.println(preorderTraversal(f));
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		if(root==null) return array; // Always be aware of the null input
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode cur = stack.pop();
			array.add(cur.val);
			if(cur.right != null){
				stack.push(cur.right);
			}
			if(cur.left != null){
				stack.push(cur.left);
			}
		}
		return array;
	}
}
