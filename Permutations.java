package Leetcode;
import java.util.ArrayList;
import java.util.HashSet;

public class Permutations {
	public static final void main(String[] args){
		Permutations p = new Permutations();
		int[] num = {0,1};
		
		ArrayList<ArrayList<Integer>> res = p.permute(num);
		for (ArrayList<Integer> e : res){
			System.out.print("[");
			for (Integer i : e){
				System.out.print(i+",");
			}
			System.out.print("]");
		}
	}
	
	/**
	 * AC. Using HashSet to keep result unique
	 * Seems that the test cases only contains unique numbers? Let's see permutationII
	 * Yes this solution works for permutationII perfectly
	 */
	 public ArrayList<ArrayList<Integer>> permute(int[] num) {
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
         for (ArrayList<Integer> e : permuteHelper(num, 0)) {
             res.add(e);
         }
	     return res;
	    }
	   
	    private HashSet<ArrayList<Integer>> permuteHelper(int[] num, int index){
	        if (index == num.length-1){
	            ArrayList<Integer> oneEle = new ArrayList<Integer>();
	            oneEle.add(num[index]);
	            HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
	            res.add(oneEle);
	            return res;
	        } else {
	            HashSet<ArrayList<Integer>> resPre = permuteHelper(num, index+1);
	            HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
	            int cur = num[index];
	            for (ArrayList<Integer> preEle : resPre) {
	                for (int i=0; i<= preEle.size(); i++){
		            	ArrayList<Integer> ele = new ArrayList<Integer>(preEle);
	                    ele.add(i, cur);
	                    res.add(ele);
	                }
	                
	            }
	            return res;
	        }
	    }
}
