package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum {
	
	public final static void main(String[] args){
		CombinationSum t = new CombinationSum();
		int[] candidates = {1};
		t.combinationSum(candidates, 1);
	}
	
    /* start from 0, for each combination, it could start in some combinations or not until it the start int > target
    then the combination can be calculate with previous int list + this int +  and update gap and previous int list + update gap
    if the gap couldn't equal 0, it must meet some int that all int after that are larger than the gap, then no result
    if the gap equals to 0, add the element (int list) to the result, and return back
    Notice that for each exist previous int list, there could be many combinations after that, thus after the recursion,
    need to reset element(int list), then move to next start
    
    What if input {2,2,2,2} 4??? for this, assume all element in candidates are unique
 */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ele = new ArrayList<Integer>();
        helper(candidates, target, 0, ele, res);
        return res;
    }
    
    private void helper(int[] candidates, int target, int start, ArrayList<Integer> element, ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(element));
            return;
        }
        if (candidates[start] > target) return;
        for (int i=start; i<candidates.length; i++) {
            if (candidates[i] > target) return;
            element.add(candidates[i]);
            helper(candidates, target - candidates[i], i, element, res);
            Integer tmp = candidates[i];
            element.remove(tmp);
        }
    }
	
	
    /* Basic idea:  不太work但基本思路没错
    the combinations is in non-descending order, scan from the end until find the first element that equals or smaller than T
    the combination should come from this subset
    if value v equals to T, add the element(copy) to the result, 
    if not, calculate the difference between v and T, recursively find (T-v) as the target in subarray including value v
    if candidates has no element, return.*/
	/* Notice
	 * 1. make copy of element when add into result
	 **/
//    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> ele = new ArrayList<Integer>();
//        helper(candidates, target, ele, res);
//        return res;
//    }
//    
//    private void helper(int[] candidates, int target, ArrayList<Integer> element, ArrayList<ArrayList<Integer>> res) {
//        int end = candidates.length-1;
//        if (target == 0) {
//            res.add(element);
//            return;
//        }
//        
//        while(end >=0 && candidates[end] > target) {
//            end--;
//        }
//        if (end < 0) return;
//        if (candidates[end] == target) {
//            ArrayList<Integer> tmp = new ArrayList<Integer>(element);
//            tmp.add(candidates[end]);
//            res.add(tmp);
//            end--;
//            if (end < 0) return;
//            helper(Arrays.copyOfRange(candidates,0,end+1), target, element, res);
//        } else {
//            element.add(candidates[end]);
//            int[] subcan = Arrays.copyOfRange(candidates, 0, end+1);// exclusive end+1
//            int new_target = target - candidates[end];
//            helper(subcan, new_target, element, res);
//        }
//
//    }
}
