package Leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        Set<String> set = generateHelper(n);
        return new ArrayList<String>(set);
    }
    // Similar to BFS. If use DFS, then pass String preString as a para in recursion
    private Set<String> generateHelper(int n) {
        if (n == 1) {
            Set<String> set = new HashSet<String>();
            set.add("()");
            return set;
        }
        Set<String> preset = generateHelper(n-1);
        Set<String> set = new HashSet<String>();
        for (String ele : preset){
            for (int i=0; i<ele.length(); i++){
                if (ele.charAt(i) == '('){
                    String tmp = ele.substring(0,i+1) + "()"+ele.substring(i+1);
                    set.add(tmp);
                }
            }
            String tmp = ele+"()";
            set.add(tmp);
        }
        return set;
    }
}
