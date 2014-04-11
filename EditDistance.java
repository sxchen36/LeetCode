package Leetcode;

public class EditDistance {
	public static final void main(String[] args){
		EditDistance t = new EditDistance();
//		System.out.print(t.minDistance("dini","da"));
	}
    /* Wrong: 1st Attemp. Dynamic problem, top - down for three sub-problems
     * 当word1长于word2时，delete；短于，insert优先，等于，replace
     * replace很简单，比对不一样的replace就好了
     * 关键在于加哪些删哪些
     * 两者类此，以加为例，可应用recursion
     * 从A状态变B， 加一个值，加的值可以为任意空隙- B需要尝试把特定数值（特定数值肯定根据word2的符合那个位置，不要再replace了）加到每个位置，选取最小的可能数值然后返回
     * Base case 是两个长度相等，那么计算两个word不同的数的数值，返回.*/

	/*从短的变长的和从长的变短的的最短路径是一样的吧！！*/
//    public int minDistance(String word1, String word2) {
//        if (word1.length() > word2.length()) {
//        	return removeChar(word1, word2);
//        } else {
//        	return removeChar(word2, word1);
//        }
//    }
//    
////    // word1 <= word2 use this method
////    private int insertChar(String word1, String word2) {
////        if (word1.length() == word2.length()) {
////            int count = 0;
////            for (int i=0; i<word1.length(); i++){
////                if(word1.charAt(i) != word2.charAt(i)) count++;
////            }
////            return count;
////        }
////        
////        int min = word2.length()+word1.length();
////        for(int i=0; i<word1.length()-1; i++){
////            String new1 = word1.substring(0, i) + word2.charAt(i) + word1.substring(i);
////            int tmp = insertChar(new1, word2);
////            min = Math.min(min, tmp);
////        }
////        return min+1;
////    }
//    
//    private int removeChar(String word1, String word2) {
//        if (word1.length() == word2.length()) {
//            int count = 0;
//            for (int i=0; i<word1.length(); i++){
//                if(word1.charAt(i) != word2.charAt(i)) count++;
//            }
//            return count;
//        }
//        
//        int min = word2.length()+word1.length();
//        for(int i=0; i<word1.length()-1; i++){
//            String new1 = word1.substring(0,i) + word1.substring(i+1);
//            int tmp = removeChar(new1, word2);
//            min = Math.min(min, tmp);
//        }
//        return min+1;
//    }
	
	
	/*
	 * Attemp2: 读了别人的答案后，发现有另外的思路，同样DP，从末尾往前word1 是i, word2是j, 设A(i)形式是somestr1c；B(i)形如somestr2d的话
	 * 变成当前形式有几种可能
	 * 1, A[i] == B[j] 则编辑距离为dp[i-1][j-1]
	 * 2. c != d 三种可能性
	 * 若将c替换为d，则dp[i-1][j-1]+1
	 * 若是c后边加d，则需要把“somestr1c”编辑成“somestr2”，再加d，则dp[i][j-1] + 1
	 * 若是删除c，则需要把“somestr1”编辑成“somestr2d”，再删c，dp[i-1][j]+1
	 * 递推公式出来了：
			dp[i][j] =  dp[i-1][j-1]   if (A[i] == B[j])
           or = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) +1;
      初始条件： dp[0][j] = j and dp[i][0] = i 0的话就是从头build了
      Should be "Levenshtein distance"
	 * */
	
	
	
}
