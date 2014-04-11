package Leetcode;

public class MaxPath {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	
    public int maxDepth(TreeNode root) {
        return DFS(root);
    }

    private int DFS(TreeNode p){
    	if (p==null) return 0; // I ignored this edge condition in the first try
    	
    	if(p.left==null && p.right ==null){
    		return 1;
    	}
    	int ld=0;
    	int rd=0;
    	if (p.left!=null){
        	ld = DFS(p.left);
    	}
    	if(p.right!=null){
        	rd = DFS(p.right);
    	}
    	int max = (ld>rd)?ld:rd;
    	return max+1;
    }
}
