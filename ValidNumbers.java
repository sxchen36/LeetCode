package Leetcode;
import static org.junit.Assert.*;

public class ValidNumbers {
	
	public static void main(String[] args) {
		ValidNumbers v = new ValidNumbers();
		assertEquals(true,v.isNumber(".1"));
		assertEquals(true, v.isNumber("2e9"));
		assertEquals(false, v.isNumber("e9"));
		assertEquals(true, v.isNumber("1."));
		assertEquals(true, v.isNumber("+1"));
		assertEquals(true, v.isNumber("   0"));
		assertEquals(false, v.isNumber("0e"));
	}
   /*1. Transfer to char array
    2. scan the array
      - numbers, ok
      - letters, e is ok when not first or last
      - signs, '-' could be the first or after e; ',' could be anywhere other than first or last or after e
      - others false
      
              Update: split the string with different delims, instead of check chars one by one,  will make it clearer、
        Use Abstract describtion combine with regular expression to describe the result
        
        UnsignInt = [0-9]+
        Int = [+-]UnsignInt | UnsignInt
        Double = Int.UnsignInt | Int. | .UnsignInt | [+-].UnsignInt | Int
        E = Double[eE]Int | Double
        
        start parse from E, use OO principle*/
    public boolean isNumber(String s) {
    	if (s.equals("")) return false;
        String delims = "[eE]";
        String[] eparse = s.split(delims);
        if (eparse.length > 2) return false;
        
        if (eparse.length == 0) {
        	return false;
        } else if (eparse.length == 1) {
        	if (s.charAt(s.length()-1) == 'e') return false;
            return isDouble(eparse[0]);
        } else {
            return (isDouble(eparse[0]) && isInt(eparse[1]));
        }
    }
    
    private boolean isDouble(String s){
    	if (s.equals("")) return false;
        String delims = "\\.";
        String[] dotparse = s.split(delims);
        if (dotparse.length > 2) return false;
        
        if (dotparse.length == 0) {
            return false;
        } else if (dotparse.length == 1) {
            return isInt(dotparse[0]);
            // length == 2
        } else {
            return  ((dotparse[0].equals("") || dotparse[0].equals("+") || dotparse[0].equals("-")) && isUnsign(dotparse[1])) || (isInt(dotparse[0]) && (isUnsign(dotparse[1])|| dotparse[1].equals(""))); 
        }
    }
    
    private boolean isInt(String s) {
    	if (s.equals("")) return false;
    	char[] A = s.toCharArray();
    	int start = 0;
    	while (start < A.length && A[start] == ' ') start++;
    	if (start == A.length) return false;
    	
        if (A[start] == '-' || A[start] == '+') {
            return isUnsign(s.substring(start+1));
        } else {
            return isUnsign(s.substring(start));
        }
    }
    
    private boolean isUnsign(String s) {
    	if (s == "") return false;
    	int end = s.length()-1;
    	while (end >= 0 && s.charAt(end) == ' ') end--;
    	if (end < 0) return false;
    	
        for (int i=0; i<= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
        }
        return true;
    }
//  public boolean isNumber(String s) {
//      char[] array = s.toCharArray();
//          boolean hasE = false;
//          boolean hasNum = false;
//          boolean hasDot = false;
//      int begin = 0;
//      while (begin < array.length && array[begin] == ' ') begin++;
//      int end = array.length -1;
//      while (end >= 0 && array[end] == ' ') end--;
//          
//      for (int i=begin; i<=end; i++) {
//          char c = array[i];
//
//          if (c <= '9' && c >= '0') {
//              hasNum = true; //  for c=' ' in case all of the string are ' '
//              continue;
//          } else if (c == 'e' && i != 0 && i != end && array[i-1] != '.' && array[i+1] != '.' && !hasE) {
//              hasE = true;
//              continue;
//          } else if ((c == '-' || c == '+') && (i == 0 || array[i-1] == 'e')) {
//              continue;
//          } else if (c == '.' && !hasDot) {
//              hasDot = true;
//              continue;
//          } else {
//              return false;
//          }
//      }
//      return hasNum;
//  }
	
	
}
