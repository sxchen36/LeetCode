package Leetcode;

public class PermutationSequence {
	public static final void main(String[] args){
		PermutationSequence t = new PermutationSequence();
		t.getPermutation(2, 1);
	}
	
    /* brute force: list all the permutations, order them, and find kth
    Can I skip unnecassary calculations and narrow the range...
    
    Update:the nth digit appears in a group of (n-1)!, initialize nums as a ordered array
     thus k/(n-1)! is the index of the number in that array (k/(n-1)!th smallest number in the
      array of all unused numbers), then k = k%mod*/
    public String getPermutation(int n, int k) {
        // initialize n numbers in array
        int[] nums = new int[n];
        int mod = 1;
        for (int i=0; i<n; i++){
            nums[i] = i+1;
            mod *= nums[i];
        }
        String res = "";
        k--; //change the range of k from [1...n] to [0..n-1], for index
        for (int i=0; i<nums.length; i++){
            mod = mod/(n-i);
            int index = k/mod;
            res = res+ nums[index];
            k = k%mod;
            for (int j=index; j<nums.length-1; j++){
                nums[j] = nums[j+1];
            }
        }
        return res;
    }
}
