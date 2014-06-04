package Leetcode;

public class MaximumSubarray {
	/**
	 * DP
	 * My thought: Accept!!NB!!
	 * 1. bottom up 不会
	 * 2. top down: if a subarray got the max, any subarray begin with the next index after it must be negative --  
	 * otherwise the max subarray should be longer.
	 * Thus, scan from end, calculate sum. if it sums up positive, compare with the max and store;
	 * if is negative(including single negative num), reset the current sum because the next possible
	 * subarray won't include any part of it.
	 * until pointer reach the index 0;
	 *  What if no positive sum is available? -- scan it again to return the largest number
	 *  O(N)
	 *  
	 *  start from beginning could be same and more straight forward
	 */
	
//	public int maxSubArray(int[] A) {
//        int p = A.length-1;
//        int max = A[p]; // Integer.MIN_VALUE
//        int curSum = 0; // Integer.MIN_VALUE
//        while (p>=0){
//            curSum += A[p];
//            if (curSum < 0) {
//                curSum = 0; 
//            }
//            max = Math.max(curSum, max);
//            p--;
//        }
//
//        /* No need for this partE*/
//        if (max == 0){
//            max = A[0];
//            for (int i=1; i<A.length; i++){
//                if(A[i] > max) max = A[i];
//            }
//        }
//        return max;
//    }
	
	/* Improve of my code
	 * Actually */
//	public int maxSubArray(int[] A) {
//        int p = A.length-1;
//        int max = A[p]; // Integer.MIN_VALUE
//        int curSum = 0; // Integer.MIN_VALUE
//        while (p>=0){
//            curSum += A[p];
//            if(curSum > max) max = curSum;
//            if (curSum < 0) {
//                curSum = 0; 
//            }
////            max = Math.max(curSum, max);
//            p--;
//        }
//        return max;
//    }
	
	/*Most decent solution*/
    public int maxSubArray(int[] A) {
        int max = A[0];
        int count = 0;
        for (int i=0; i<A.length; i++) {
            count += A[i];
            max = Math.max(max, count);
            if (count < 0) {
                count = 0;
            }
        }
        return max;
    }
	
	/* Divide and conquer solution*/
	/* I failed to come up(record) my idea, but the other one's is great
	 * choose the element in middle, it could be in the max subarray or not
	 * if it's not, we simply calculate the [0, i-1] [i+1,end]
	 * if it is in, we find the max purfix subarray from left, max preffix subarray from right sum up
	 * Choose the largest sum to return*/
//	public int maxSubArray(int[] A) {
//	    return maxSubArrayDivide(A,0,A.length-1);
//    }
//    
//    private int maxSubArrayDivide(int[] A, int left, int right) {
//        if (left == right) return A[left];
//        
//        int middle = (left+right)/2;
//        
//        int leftSum = maxSubArrayDivide(A,left,middle); // could be duplicate when middle is the end of the subarray, but it will be too annoying to avoid this. Let it be
//        int rightSum = maxSubArrayDivide(A,middle+1,right);
//        
//        int leftPart = A[middle];
//        int rightPart = A[middle+1];
//        int tmp = 0;
//        for (int i=middle; i>=left; i--) {
//            tmp += A[i];
//            if (tmp > leftPart) leftPart = tmp;
//        }
//        tmp = 0;
//        for (int i=middle+1; i<=right; i++) {
//            tmp += A[i];
//            if (tmp > rightPart) rightPart = tmp;
//        }
//        return Math.max(Math.max(leftSum, rightSum), leftPart+rightPart);
//        
//    }
	
}
