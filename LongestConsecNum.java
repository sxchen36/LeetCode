package Leetcode;
import java.util.HashSet;
import java.util.Set;


public class LongestConsecNum {
    /*Use HashSet to keep the search operation in O(1) for a sane Hash function
     * The key is one number could only be in one consecutive sequence once
     * Thus once we create a consecutive sequence, we can remove all the elements in it
     * from the set. That guarantees we visit each number only once */
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i< num.length; i++){
            set.add(num[i]);
        }
        int max = 1;
                    int i = 0;
        while(!set.isEmpty()){
            int count = 1;
            int cur = num[i]+1;
            while(set.contains(cur)){
                count++;
                set.remove(cur);
                cur++;

            }
            cur = num[i]-1;
            while (set.contains(cur)){
                count++;
                set.remove(cur);
                cur--;

            }
            if (count > max) max = count;
            set.remove(num[i]);
                        i++;
        }
        return max;
    }
}
