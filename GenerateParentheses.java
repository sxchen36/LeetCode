package Leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class GenerateParentheses {
    // Similar to BFS. If use DFS, then pass String preString as a para in recursion
    /* 但仍然不够理想 用Set就代表可能有重复*/
    /*DFS重复的太多次了，会Time out的，因为从（）往上build的话每个位置都要试，不像BFS只在‘（’后边加就好了*/
	
//    public ArrayList<String> generateParenthesis(int n) {
//        Set<String> set = generateHelper(n);
//        return new ArrayList<String>(set);
//    }


//    private Set<String> generateHelper(int n) {
//        if (n == 1) {
//            Set<String> set = new HashSet<String>();
//            set.add("()");
//            return set;
//        }
//        Set<String> preset = generateHelper(n-1);
//        Set<String> set = new HashSet<String>();
//        for (String ele : preset){
//            for (int i=0; i<ele.length(); i++){
//                if (ele.charAt(i) == '('){
//                    String tmp = ele.substring(0,i+1) + "()"+ele.substring(i+1);
//                    set.add(tmp);
//                }
//            }
//            String tmp = ele+"()";
//            set.add(tmp);
//        }
//        return set;
//    }
	
	
    /*Build from scratch*/
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n,n,res,"");
        return res;
    }
    
    private void helper(int ln, int rn, List<String> res, String pre) {
        if (ln == 0 && rn == 0) {
            res.add(new String(pre));
        } else if (ln > rn || ln < 0 || rn < 0) {
            return;
        }else {
            if (ln > 0) {
                String tmp = pre+"(";
                helper(ln-1, rn, res, tmp);
            }

            if (ln < rn) {
                String tmp = pre+")";
                helper(ln, rn-1, res, tmp);
            }
        }
    }
}
