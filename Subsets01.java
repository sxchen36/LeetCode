package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;


public class Subsets01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {1,2,2};
		System.out.println(subsets(t));

	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> sum = new ArrayList<ArrayList<Integer>>();
		int len = S.length;
		Arrays.sort(S);
		
		for(int i=0; i<Math.pow(2, len); i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			int tmp = i;
			for(int j=0; j<len; j++){
				int bit = tmp & 1;
				if(bit==1){
					list.add(S[j]);
				}
				tmp >>= 1;
			}
			sum.add(list);
		}
		
		return sum;
	}
}
