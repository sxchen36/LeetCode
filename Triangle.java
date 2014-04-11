package Leetcode;
import java.util.ArrayList;


public class Triangle {
//	/*TLE 1st try, DFS. Failed*/
//    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//        return minUntil(0, triangle, 0);
//    }
//    
//    private int minUntil(int index, ArrayList<ArrayList<Integer>> triangle, int level) {
//        if (level == triangle.size()) {
//            return 0;
//        }
//        ArrayList<Integer> cur = triangle.get(level);
//        int tmp1 = minUntil(index, triangle, level+1);
//        int tmp2 = minUntil(index+1, triangle, level+1);
//        return Math.min(tmp1, tmp2) + cur.get(index);
//    }
	
    /**
     * DP: map[i][j] smallest path sum to get here (include current location)
     * i is level i (0~length-1), j is index in that level(0~length-1)
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.get(0) == null) return 0;
        int rows = triangle.size();
        int[][] map = new int[rows][rows];
        
        //Initialize
        map[0][0] = triangle.get(0).get(0);
        for (int i = 1; i< rows; i++){
            map[i][0] = map[i-1][0] + triangle.get(i).get(0);
        }
        
        for (int i=1; i<rows; i++){
            for (int j=1; j<i+1; j++){
                if (j == i){ //  last number in this row, only compare to upperleft map[][]
                    map[i][j] = map[i-1][j-1] + triangle.get(i).get(j); 
                } else {
                    map[i][j] = Math.min(map[i-1][j-1], map[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<rows; i++){
            if (map[rows-1][i] < min) min = map[rows-1][i];
        }
        return min;
    }
}
