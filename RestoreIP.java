package Leetcode;
import java.util.ArrayList;


public class RestoreIP {
	
	/**
	 * AC  基本思路：尝试每种可能的前缀， recursion
	 * 注意s.length()-start>seg * 3这里，不用+1，因为start是从0开始，而length是从1开始，已经+1了
	 * 注意 逢0 则在recurse完之后就不用再往后继续了，应break
	 */
	public static final void main(String[] args){
		RestoreIP t = new RestoreIP();
		t.restoreIpAddresses("25525511135");
	}
	
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        helper(s, 0, 4,"", res);
        return res;
    }
    
    private void helper(String s, int start, int seg, String tmp, ArrayList<String> res) {
        if (start == s.length() && seg == 0){
                String r  = tmp.substring(1);
                res.add(r);
            return;
        }
        
        if (s.length() - start > seg * 3 || s.length() - start < seg) return;
        
        for (int i=1; i<4 && i+start<=s.length(); i++){
            String sub = s.substring(start,i+start);
            String new_tmp = tmp + "." + sub;
            if (Integer.valueOf(sub) <= 255) {
                helper(s, i+start, seg-1, new_tmp, res);
            }
            if (Integer.valueOf(sub) == 0) break;
        }
    }
}
