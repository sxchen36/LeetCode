package Leetcode;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int p = m+n-1;
        int pa = m-1;
        int pb = n-1;
        while (pa >= 0 && pb >= 0) {
            if (B[pb]>A[pa]) {
                A[p] = B[pb];
                pb--;
            } else {
                A[p] = A[pa];
                pa--;
            }
            p--;
        }
        // either pa or pb < 0
        if (pa < 0){
            for(int i=pb; i >=0; i--){
                A[p] = B[i];
                p--;
            }
        } else {
            for(int i=pa; i >=0; i--){
                A[p] = A[i];
                p--;
            }
        }
    }
}
