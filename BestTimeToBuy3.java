package Leetcode;

public class BestTimeToBuy3 {
	public static final void main(String[] args){
		int[] a = {2,1,2,0,1};
		System.out.println(maxProfit(a));
	}
//    /*Wrong! My intuition by the hint from others (but not copy)
//    1.find the bottom day i and the peak day j, if only one transaction, it must be (i,j)
//    2.Then we can prove that if there are two transactions, i and j must be one of the start and end day
//        Prove: if i is not start, we have (i',j') and (i'',j''), then j' j'' must before i, otherwise since i is the bottom,
//                (i,j') will be larger than (i',j')/(i'',j''). But if (i',j')(i'',j'') in the range before i, then (i,j) should         
//                replace one of them as the largest profit. We can prove same for j
//    3. Thus there are only four options: 
//        1/ (i',j')+(i,j)  
//        2/ (i,j') + (i'',j)
//        3/ (i,j) + (i',j')
//        4/ (i,j) is the max
//    4. We use first problem's algorithm to find them and return the max*/
//	
//	/* I still  like this logic but I can't figure out the stop condition*/
//    public static int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        return maxProfitHelper(prices, 0, prices.length-1);
//    }
//    
//    private static int maxProfitHelper(int[] prices, int l, int r){
//    	/* I still  like this logic but I can't figure out the stop condition*/
////        boolean stop = true;
////        for (int i = l+1; i<r+1; i++){
////        	if (prices[i]-prices[i-1] < 0) stop = false;
////        }
////        if(stop) return Math.max(0,prices[r]-prices[l]);
//        
//        //find bottom and peak;
//        int bottom = 0;
//        int peak = 0;
//        int max = 0;
//        for (int i=l; i<r+1; i++){
//            if(prices[bottom] > prices[i]) {
//                bottom = i;
//            } else {
//                max = Math.max(max, prices[i]-prices[bottom]);
//                if (max == prices[i] - prices[bottom]) {
//                    peak = i;
//                }
//            }
//        }
//        int beforeBottom = (bottom == l) ? 0:partialMax(prices, l, bottom-1);
//        int afterPeak = (peak == r) ? 0:partialMax(prices, peak+1, r);
//        int middleDivide = maxProfitHelper(prices, bottom, peak);
//        return Math.max(Math.max(beforeBottom+max,max+afterPeak), middleDivide);
//    }
//    
//    private static int partialMax(int[] prices, int l, int r){
//        int max = 0;
//        int bottom = l;
//        for (int i=l; i<r+1; i++) {
//            if (prices[bottom] > prices[i]) {
//                bottom = i;
//            } else {
//                max = Math.max(max, prices[i]-prices[bottom]);
//            }
//        }
//        return max;
//    }
	
	/*Second try by hints from http://oj.leetcode.com/discuss/1381/any-solutions-better-than-o-n-2
	 * Idea: try each number as the split point, calculate the before max and after max, sum them
	 * compared to the maxValue, and return
	 * By storing both before and after max in two array, we can complete the whole process in O(n)*/
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int result_max = 0;
        int[] preMax = new int[prices.length];
        int[] afterMax = new int[prices.length];
        // The max with the array ending with i
        int min = 0;
        for (int i=0; i<prices.length; i++){
            if(i==0) {
                preMax[i] = 0;
            } else {
                if(prices[i] < prices[min]) {
                    min = i;
                }
                    preMax[i] = Math.max(prices[i]-min, preMax[i-1]);

            }
        }
        int max = prices.length-1;
        for (int i=prices.length-1; i>=0; i--){
            if (i == prices.length-1) {
                afterMax[i] = 0;
            } else {
                if(prices[i] > prices[max]) {
                    max = i;
                }
                    afterMax[i] = Math.max(afterMax[i+1],prices[max] - prices[i]);
             
            }
        }
        
        //calculate the sum
        for (int i=0; i<preMax.length; i++){
            result_max = Math.max(result_max,preMax[i]+ afterMax[i]);
        }
        return result_max;
    }


























}
