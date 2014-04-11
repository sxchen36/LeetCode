package Leetcode;
import java.util.Stack;


public class ValidationBST {
	/*AC use recursion. because need to find max for left subtree and min for right subtree, has to be O(NlogN)*/
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        
//        boolean l = false;
//        boolean r = false;
//
//        if (root.left != null){
//            TreeNode left = root.left;
//            while (left.right != null) {
//                left = left.right;
//            }
//            l = left.val<root.val;
//        } else {
//            l = true;
//        }
//        
//        if (root.right != null){
//            TreeNode right = root.right;
//            while (right.left != null) {
//                right = right.left;
//            }
//            r = right.val>root.val;
//        } else {
//            r = true;
//        }
//        return (l && r && isValidBST(root.left) && isValidBST(root.right));
//    }
    
    /* Better recursion solution:
     * Basic idea: given the possible range of the subtree. if it violate, return false*/
//    public boolean isValidBST(TreeNode root) {
//        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    public boolean helper(TreeNode root, int min, int max){
//        if (root == null)  return true;
//        if (root.val > max || root.val < min ) return false;
//        return (helper(root.left, min, root.val-1)&&helper(root.right, root.val+1, max));
//    }
    
	/**
	 * 自己定义一个in-order的iterater真是太赞了！！！！！
	 * in-order是左 - 中 - 右。整个in-order期间都是ascending的就是true啦！
	 * @author Angel_Death
	 *
	 */
    class BSTInorderIterater {
        Stack<TreeNode> stack;
        
        public BSTInorderIterater(TreeNode root){
            stack = new Stack<TreeNode>();
            update(root);
        }
        
        private void update(TreeNode root){
            TreeNode cur = root;
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        public TreeNode next(){
            if (!hasNext()) return null;
            TreeNode n = stack.pop();
            update(n.right);
            return n;
        }
    }
    public boolean isValidBST(TreeNode root) {
        BSTInorderIterater it = new BSTInorderIterater(root);
        int pre = Integer.MIN_VALUE;
        while (it.hasNext()){
            int cur = it.next().val;
            if (cur <= pre) return false;
            pre = cur;
        }
        return true;
    }
}
