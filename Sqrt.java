package Leetcode;

public class Sqrt {
	public final static void main(String[] args){
		Sqrt s = new Sqrt();
		s.sqrt(2147395599);
	}
	/**
	 * AC
	 * 用mid = x/mid 防止溢出
	 * r-l>1 确保mid>0
	 */
    public int sqrt(int x) {
        if(x<=1) return x;
        
        int l = 0;
        int r = x;
        while (r-l > 1){ // to ensure that mid != 0
            int mid = (r+l)/2; 
            if (mid == x/mid) return mid;
            if( mid > x/mid) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
