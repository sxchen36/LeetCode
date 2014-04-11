package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;


public class Subsets20 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {1,2,2};
		System.out.println(subsetsWithDup(t));

	}
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        int len = num.length;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<Math.pow(2,len); i++){
            ArrayList<Integer> eleList = new ArrayList<Integer>();
            int temp = i;
            for (int j=0; j<len; j++){
                if((temp&1) == 1){
                    eleList.add(num[j]);
                }
                temp>>=1;
            }
            if(!result.contains(eleList)){
                result.add(eleList);
            }
        }
        return result;
    }
}
