package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;


public class Subsets20 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {1,2};
		System.out.println(subsetsWithDup(t));

	}
//    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
//        int len = num.length;
//        Arrays.sort(num);
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        for (int i=0; i<Math.pow(2,len); i++){
//            ArrayList<Integer> eleList = new ArrayList<Integer>();
//            int temp = i;
//            for (int j=0; j<len; j++){
//                if((temp&1) == 1){
//                    eleList.add(num[j]);
//                }
//                temp>>=1;
//            }
//            if(!result.contains(eleList)){
//                result.add(eleList);
//            }
//        }
//        return result;
//    }
	
	
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> pre = new ArrayList<ArrayList<Integer>>();
        
        for (int i=num.length-1; i>=0; i--) {
            if (i == num.length-1 || num[i] != num[i+1]) {
            /*高级！又学到东西了！！ 这样不行~因为虽然pre和res不是同一个id， 但他们的element共享的同个id，即呆会改变tmp也会改变res的！*/
//                pre = new ArrayList<ArrayList<Integer>>(res);
            /*所以只能重新来*/
				pre = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < res.size(); j++) {
					pre.add(new ArrayList<Integer>(res.get(j)));
				}
            }
            
            for (ArrayList<Integer> tmp : pre) {
                tmp.add(0, num[i]);
            }
            
            if (i == num.length-1 || num[i] != num[i+1]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
		    	temp.add(num[i]);
			    pre.add(temp);
            }
            
    		for (ArrayList<Integer> temp : pre) {
    			res.add(new ArrayList<Integer>(temp));
    		}

        }
            		
    		res.add(new ArrayList<Integer>());
    		return res;
    }
}
