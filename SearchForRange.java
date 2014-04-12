package Leetcode;

public class SearchForRange {
	/*AC 1st time! O(N) max 2N*/
//    public int[] searchRange(int[] A, int target) {
//        int[] range = new int[2];
//        for (int i=0; i<2; i++){
//            range[i] = -1;
//        }
//        for (int i=0; i<A.length; i++){
//            if(target == A[i]) {
//                range[0] = i;
//                break;
//            }
//        }
//        for(int i=A.length-1; i>=0; i--){
//            if(target == A[i]) {
//                range[1] = i;
//                break;
//            }
//        }
//        return range;
//    }
	
	
	/*用的二分法找的，但其实还是O（N）*/
//    public int[] searchRange(int[] A, int target) {
//        int[] range = new int[2];
//        range[0] = -1;
//        range[1] = -1;
//        int start = 0;
//        int end = A.length -1;
//        while (start <= end) {
//            int mid = (start+end)/2;
//            if (A[mid] == target) {
//                for(int p=mid; p>=0; p--){
//                    if(A[p] == target){
//                        range[0] = p;
//                    } else {
//                        break;
//                    }
//                }
//                for (int p=mid; p<A.length; p++){
//                    if(A[p] == target){
//                        range[1] = p;
//                    } else {
//                        break;
//                    }
//                }
//                return range;
//            } else if (A[mid] < target) {
//                start = mid+1;
//            } else {
//                end = mid-1;
//            }
//            
//        }
//        return range;
//    }
	
	/*O(logN)*/
	
}
