package Leetcode;

public class PlusOne {
	/*一次通过！ 注意考虑999-》1000 的情况就可以~*/
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1] < 9){
            digits[digits.length-1]++;
            return digits;
        }
        
        digits[digits.length-1] = 0;
        boolean overflow = true;
        for(int i=digits.length-2; i >= 0; i--){
            if(overflow) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    overflow = true;
                } else {
                    digits[i]++;
                    overflow = false;
                    break;
                }
            }
        }
        // Consider 999 -> 1000
        if (overflow) {
            int[] newDigit = new int[digits.length+1];
            newDigit[0] = 1;
            digits = newDigit;
        }
        return digits;
    }
}
