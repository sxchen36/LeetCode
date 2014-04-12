package Leetcode;

public class SearchInsertPosition {
	/*Too simple
	 * Notice that after for loop there must be a return as the last one */
	//O(N)
//    public int searchInsert(int[] A, int target) {
//        for (int i=0; i<A.length; i++) {
//            if(A[i] == target || A[i] > target) {
//                return i;
//            }
//        }
//        return A.length;
//    }
	/**
	 * A little bit tricky O(logN)
	 * Important:  while(start!=end) then :end = mid   
	 * otherwise the start could be larger than end when start+1 = end, then while loop will never end
	 * 
	 * OR
	 * 
	 * while(start<end) then: end = mid-1, then could be start=0, end=-1, then still return according start
	 */
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        while(start != end) {
            int mid = (start + end)/2;
            if (target == A[mid]) return mid;
            
            if (target < A[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return (A[start] < target) ? start+1:start;
    }
}
