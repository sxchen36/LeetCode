package Leetcode;

public class Roman2Integer {
	/*看答案看出来的。这是最好的解法。还有一个是从后往前，存pre cur两个值，当cur<pre时就应该减去cur的值了*/
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        // from tail to head, should be smaller -> bigger. thus if reach un-normal big res, should be minus
        for (int i=chars.length-1; i>= 0 ; i--) {
            switch(chars[i]) {
                case 'I': res += (res >= 5) ? -1 : 1; break;
                case 'V': res += 5; break;
                case 'X': res += 10*((res >= 50) ? -1:1); break;
                case 'L': res += 50; break;
                case 'C': res += 100*((res >= 500) ? -1:1); break;
                case 'D': res += 500; break;
                case 'M': res += 1000; break;
            }
        }
        return res;
    }
}
