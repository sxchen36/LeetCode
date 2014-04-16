package Leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        // assert strs as least has 1 element
        String str1 = strs[0]; // longest common prefix
        for (int i=1; i< strs.length; i++){ // go through strings one by one
            String str2 = strs[i];
            int p = 0;
            while(p < str1.length() && p < str2.length()) {
                if (str1.charAt(p) == str2.charAt(p)) {
                    p++;
                } else {
                    if (p == 0) return "";
                    // assert p != 0
                    str1 = str1.substring(0, p); // longest common prefix
                    break;
                }
            }
            // assert either p1 or p2 is over flow
            str1 = (str1.length() > str2.length()) ? str2 : str1;
        }
        return str1;
    }
}
