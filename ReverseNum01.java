package Leetcode;
import java.util.LinkedList;
import java.util.Queue;


public class ReverseNum01 {
	
	public static void main(String[] args){
		System.out.println(reverse(0));
	}
	
	public static int reverse(int x) {
		boolean neg = false;
		if(x<0) {
			neg = true;
			x = -x;
		}
		long res =0;
		while(x!=0){
			res=res*10+x%10;
			x=x/10;
		}
		if(res>0x7fffffff) return 0;
		if(neg) res=-res;
		return (int)res;
    }
}
