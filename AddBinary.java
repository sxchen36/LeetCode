package Leetcode;

public class AddBinary {
	
    /*Use String to solve it. 太蛋疼了肯定不是这么解的。
     * Later try to use bit????*/
	
	/*
	 * Bit manipulation: if use int to store bit value, can only deal with 32 bit, while use long, can deal with 64 bit
	 * If the string is even longer, can I cut them into 2 part and then concatenate together?
	 * @param args
	 */
	
    /*Share the same idea as the first thinking, with simpler code*/
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        String res = "";
        for (int i=0; i<Math.max(m,n); i++) {
            int q = i < m ? a.charAt(m - 1 - i) - '0' : 0;
            int p = i < n ? b.charAt(n - 1 - i) - '0' : 0;
            int tmp = q + p + carry;
            carry = tmp/2;
            res = tmp%2 + res;
        }
        if (carry != 0) res = "1" + res;
        return res.toString();
    }
	
	public static final void main(String[] args){
		AddBinary t = new AddBinary();
		String a = "11";
		String b = "1";
		System.out.print(t.addBinary(a, b));
	}
	
    /*bit manipulate*/
//    public String addBinary(String a, String b) {
//        if (a.equals("0")) return b;
//        if (b.equals("0")) return a;
//        
//        long bia = 0;
//        for (int i=0; i<a.length(); i++) {
//        	bia <<= 1;
//            if (a.charAt(i) == '1') {
//                bia |= 1;
//            }
//        }
//        
//        long bib = 0;
//        for (int i=0; i<b.length(); i++) {
//            bib <<= 1;
//            if (b.charAt(i) == '1') {
//                bib |= 1;
//            }
//        }
//        
//        long ab = bia + bib;
//        
//        String res = "";
//        while (ab > 0){
//            if((ab & 1) == 1) {
//                res = "1" + res;
//            } else {
//                res = "0" + res;
//            }
//            ab >>= 1;
//        }
//        return res;
//    }
	
	
	

//    public String addBinary(String a, String b) {
//        String base = (a.length() > b.length())? a : b;
//        String smaller = (a.length() <= b.length())? a : b;
//        String res = "";
//        boolean add1 = false;
//        for (int offset=0; offset< base.length(); offset++) {
//            String tmp = "";
//            if (base.charAt(base.length()-1-offset) == '1') {
//                if (smaller.length() - 1 - offset >= 0 && smaller.charAt(smaller.length() -1-offset) == '1') {
//                    if (add1) {
//                        tmp = "1";
//                    } else {
//                        tmp = "0";
//                    }
//                    add1 = true;
//                } else {
//                    if (add1) {
//                        tmp = "0";
//                        add1 = true;
//                    } else {
//                        tmp = "1";
//                        add1 = false;
//                    }
//
//                }
//            } else {
//                if (smaller.length() -1 - offset >= 0 && smaller.charAt(smaller.length()-1-offset) == '1') {
//                    if (add1) {
//                        tmp = "0";
//                        add1 = true;
//                    } else {
//                        tmp = "0";
//                        add1 = false;
//                    }
//                } else {
//                    tmp = "0";
//                    add1 = false;
//                }
//            }
//            res = tmp + res;
//        }
//        return res;
//    }
}
