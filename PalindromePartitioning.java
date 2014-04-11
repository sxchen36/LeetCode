package Leetcode;
import java.util.ArrayList;
import java.util.HashMap;


public class PalindromePartitioning {
	
	/*Wrong answer my 1st attempt*/
	
//	public ArrayList<ArrayList<String>> partition(String s) {
//        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//        char[] chars = s.toCharArray();
//        // ArrayList<String> allChars = new ArrayList<String>();
//        // for (int i=0; i<length; i++){
//        //     allChars.add(chars[i]+"");
//        // }
//        // result.add(allChars);
//        
//        int length = chars.length;
//        // Each char could be the first char of a palindrome, so we have to check each char N
//        // We need to find the second char for each char, to find potential palindrome, so N^2
//        ArrayList<String> otherArray = new ArrayList<String>();
//        
//        for (int start = 0; start<length;){
//            int end = start+1;
//                if (isPalindrome(start,end)) {
//                    otherArray.add(s.subString(start,end));
//                }
//            }
//            start
//        }
//
//    
//    }
	
	
	/* Accepted according to other's hint*/
    HashMap<String, ArrayList<ArrayList<String>>> table;
    public ArrayList<ArrayList<String>> partition(String s) {
        /* Second try: for each partition ArrayList, it could be think as
            a palindrome word + all the possible partition ArrayList results returned by the subString
            after that. Thus, recursion -- might can include map to be dynamic programming
            Thus we want a private method which return ArrayList<ArrayList<String>> to support */
           table = new HashMap<String, ArrayList<ArrayList<String>>>();
            return partitionHelper(s);

    }
    
    private ArrayList<ArrayList<String>> partitionHelper(String s){
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        if (table.containsKey(s)) return table.get(s);
        
        /* Has a difficulty to come up with the ending condition*/
        if (s.length() == 0) {
            res.add(new ArrayList<String>());
            return res;
        }
        
        for (int i=1; i<=s.length(); i++){
            String start = s.substring(0,i); // end index exclusive
            if (isPalindrome(start)){
                ArrayList<ArrayList<String>> ret = partitionHelper(s.substring(i)); // start index always inclusive
                for (ArrayList<String> sample: ret){
                    ArrayList<String> tmp = new ArrayList<String>(sample);
                    tmp.add(0,start);
                    res.add(tmp);
                }
            }
        }
        table.put(s, res);
        return res;
    }
    
    private boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        int offset = 0;
        int length = s.length();
        while (offset < length/2){
            if(chars[0+offset] != chars[length-1-offset]) {
                return false;
            }
            offset++;
        }
        return true;
    }
	
	
	
	
}
