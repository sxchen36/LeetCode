package Leetcode;
import java.util.LinkedList;

public class FlattenBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public final static void main(String[] args) {
		FlattenBinaryTree t = new FlattenBinaryTree();
		TreeNode one = t.new TreeNode(1);
		TreeNode two = t.new TreeNode(2);
		TreeNode three = t.new TreeNode(3);
		one.left = two;
		//t.flatten(one);

	}

	/* Should try stack method next time*/
	
	/*
	 * 1st try: Binary tree: each node most has two children when we insert each
	 * node, can assume that before linklist is sorted, and insert it by a
	 * sorted way need a queue to keep the childrens. BFS
	 */
	/*
	 * Misunderstand the question. It not asks to make the linklist sorted... it
	 * just says in-place... For make it a sorted linkedlist, I guess this
	 * solution is right Give it another try
	 */
	// public void flatten(TreeNode root) {
	// if (root == null)
	// return;
	// LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	// queue.addLast(root);
	// TreeNode newRoot = null;
	// while (queue.size() != 0) { // each element in the queue is ready to be
	// // insert to the new list
	// TreeNode cur = queue.removeFirst();
	// if (cur.left != null) {
	// queue.addLast(cur.left);
	// }
	// if (cur.right != null) {
	// queue.addLast(cur.right);
	// }
	// if (cur == root) {
	// newRoot = new TreeNode(root.val);
	// } else {
	// TreeNode tmp = newRoot;
	// while (tmp.right != null && tmp.right.val < cur.val) {
	// tmp = tmp.right;
	// }
	// cur.left = null;
	// cur.right = tmp.right;
	// tmp.right = cur;
	// }
	// }
	// root = newRoot;
	// }

	/*
	 * always return the tree's 'rightest' node
	 * root.left should be root.right
	 * and its left child's most right 's right should be root.right
	 * equals to fit root.left subtree into root and root.right
	 */
//	public void flatten(TreeNode root) {
//		if (root == null)
//			return;
//		help(root);
//	}
//
//	private TreeNode help(TreeNode root) {
//		if (root.left == null && root.right == null)
//			return root;
//
//		TreeNode left = null;
//		if (root.left != null) {
//			left = help(root.left);
//		}
//		TreeNode right = null;
//		if (root.right != null) {
//			right = help(root.right);
//		}
//
//		if (left != null) {
//			left.right = root.right;
//			root.right = root.left;
//			root.left = null;
//		}
//
//		if (right != null) {
//			return right;
//		} else {
//			return left;
//		}
//	}
	
	
	
	
}
