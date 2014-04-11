package Leetcode;
import java.util.ArrayList;


public class PreorderTree {
	
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
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		return trav(root);
	}

	private static ArrayList<Integer> trav(TreeNode root) {
		ArrayList<Integer> iter = new ArrayList<Integer>();
		if (root == null) {
			return iter;
		}
		iter.add(root.val);
		iter.addAll(trav(root.left));
		iter.addAll(trav(root.right));
		return iter;
	}
}
