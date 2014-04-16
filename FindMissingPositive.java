package Leetcode;

public class FindMissingPositive {
    /*Constant space, can't use tree or hashtable or so ------------- USE ARRAY ITSELF AS HASHTABLE
    How about bit manipulation -- no. has negative and no way to track every number in one integer
    Find max and compare with the length, if max = length+1... no. no sorted, can't shorten this method
    ...
    Read Discuss, people use the array as a Hashtable
    So use the corresponding as hash i->A[i]
    which means ith element in A stores number i+1
    
    *
    *        let the #(A[i]-1) th index store its value A[i], could be one-to-one (no duplicated)
        	 A[i]'s range should be in [1, n], thus use as index should -1,
        	 	- if no missing, then the first missing should be n+1.
        	 	- if there is one missing, then there must be one x <= 0 or x > n replace one number [1,n]
        	 	  when we skip it, it will be the only index that won't satisfied A[x] = x
    *
    */
    
    /*Constant space, can't use tree or hashtable or so ------------- USE ARRAY ITSELF AS HASHTABLE
    How about bit manipulation -- no. has negative and no way to track every number in one integer
    Find max and compare with the length, if max = length+1... no. no sorted, can't shorten this method
    ...
    Read Discuss, people use the array as a Hashtable
    So use the corresponding as hash i->A[i]
    which means ith element in A stores number i+1*/
	/* Need to recheck after each swap*/
    public int firstMissingPositive(int[] A) {
        
        for (int i=0; i<A.length; i++){
            if(A[i] <= A.length && A[i]> 0 && A[A[i]-1] != A[i]) { 
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
                i--; // recheck the swapped value
            }
        }
        
        for (int i=0; i<A.length; i++){
        	if (A[i]-1 != i) return i+1; // should be A[i] , or i+1
        }
        return A.length+1;
    }
}
