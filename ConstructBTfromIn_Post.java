package Leetcode;

public class ConstructBTfromIn_Post {
	/**
	 * 和另一个同理。只不过这个是从后边开始算。
	 * 注意边界条件，即pend-(iend-mid)-1][pend-(iend-mid)
	 * @param args
	 */
	public static final void main(String[] args){
		ConstructBTfromIn_Post t = new ConstructBTfromIn_Post();
		int[] i = {1,2,3,4};
		int[] p = {3,2,1,4};
		t.buildTree(i, p);
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend){
        if (istart> iend) return null;
        if (istart == iend) return new TreeNode(inorder[istart]);
        
        TreeNode root = new TreeNode(postorder[pend]);
        int mid = 0;
        for (int i=istart; i<=iend; i++){
            if (inorder[i] == root.val) {
                mid = i;
            }
        }
        
        root.left = helper(inorder, istart, mid-1, postorder, pstart, pend-(iend-mid)-1);
        root.right = helper(inorder, mid+1, iend, postorder, pend-(iend-mid), pend-1);
        return root;
    }
}
