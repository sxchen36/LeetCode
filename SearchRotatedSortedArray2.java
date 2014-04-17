package Leetcode;

public class SearchRotatedSortedArray2 {
    /* First try: same principle as 1. to see what's wrong: [1,1,1,2,3,1]
    Shouldn't be A[m] >= A[l]. Should carefully consider how to deal with A[m] == A[r] or A[l]
    
    *Update//2: carefully exam when A[m] == A[r](or A[l], just one of them is enough)
    * if (A[m] == A[r] == A[l]) there must be a side that are all duplicate, we identify that and search
    * in another side. If only (A[m] == A[r] && A[m] != A[l]), the only possible way is the tipping point in the unequal side  */
 
	/**
	 * Update //3 concise version. Anyway it would take O(N) worse case, thus we only move l to right each time
	 * we find A[m] == A[l] or A[r]
	 */
	//3
    public boolean search(int[] A, int key) {
        int n = A.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (A[m] == key) return true; //return m in Search in Rotated Array I
            if (A[l] < A[m]) { //left half is sorted
                if (A[l] <= key && key < A[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (A[l] > A[m]) { //right half is sorted
                if (A[m] < key && key <= A[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else l++;
        }
        return false;
    }
	
	//2
//	public boolean search(int[] A, int target) {
//     int l = 0;
//     int r = A.length-1;
//     while (l<r) {
//         int m = (l+r)/2;
//         if (A[m] == target) return true;
//         
//         if (A[m] > A[l]) { // tipping point in right side
//             if (A[m] > target && target >= A[l]) {
//                 r = m-1;
//             } else {
//                 l = m+1;
//             }
//         } else if (A[m] < A[r]){ // tipping point in left side
//             if (A[m] < target && target <= A[r]) {
//                 l = m+1;
//             } else {
//                 r = m-1;
//             }
//         } else if (A[m] == A[r]) {
//             if (A[m] != A[l]) { // {2,3,1,1,1,1}
//                 r = m-1;
//             } else { // could be {1,1,1,2,3,1} or {1,2,3,1,1,1,1}
//                 int pl = m;
//                 while (pl > l && A[pl] == A[pl-1]) pl--;
//                 if (pl == l){ // left side are all same
//                     l = m + 1;
//                 } else {
//                     r = m -1;
//                 }
//             }
//         } else { // A[m] != A[r]
//             l = m+1;
//         }
//     }
//     return A[l] == target;
// }
}
