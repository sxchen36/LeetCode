package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Different from CS1 is that: there are duplicate numbers in int[], which could lead to same combination
 * So we use hashset to ensure all the conbinations are unique*/
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> element = new ArrayList<Integer>();
        helper(num, target, 0, element, res);
        return new ArrayList<ArrayList<Integer>>(res);
    }
    
    private void helper(int[] num, int gap, int start, ArrayList<Integer> ele, Set<ArrayList<Integer>> res){
        if (gap == 0) {
            res.add(new ArrayList<Integer>(ele));// copy!!
            return;
        }
        
        for (int i=start; i<num.length; i++){
            if(num[i] >gap) return;
            ele.add(num[i]);
            helper(num, gap-num[i], i+1, ele, res);
            Integer tmp = num[i];
            ele.remove(tmp);
        }
    }
}
