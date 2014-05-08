package Leetcode;

public class RecoverBinaryTree {

	/*
	 * O(1) in-order tranverse the tree, find two node that violate the order,
	 * then swap their value
	 */
	public void recoverTree(TreeNode root) {
		if (root == null)
			return;

		TreeNode cur = root;
		TreeNode parent = null;
		boolean found = false;
		TreeNode f1 = null, f2 = null;
		while (cur != null) {
			if (cur.left == null) {
				if (parent != null && parent.val > cur.val) {
					if (!found) {
						f1 = parent;
						found = true;
					}
					f2 = cur;
				}
				parent = cur;
				cur = cur.right;
			} else {
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				} else {
					pre.right = null;

					if (parent != null && parent.val > cur.val) {
						if (!found) {
							f1 = parent;
							found = true;
						}
						f2 = cur; // be careful for here! don't need else.
									// otherwise {0,1} won't have f2
					}
					parent = cur;
					cur = cur.right;
				}
			}
		}
		int tmp = f1.val;
		f1.val = f2.val;
		f2.val = tmp;
	}
}
