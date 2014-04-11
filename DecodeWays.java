package Leetcode;

public class DecodeWays {
	/*
	 * DP: map[i] i represents the ways to decode until index i in String 
	 * 
	 * map[i]取决于map[i-1]:
	 * 	- V[i-1] > 2, map[i] = map[i-1]
	 *  - V[i-1] =2, map[i] 若是[1,6],map[i-1]+1，若是0 不变
	 *  - V[i-1] =1, map[i] +1
	 *  - V[i-1] = 0, map[i]若是0 得 return0 因为无解！ 否则不变
	 *  
	 * Initialize:
	 * map[0] = 1;
	 * preValue = s.charAt(0) - 'A' + 1;
	 * 
	 */
	 /* Update thinking:: 没考虑"110" 在最后加了个0，导致前一个字母失去了独立被解析的可能
	 * 			若不能被解析 “150” 即V[i-1] > 2 则return 0
	 * 			否则则需要减
	 * 	Update: 能与V[i-1]结合，则map[i] = map[i-1]+1
	 *         不能结合， 则map[i] = map[i-1] -1
	 *         若map[i] 小于0, 返回1。。。也不对，可能到此为止只有一种，但后边还会有自由度 “32921”
	 *  Wrong Conclusion: 这个思路是错的！！不能只变一端，得用二维数组！每个subarray都有自己的解法好吧！
	 */
	
	/**
	 * Update right solution:
	 * 
	 * 单独讨论如果V[i]==0;如果V[i-1] >2 则根本没人与V[i]结合，即0种，否则则是map[i] = map[i-2]因为它必须与上个数结合
	 * 
	 *  - V[i-1] > 2, map[i] = map[i-1]  map[i]只能自己独立存在，所以其可能性与map[i-1]相同 
	 *  关键点区别
	 *  - V[i-1] =2, map[i] 若是[1,6],！！！！！map[i] = map[i-1](i作为一个值独立存在)
	 *  												+map[i-2](i与i-1结合后，作为一个元素参与i-2之前的变化可能性)
	 *  					若》6，则=map[i-1]
	 *  - V[i-1] =1, map[i] 永远可以与i-1结合，即map[i] = map[i-1]+map[i-2]
	 *  - V[i-1] = 0, map[i]若是0 得 return0 因为无解！ 否则不变
	 *  
	 *  所以要initialize map[0]和map[1]
	 *  
	 *  Update: "301" 还是用if else 来写，别随便用？：
	 */
	 public int numDecodings(String s) {
	        if (s.equals("")) return 0;
	        if (Character.getNumericValue(s.charAt(0)) == 0) return 0;
	        if (s.length() == 1) return 1;
	        
	        // otherwise s should have at least two chars, and preValue is not 0
			int preValue = Character.getNumericValue(s.charAt(0));
			int[] map = new int[s.length()];
			map[0] = 1;
			if (Character.getNumericValue(s.charAt(1)) == 0) {
			    if (preValue <3) {
			        map[1] = 1;
			    } else {
			        return 0;
			    }
         // isn't 0
			} else if (Character.getNumericValue(s.charAt(1)) < 7){
			    if (preValue < 3) {
			        map[1] = 2;
			    } else {
			        map[1] = 1;
			    }
			} else {
			    if (preValue == 1){
			        map[1] = 2;
			    } else {
			        map[1] = 1;
			    }
			}
			
//	 		map[1] = (preValue == 1 && (Character
//	 				.getNumericValue(s.charAt(1)) != 0)|| (preValue == 2 && (Character
//	 				.getNumericValue(s.charAt(1)) < 7))) ? 2 : 1;
			preValue = Character.getNumericValue(s.charAt(1));

			for (int i = 2; i < map.length; i++) {
				int curValue = Character.getNumericValue(s.charAt(i));
				if (curValue == 0) {
					if (preValue > 2 || preValue == 0) { // can't combine with previous one
						return 0;
					}else {
						map[i] = map[i - 2];
					}
				// current value is no-zero
				} else {
					if (preValue > 2) {
						map[i] = map[i - 1];
					} else if (preValue == 2) {
						if (curValue > 6) {
							map[i] = map[i - 1];
						} else {
							map[i] = map[i-1]+map[i-2];
						}
					} else if (preValue == 1) {
						map[i] = map[i-1]+map[i-2];
					} else {  // preValue == 0 
					    map[i] = map[i-1];
					}
				}
				preValue = curValue;
			}
			return map[map.length - 1];
	    }
	/* 以下是被绕晕后试图重新再来，从一开始思路就错了
	 * 用二维数组来储存 map[i][j] store the possible divide from index i to j (i<=j)
	 * map[i][j] = if V(ij) > 26 only 1
	 * 				  V(ij) <= 26...
	 * Wrong Conclusion!: no rules when combine subarrays together
	 *  When check out solution online, my first intuition is much closer to the final result
	 * */
}
