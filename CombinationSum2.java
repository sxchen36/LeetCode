package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Different from CS1 is that: there are duplicate numbers in int[], which could lead to same combination
 * So we use hashset to ensure all the conbinations are unique
 * 
 * 第二轮做时： 用HashSet就不好玩了~其实每次for时判断一下是不是与之前的数值重复就好了嗯！*/


public class CombinationSum2 {
//    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
//        Arrays.sort(num);
//        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
//        ArrayList<Integer> element = new ArrayList<Integer>();
//        helper(num, target, 0, element, res);
//        return new ArrayList<ArrayList<Integer>>(res);
//    }
//    
//    private void helper(int[] num, int gap, int start, ArrayList<Integer> ele, Set<ArrayList<Integer>> res){
//        if (gap == 0) {
//            res.add(new ArrayList<Integer>(ele));// copy!!
//            return;
//        }
//        
//        for (int i=start; i<num.length; i++){
//            if(num[i] >gap) return;
//            ele.add(num[i]);
//            helper(num, gap-num[i], i+1, ele, res);
//            Integer tmp = num[i];
//            ele.remove(tmp);
//        }
//    }
	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        helper(num, 0, target, set, res);
        return res;
    }
    
    private void helper(int[] num, int start, int target, List<Integer> set, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(set));
        } else if (start >= num.length || num[start] > target) {
            return;
        } else {
            for (int i=start; i<num.length && num[i] <= target; i++) {
                if (i ==start || num[i] != num[i-1]) {
                    set.add(num[i]);
                    helper(num, i+1, target-num[i],set, res);
                    set.remove(set.size()-1);  
                }

            }
        }
    }
}
