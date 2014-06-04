package Leetcode;

import java.util.LinkedHashMap;

public class Integer2Roman {

    // Can also use HashMap to keep Integer, Character pairs?
    
    private static LinkedHashMap<Integer, String> numToRoman = new LinkedHashMap<Integer, String>();
        static {
            numToRoman.put(1000, "M");
            numToRoman.put(900, "CM");
            numToRoman.put(500, "D");
            numToRoman.put(400, "CD");
            numToRoman.put(100, "C");
            numToRoman.put(90, "XC");
            numToRoman.put(50, "L");
            numToRoman.put(40, "XL");
            numToRoman.put(10, "X");
            numToRoman.put(9, "IX");
            numToRoman.put(5, "V");
            numToRoman.put(4, "IV");
            numToRoman.put(1, "I");
        }
    
    public String intToRoman(int num) {

        String res = "";
        for (Integer n : numToRoman.keySet()) {
            while (num >= n) {
                res += numToRoman.get(n);
                num -= n;
            }
        }
        return res;
    }
}
