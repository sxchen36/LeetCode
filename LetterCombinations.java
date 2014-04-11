package Leetcode;
import java.util.ArrayList;


public class LetterCombinations {
	/* AC. For each digit, iterate all possible letter and append with combinations formed by subString
	 * This is recursion version
	 * This is BSF, noticed that I represent each level with a arraylist
	 * Also I can use DSF, which add each combination from the first select element to the end, one by one
	 */
    public ArrayList<String> letterCombinations(String digits) {
        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";        
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        return helper(digits, 0, map);
    }
    
    private ArrayList<String> helper(String digits, int start, String[] map){
        if (start ==  digits.length()){
            ArrayList<String> res = new ArrayList<String>();
            res.add("");
            return res;
        }
        ArrayList<String> res = new ArrayList<String>();
            int index = digits.charAt(start)-'0';
            String letters = map[index];
            for (int i=0; i<letters.length(); i++){
            	char cur = letters.charAt(i);
                ArrayList<String> append = helper(digits, start+1, map);
                for (String str: append){
                    String tmp = cur + str;
                    res.add(tmp);
                }
            }

        return res;
    }
}
