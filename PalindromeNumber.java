package Leetcode;

public class PalindromeNumber {
	/*一次通过的。简单~
	 * Update: 值得问的问题
	 * 	1. 负数可以是Palindrome的吗？-- 把符号先存了
	 *  2. reverse之后溢出怎么办 -- 用long来存result*/
	//2
    public boolean isPalindrome(int x) {
    	boolean isPositive = x>0;
    	if(!isPositive) x = -x;
        long res = 0;
        int sou = x;
        while(sou > 0){
            int num = sou%10;
            res = res*10 + num;
            sou /= 10;
        }
        if (res > 0x7fffffff) return false;
    	if(!isPositive) x = -x;
        return (res == x);
    }
	
	//1
//    public boolean isPalindrome(int x) {
//        int res = 0;
//        int sou = x;
//        while(sou > 0){
//            int num = sou%10;
//            res = res*10 + num;
//            sou /= 10;
//        }
//        return (res == x);
//    }
}
