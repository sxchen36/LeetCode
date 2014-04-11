package Leetcode;
import java.util.ArrayList;


public class SymmetricTree {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 /*Attempt: build ArrayList for next row, check whether they are symmetric when put children in the list
	  * 卧槽第二次提交居然就通过了！！*/
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) return true;
//        ArrayList<TreeNode> llist = new ArrayList<TreeNode>();
//        ArrayList<TreeNode> rlist = new ArrayList<TreeNode>();
//        if (root.left != null && root.right != null) {
//            if (root.left.val == root.right.val) {
//                llist.add(root.left);
//                rlist.add(root.right);
//                return helper(llist, rlist);
//            } else {
//                return false;
//            }
//        } else if (root.left == null && root.right == null){
//            return true;
//        }
//        return false;
//    }
//    
//    private boolean helper(ArrayList<TreeNode> llist, ArrayList<TreeNode> rlist){
//        if(llist.size() != rlist.size()) return false;
//        if(llist.size() == 0) return true;
//        
//        ArrayList<TreeNode> lnew = new ArrayList<TreeNode>();
//        ArrayList<TreeNode> rnew = new ArrayList<TreeNode>();        
//        
//        for (int i=0; i<llist.size(); i++){
//            if (llist.get(i).val == rlist.get(i).val){
//                if (llist.get(i).left != null && rlist.get(i).right != null){
//                    lnew.add(llist.get(i).left);
//                    rnew.add(rlist.get(i).right);
//                } else if (llist.get(i).left == null && rlist.get(i).right == null) {
//                    // do nothing
//                } else {
//                    return false;
//                }
//                if (llist.get(i).right != null && rlist.get(i).left != null){
//                    lnew.add(llist.get(i).right);
//                    rnew.add(rlist.get(i).left);
//                } else if (llist.get(i).right == null && rlist.get(i).left == null) {
//                    // do nothing
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//        return helper(lnew, rnew);
//    }
	
	/**
	 * My iteration version. Same logic as the recursion one. 
	 */
//	public boolean isSymmetric(TreeNode root) {
//		if (root == null)
//			return true;
//		ArrayList<TreeNode> llist = new ArrayList<TreeNode>();
//		ArrayList<TreeNode> rlist = new ArrayList<TreeNode>();
//		if (root.left != null && root.right != null) {
//			if (root.left.val == root.right.val) {
//				llist.add(root.left);
//				rlist.add(root.right);
//				while (llist.size() == rlist.size() && llist.size() != 0) {
//					ArrayList<TreeNode> lnew = new ArrayList<TreeNode>();
//					ArrayList<TreeNode> rnew = new ArrayList<TreeNode>();
//					for (int i = 0; i < llist.size(); i++) {
//						if (llist.get(i).val == rlist.get(i).val) {
//							if (llist.get(i).left != null
//									&& rlist.get(i).right != null) {
//								lnew.add(llist.get(i).left);
//								rnew.add(rlist.get(i).right);
//							} else if (llist.get(i).left == null
//									&& rlist.get(i).right == null) {
//								// do nothing
//							} else {
//								return false;
//							}
//							if (llist.get(i).right != null
//									&& rlist.get(i).left != null) {
//								lnew.add(llist.get(i).right);
//								rnew.add(rlist.get(i).left);
//							} else if (llist.get(i).right == null
//									&& rlist.get(i).left == null) {
//								// do nothing
//							} else {
//								return false;
//							}
//						} else {
//							return false;
//						}
//					}
//						llist = lnew;
//						rlist = rnew;
//					}
//				if (llist.size() != rlist.size()) {
//					return false;
//				} else {
//					return true;
//				}
//			} else {
//				return false;
//			}
//		} else if (root.left == null && root.right == null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
    /*Should consider inorder next time!! but if use inorder here, should be careful because of the null child
     * Can choose to add '#' to that place*/
	
	/**
	 * Much simpler recursion:
	 * basic idea: taken two nodes, whether this two node are equal depends on :
	 *   left.left and right.right, left.right and right.left, this two nodes' value
	 * return base: both are null;
	 *     /*Using two stack to maintain two node also do the job
	 */

	public boolean isSymmetric(TreeNode root) {
	    if (root == null) return true;
	    return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        } else if (left != null && right != null) {
                return ((left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left));
        } else {
            return false;
        }
    }
    

    

}
