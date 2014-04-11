package Leetcode;
import java.util.LinkedList;


public class SameTree {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	/*1st AC: recursion solution*/
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        return compare(p,q);
//    }
//    
//    private boolean compare(TreeNode p, TreeNode q){
//        if (p==null && q==null){
//            return true;
//        }
//        
//        if (p==null || q==null){
//            return false;
//        }
//        
//        return (p.val == q.val && compare(p.left, q.left) && compare(p.right, q.right));
//    }
	  
	  
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null) {
			return false;
		}
		LinkedList<TreeNode> plist = new LinkedList<TreeNode>();
		LinkedList<TreeNode> qlist = new LinkedList<TreeNode>();
		plist.addLast(p);
		qlist.addLast(q);
		while (plist.size() != 0) {
			TreeNode pnode = plist.pollFirst();
			TreeNode qnode = qlist.pollFirst();
			if (pnode.val == qnode.val) {
				if (pnode.left != null) {
					if (qnode.left == null) {
						return false;
					} else {
						plist.addLast(pnode.left);
						qlist.addLast(qnode.left);
					}
				}
				if (pnode.right != null) {
					if (qnode.right == null) {
						return false;
					} else {
						plist.addLast(pnode.right);
						qlist.addLast(qnode.right);
					}
				}
			} else {
				return false;
			}
		}
		if (qlist.size() != 0) {
			return false;
		} else {
			return true;
		}
	}
}
