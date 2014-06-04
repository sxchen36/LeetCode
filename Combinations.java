package Leetcode;
import java.util.ArrayList;
import java.util.List;


public class Combinations {
    /* AC: My Basic idea
    Top-down: combine(n,k) can be build with n append to combine(n-1, k-1)
    return base: k==1, then return each n as a seperate ArrayList
    */
//    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if (k < 1) return res;
//        
//        if (k == 1) {
//            for (int i=1; i<=n; i++){
//                ArrayList<Integer> ele = new ArrayList<Integer>();
//                ele.add(i);
//                res.add(ele);
//            }
//            return res;
//        }
//        
//        if (k == n) {
//            ArrayList<Integer> ele = new ArrayList<Integer>();
//            for (int i=1; i<=n; i++){
//                ele.add(i);
//            }
//            res.add(ele);
//            return res;
//        }
//        
//        ArrayList<ArrayList<Integer>> preRes1 = combine(n-1, k-1);
//        for (ArrayList<Integer> e : preRes1){
//            e.add(n);
//            res.add(e);
//        }
//        ArrayList<ArrayList<Integer>> preRes2 = combine(n-1, k);
//        for (ArrayList<Integer> e : preRes2){
//            res.add(e);
//        }
//        return res;
//    }
	
	/*正向思路。 Better solution*/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < k || k == 0) return res;
        List<Integer> com = new ArrayList<Integer>();
        helper(n, k, 1, com, res);
        return res;
    }
    
    private void helper(int n, int k, int start, List<Integer> com, List<List<Integer>> comSet) {
        if (com.size() == k) {
            comSet.add(new ArrayList<Integer>(com));
            return;
        }
        
        for (int i=start; i<= n; i++) {
            com.add(i);
            helper(n, k, i+1, com, comSet);
            com.remove(com.size()-1);
        }
    }
}
