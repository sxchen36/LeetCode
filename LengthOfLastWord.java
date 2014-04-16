package Leetcode;

public class LengthOfLastWord {
	/* AC O(N) 从后往前*/
    public int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while(end >=0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        // assert s.charAt(end) == a char
        int start = end;
        while(start>=0 && s.charAt(start) != ' ') start--;
        
        if(start < 0) return end+1;
        // assert s.charAt(start) == ' '
        return end-start;
    }
}
