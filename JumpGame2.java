package Leetcode;

public class JumpGame2 {
    /*Wrong: Back -> front
    mark the index which A[index] >= length-index as 1 step, update the smallest index of step 1
    mark the index which A[index] >= step1 - index as 2 step... 
    Wrong reason: impossible.*/
	
	/*Use multiple variables
	 * check chars one by one by i,
	 * step is the min steps to get here
	 * preMax is the longest distance can be reached with 'step' steps
	 * curr is the longest distance that can be reach with 'step'+1 steps
	 * 
	 * 这种解法JumpGame1也可以用吧*/
	
    public int jump(int[] A) {
        int step = 0;
        int preMax = 0;
        int curr = 0;
        for (int i=0; i<A.length; i++){
        	if(i> preMax) {
        		if(preMax == curr && preMax != A.length-1) return -1;  // if curr with step+1 is still preMax, that index = 0, which will never reach the end
        		preMax = curr;
        		step++;
        	}  	
        	curr = Math.max(curr, A[i]+i);
        }
        return step;
    }
	
}
