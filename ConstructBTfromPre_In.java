package Leetcode;

public class ConstructBTfromPre_In {
	
	public static final void main(String[] args){
		int[] in = {1,2,3};
		int[] pre = {3,2,1};
		ConstructBTfromPre_In t = new ConstructBTfromPre_In();
		t.buildTree(pre, in);
	}
    /*
    Recursion: the preorder can locate the root, when root == inorder[op], [0,op-1] is the left subtree with the root as pp+1(use as next recursion), if not equal, each time op++, pp++, until reach equal. then pp+1 should be the root of the right tree, [op+1, length] is the right subtree 
    
    * Generally it's right. But my brain stucks at some point.
    * Revised version: use inorder only for locating the end of the subarray, only use preorder to build the tree
    
    */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        
//    }
//    
//    private TreeNode helper(int[] preorder, int pp, int[] inorder, int op) {
//        TreeNode root = new TreeNode(preorder[pp]);
//        int leftRootIndex = pp+1; 
//        while(inorder[op] != root.val) {
//            pp++;
//            op++;
//        }
//        root.left = helper(preorder, leftRootIndex, inorder, op+1)
//        int rightRootIndex = pp+1;
//    }
	
    /*
    Recursion: the preorder can locate the root, when root == inorder[op], [0,op-1] is the left subtree with the root as pp+1(use as next recursion), if not equal, each time op++, pp++, until reach equal. then pp+1 should be the root of the right tree, [op+1, length] is the right subtree 
    
    * Generally it's right. But my brain stucks at some point.
    * Revised version: use inorder only for locating the end of the subarray, only use preorder to build the tree
    * Key point: the range defined by lindex and hindex contains same set of numbers for preorder and inorder!!
    *            pre- define the begin, search in inorder find the seperate point index, and apply it to preorder!!
    
    */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return helper(preorder, 0, inorder, inorder.length-1);
//    }
//    
//    private TreeNode helper(int[] preorder, int lindex, int[] inorder, int hindex) {
//        if (lindex > hindex) return null; //  important!! ex. [1,2] [2,1] then root(1).left = helper(,1,,0); should be null
//
//        TreeNode root = new TreeNode(preorder[lindex]);
//        if (lindex == hindex) return root;
//        int mid = lindex;
//        for (int i= lindex; i<=hindex; i++) {
//            if (inorder[i] == root.val) {
//                mid = i;
//                break;
//            }
//        }
//        root.left = helper(preorder, lindex+1, inorder, mid); // Notice mid don't +1 !!! because mid calculated by index in inorder, but here it means the hindex in preorder, can't exclusive
//        root.right = helper(preorder, mid+1, inorder, hindex);
//        return root;
//    }
	
	/**
	 * 思路和上边一样，但java貌似就得多用几个变量来存了……还是C++方便
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) return null; //  important!! ex. [1,2] [2,1] then root(1).left = helper(,1,,0); should be null

        TreeNode root = new TreeNode(preorder[prestart]);
        if (instart == inend) return root;
        int mid = 0;
        for (int i= instart; i<=inend; i++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }
        root.left = helper(preorder, prestart+1, prestart+mid-instart, inorder, instart, mid-1);
        root.right = helper(preorder, prestart+mid-instart+1, preend, inorder, mid+1, inend);
        return root;
    }
	
}
