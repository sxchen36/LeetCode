package Leetcode;
import java.util.ArrayList;


public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        return arrayHelper(S,0);
    }
	

	/**
	 * 	recursion, always return all subsets starting from certain index
	 * @param preSets previous subset
	 * @param index new element need add
	 * @return collection of all subsets starting from this index
	 */
	private ArrayList<ArrayList<Integer>> arrayHelper(int[] S, int index){
		ArrayList<ArrayList<Integer>> sum = new ArrayList<ArrayList<Integer>>();
		int len = S.length;
		
		if(len == 0){
			return sum;
		}
		
		if(index == len){
			sum.add(new ArrayList<Integer>());
			return sum;
		}
		
		ArrayList<ArrayList<Integer>> curList = arrayHelper(S, index+1);
		sum.addAll(curList);
		int curNum = S[index];
		for (int i=0; i<curList.size(); i++){
			ArrayList<Integer> curSubset = curList.get(i);
			curSubset.add(curNum);
			sum.add(curSubset);
		}
		
		return sum;
	}

}
