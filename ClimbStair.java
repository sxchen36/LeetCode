package Leetcode;

public class ClimbStair {
	/*简单的斐波那契数列嘛………………直接一个array就存了*/
    public int climbStairs(int n) {
        int[] ways = new int[n];
        if (n == 1 || n == 0) return 1; 
        ways[0] = 1;
        ways[1] = 2;
        for (int i=2; i<ways.length; i++){
            ways[i] = ways[i-1]+ ways[i-2];
        }
        return ways[n-1];
    }
	
	/* 注意ways的index是“在第几层”，初始化时别忘了ways[0] = 0*/
//    public int climbStairs(int n) {
//        int[] ways = new int[n+1];
//        for (int i=0; i<ways.length; i++){
//            ways[i] = -1;
//        }
//        ways[0] = 1;
//        ways[1] = 1;
//        return helper(ways, n);
//    }
//    
//    private int helper(int[] ways, int curStep) {
//        if (curStep < 0) return 0;
//        if (ways[curStep] > 0) return ways[curStep];
//        
//        ways[curStep] = helper(ways, curStep-1) + helper(ways, curStep-2);
//        return ways[curStep];
//    }
}
