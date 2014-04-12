package Leetcode;

public class CountAndSay {
	
	/*AC: 	Count repeated numbers. insert repeated number first and append with the origin number
	 * 1. generate nth number, start from 1 because we initial pre as "1" that's should be index 0
	 * 2. Char -> Integer:    Character.getNumericValue(char) = int
	 * 3. String -> Char:   "dadadc".charAt(i)
	 * 4. String -> Integer: Integer.valueOf("1234");
	 * */
	
	public static final void main(String[] args){
		CountAndSay a = new CountAndSay();
		System.out.println(a.countAndSay(10));
	}
	
	/* Count repeated numbers. insert repeated number first and append with the origin number*/
        public String countAndSay(int n) {
            String pre = "1";
            for(int i=1; i<n; i++) { // generate nth number, start from 1 because we initial pre as "1" that's should be index 0
                String ith = "";
                int count = 1;
                int preNum = Character.getNumericValue(pre.charAt(0));
                for (int j=1; j<pre.length(); j++){
                    int num = Character.getNumericValue(pre.charAt(j));
                    if (num == preNum) {
                        count++;
                    } else {
                        ith = ith+count+preNum;
                        count = 1;
                    }
                    preNum = num;
                }
                // don't forget the last one
                ith = ith + count + preNum;
                pre = ith;
            }
            return pre;
        }
}
