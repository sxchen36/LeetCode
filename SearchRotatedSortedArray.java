package Leetcode;

public class SearchRotatedSortedArray {
	/**
	 * AC. 
	 * 1. Make judge according to the subarray without the tipping point
	 * ！注意！！*！* A[m] >= A[l] 注意m有等于l当只有两个元素时。这时第一个判断总是成功，那么l=m+1就能挪到第二个元素去，跳出循环做最后判断了
	 */
    public int search(int[] A, int target) {
        int l = 0;
        int r = A.length-1;
        while (l < r) {
            int m = (l+r)/2;
            if(A[m] == target) return m;
            
            if(A[m] >= A[l]) { // tipping point is in right!!! Important!! Should be A[m] >= A[l] cuz m==l when only two elements in A -- if so , it will always leads to l=m+1, which is good cuz A[m] != target already.
                if (A[m] < target || A[l] > target) {
                    l = m +1;
                } else {
                    r = m-1;
                }
            } else { // tippint point is in left
                if (A[m] > target || A[r] < target) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            }
        }
        int index = (A[l] == target) ? l : -1;
        return index;
    }
}
