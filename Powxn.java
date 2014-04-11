package Leetcode;

public class Powxn {
	public static final void main(String[] args){
		Powxn x = new Powxn();
		System.out.println(x.pow(1.00000, -2147483648));
	}
	    public double pow(double x, int n) {
	        if (n == 0) return 1;
	        int exp = (n>0) ? n:-n;
            double res = (exp%2 == 0) ? pow(x*x, exp/2) : pow(x*x,exp/2)*x;
	        return (n<0)? 1/res : res;
	    }

}
