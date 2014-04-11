package Leetcode;
import java.util.LinkedList;
import java.util.Queue;


public class ReverseNum {
	public int reverse(int x) {
        if(x==0) return 0;
        int sign = x>0? 1:-1;
        x = x*sign;
        Queue<Integer> queue = new LinkedList<Integer>();
        while(x!=0){
            queue.add(x%10);
            x = x/10;
        }
        int result=0;
        while(queue.peek()!=null){
            result = result*10 + queue.poll();
        }
        return result*sign;
    }
}
