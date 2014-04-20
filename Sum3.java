package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sum3 {
    /*//1 brute force. choose each char as the first number, then sum the rest of two
     * O(N^2) is the best
     * 
     * Some people post on Leetcode:
     * a lower bound of Ω(n^ceil(k/2)) for the k-SUM problem (deciding whether k numbers out of n sums to 0)
     *  where ceil is the ceiling function. Here k=3, so you cannot do better than Ω(n^2).
     * */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        for (int i=0; i<num.length-2 && num[i] <= 0; i++) { // cuz when num[i] > 0, there is no way that these three can sum up to zero
            int target = -num[i];
            int left = i+1;
            int right = num.length-1;
            while (left < right) {
                if (num[left] + num[right] == target) {
                    ArrayList<Integer> ele = new ArrayList<Integer>();
                    ele.add(num[i]);
                    ele.add(num[left]);
                    ele.add(num[right]);
                    res.add(ele);
                    left++;
                    right--;
                } else if (num[left] + num[right] < target) {
                    left++;
                    while(left < num.length && num[left] == num[left-1]) left++; // exclude the duplicate value;
                } else {
                    right--;
                    while(right >= 0 && num[right] == num[right+1]) right--;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(res);
    }
}
