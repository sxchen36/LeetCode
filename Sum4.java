package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*AC for once. Share the same idea as Sum3. O(N^3)*/
public class Sum4 {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i=0; i<num.length - 3; i++) {
            int sum3 = target - num[i];
            for (int j=i+1; j<num.length-2; j++) {
                int sum2 = sum3 - num[j];
                int left = j+1;
                int right = num.length-1;
                while (left < right) {
                    if (num[left] + num[right] == sum2) {
                        ArrayList<Integer> ele = new ArrayList<Integer>();
                        ele.add(num[i]);
                        ele.add(num[j]);
                        ele.add(num[left]);
                        ele.add(num[right]);
                        set.add(ele);
                        left++;
                        right--;
                    } else if (num[left] + num[right] < sum2) {
                        left++;
                        while (left < right && num[left] == num[left-1]) left++;
                    } else {
                        right --;
                        while (right > left && num[right] == num[right+1]) right--;
                    }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(set);
    }
}
