package Leetcode;

import java.util.ArrayList;

public class GrayCode {
	/* According to the rule of generate it*/
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i=0; i<n; i++){
            int len = res.size();
            for (int j=len-1; j>= 0; j--) {
                int x = 1 << i;
                res.add(x + res.get(j));
            }
        }
        return res;
    }

}
