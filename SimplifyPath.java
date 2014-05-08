package Leetcode;

import java.util.Stack;

public class SimplifyPath {
	public static final void main (String[] args){
		SimplifyPath t = new SimplifyPath();
		
		System.out.println(t.simplifyPath("/."));
	}
	
    /*
    read every / as a mark.
    if after that is a name, push that path name into the stack.
    if is a '.' do nothing
    if is '..' pop last string.
    
    corner cases:
    if stack is empty and '..' do nothing
    
    finally print everything with '/' seperate them
    */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        int i=0;
        while (i<path.length()){
            while (i < path.length() && path.charAt(i) == '/') i++;
            // if i = path.length() here, word would be "", do nothing and the loop end
            StringBuffer dir = new StringBuffer();
            while (i < path.length() && path.charAt(i) != '/'){
                dir.append(path.charAt(i++));
            }
            String word = dir.toString();
            if (word.equals(".") || word.equals("")){
                // do nothing but move to next /
            } else if (word.equals("..")){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(word);
            }
            i++;
        }
        String res = "";
        while(!stack.isEmpty()){
            res =  "/" + stack.pop() + res;
        }
        return res.equals("") ? "/" : res;
    }
}
