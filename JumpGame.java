package Leetcode;

public class JumpGame {
	
	/*第二次做。 之前做的什么啊那么复杂。我新写的这个应该对路
	 * 思路是，record目前能跳到的最远距离。如果已经可以到达末尾，返回true
	 * 唯一不能到末尾的可能是最远跳到一个0，那么马上返回false*/
    public boolean canJump(int[] A) {
        int max = 0;
        for (int i=0; i<A.length-1; i++) {
            if (A[i] == 0 && i == max) return false;
            max = Math.max(max, i+A[i]);
            if (max >= A.length) return true;
        }
        return true;
    }
	
	
	/*牛逼！居然一次就通过了！！*/
//    public boolean canJump(int[] A) {
//        int index = A.length-2;
//        while (index >= 0) {
//            while(index >= 0 && A[index]>0) index--;
//            // A[index] == 0 here or index < 0
//            if (index < 0) return true;
//            // assert A[index] == 0 below
//            //assert index >= 0
//            if (index == 0) return false; // A[0] = 0 can't reach
//            // assert index > 0
//            // else
//            int jump = 2;
//            int index2 = index-1;
//            while (index2 >= 0 && A[index2] < jump){
//                index2--;
//                jump++;
//            }
//            if (index2 < 0) {
//                return false;
//            } else {
//                index = index2-1;
//            }
//        }
//        return true;
//    }
	
	
	/*错误的理解了题喂！人家说的是最大可jump数，意味着如果一个array都是正数，肯定能到终点
	 * 所以关键是找0*/
//    public boolean canJump(int[] A) {
//        int[] map = new int[A.length];
//        for (int i=0; i<map.length; i++){
//            map[i] = 0;
//        }
//        return helper(A, 0, map);
//    }
//    
//    private boolean helper (int[] A, int curIndex, int[] map){
//        if (curIndex == A.length - 1) return true;
//        if (map[curIndex] == -1) return false;
//        
//        boolean res = false;
//        int i=1;
//        while(curIndex + i < A.length && i <= A[curIndex]){
//            res |= helper(A, curIndex+i, map);
//            i++;
//            if (res) break;
//        }
//        if(!res) map[curIndex] = -1;
//        return res;
//    }
}
