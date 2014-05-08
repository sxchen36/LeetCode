package Leetcode;

public class StringToInteger {
	
	public static final void main(String[] args) {
		StringToInteger t = new StringToInteger();
		System.out.println(t.atoi("      -11919730356x"));
	}
    /*Question: how to deal with the out of range representable values
    Update: use division to check
    Be careful to judge the MAX and MIN value. just use Max to compare, if negative, it only can be MIN*/
    public int atoi(String str) {
        boolean isNeg = false;
            int i = 0;
            while (i < str.length() && str.charAt(i) == ' '){i++;}
            if (i < str.length()) {
                char c = str.charAt(i);
                
                if (c == '-') {
                    isNeg = true;
                    i++;
                } else if (c == '+') {
                    i++;
                }
                
                String numstr = "";
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    numstr += str.charAt(i);
                    i++;
                }
                // numstr is less than 10 
                int num = 0;
                for (int cc=0; cc < numstr.length(); cc++){
                    int n = numstr.charAt(cc)-'0';
                    if (num <= (Integer.MAX_VALUE - n)/10) {
                          num = num*10 + n;
                    } else if (!isNeg){
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                return (isNeg) ? -num : num;
            }
        return 0;
    }
	
	
	/* Wrong version but right based on my logic:
	 * Require: "  -   321" is invalid
	 * My: is 321
	 */
	
//    public int atoi(String str) {
//        boolean isNeg = false;
//        for (int i=0; i<str.length(); i++) {
//            if (Character.isDigit(str.charAt(i))) {
//                if (i-1 >= 0 && str.charAt(i-1) == '-')  isNeg = true;
//                String numstr = "";
//                while (i < str.length() && Character.isDigit(str.charAt(i))) {
//                    numstr += str.charAt(i);
//                    if (numstr.length()>10) return Integer.MAX_VALUE;
//                    i++;
//                }
//                // numstr is less than 10 
//                int num = 0;
//                for (int c=0; c < numstr.length(); c++){
//                    int n = numstr.charAt(c)-'0';
//                    if (num <= (Integer.MAX_VALUE - n)/10) {
//                          num = num*10 + n;
//                    } else if (!isNeg){
//                        return Integer.MAX_VALUE;
//                    } else {
//                        return Integer.MIN_VALUE;
//                    }
//                }
//                return (isNeg) ? -num : num;
//            }
//        }
//        return 0;
//    }
}
