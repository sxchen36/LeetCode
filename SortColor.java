package Leetcode;

public class SortColor {
	
    /* r w b point to the end of corresponding color. i points to new value
    Key Point: i is always larger than r w b, so won't check old value
               by moving each pointer after the insert color, we can get rid of swap~
               
    Notice: the ++ order is important!! should be b -> w -> r to avoid wrong overwrite!
  */
 public void sortColors(int[] A) {
     int r = -1;
     int w = -1;
     int b = -1;
     for (int i=0; i<A.length; i++) {
         if (A[i] == 0) { // all the pointer move to next spot. maintain the length of white and blue and add red
             A[++b] = 2;
             A[++w] = 1;
             A[++r] = 0;
         } else if (A[i] == 1){
             A[++b] = 2;
             A[++w] = 1;
         } else {
             A[++b] = 2;
         }
     }
 }
	
	
	/*Unfinished version. 思路参照了Quick Sort, 但因为想毕其功于一役的O(N) 需要两个pointer做swap
	 * 难点在于一开始的initialization 万一A没有那么长呢？万一就没有0或者1呢？所以不太容易弄。也可以认为
	 * 是错的*/
//	public void sortColors(int[] A) {
//
//		// initialize above two pointer
//		for (int i = 0; i < A.length; i++) {
//			if (A[0] == 0 && A[1] == 1)
//				break;
//			if (A[i] == 0)
//				swap(A, i, 0);
//			if (A[i] == 1)
//				swap(A, i, 1);
//		}
//		int beginWhite = 1;
//		int postWhite = 2; // the position after the last white
//
//		int p = A.length - 1;
//
//		while (p >= postWhite) {
//			if (A[p] == 2) {
//				p--;
//			} else if (A[i] == 1) {
//				swap(A, p, postWhite);
//				postWhite++;
//			} else {
//				swap(A, beginWhite, postWhite);
//				postWhite++;
//				swap(A, beginWhite, p);
//			}
//		}
//	}
}
