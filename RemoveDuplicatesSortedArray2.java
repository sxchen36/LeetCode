package Leetcode;

public class RemoveDuplicatesSortedArray2 {
	
	/* Similar with //1, but instead of check with i-1, i-2, pick the middle one
	 * if i == i-1 && i== i+1, do nothing; if i != i+1, that means the edge of the duplicate, add it
	 * General idea: for the duplicate continue subarray, only add first and last element 
	 * Be careful don't forget the last element*/
    public int removeDuplicates(int[] A) {
        if (A.length <= 2) return A.length;
        int count = 1;
        for (int i=1; i<A.length-1; i++){
            if (A[i] != A[i-1] || (A[i] == A[i-1] && A[i] != A[i+1])){
                A[count++] = A[i];
            }
        }
        // when i == A.length-1. If it is duplicate, it is the edge - should be add anyway
        A[count++] = A[A.length-1];
        return count;
    }
	
	//1
	/*Similar with 1. Failed when [1,1,1,2,2,3]. I got [1,1,2,3] cuz for the second 2, it will see [1,1,2,2,2,3] for it*/
//    public int removeDuplicates(int[] A) {
//        if (A.length <= 2) return A.length;
//        int count = 2;
//        for (int i=2; i<A.length; i++){
//            if ((A[i] == A[i-1] && A[i] != A[i-2]) || A[i] != A[i-1]){
//                A[count++] = A[i];
//            }
//        }
//        return count;
//    }
}
