package Leetcode;

public class ValidPalindrome {
	/* Wrong. 1st attempt. 
	 * No need to transfer s to char[], 
	 * use s.charAt()
	 * s.replaceAll("[^0-9a-zA-Z]", "") is useful!!!
	 * regex: regular expression: [ab] a or b   [^a] no a*/
//    public boolean isPalindrome(String s) {
//        char[] re = s.toCharArray();
//        int left = 0;
//        int right = re.length-1;
//        while(left < right) {
//            while(left < re.length/2 && !Character.isLetter(re[left])){
//                left++;
//            }
//            while(right > re.length/2 && !Character.isLetter(re[right])){
//                right--;
//            }
//            if(Character.toLowerCase(re[left]) == Character.toLowerCase(re[right])){
//                left++;
//                right--;
//            } else {
//                return false;
//            }
//        }
//        return true;
//        
//    }
	
	public final static void main(String[] args){
		System.out.println(isPalindrome("a.****"));
	}
	
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^0-9a-zA-Z]", "");
		s = s.toLowerCase();
		int l = 0;
		int r = s.length()-1;
		while (l < r){
			if (s.charAt(l++) != s.charAt(r--)) return false;
		}
		return true;
	}
}
