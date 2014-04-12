package Leetcode;

public class UniqueBSTs {
    public int numTrees(int n) {
        return helper(1,n);
    }
    /*
    * Given a element as root, all the elements smaller than it should in the left substree, and larger ones go in right
    * Thus the numbers it has should be left*right for this element
    * choose all element in the range as the root, sum their numbers together and return
    * base: when start>=end, there only be 1 way to do that.
    */
    private int helper(int start, int end) {
        if (start >= end) return 1;
        int count = 0;
        for (int num=start; num<=end; num++){
            int left = helper(start, num-1);
            int right = helper(num+1, end);
            count += left*right;
        }
        return count;
    }
}
