package Leetcode;
import java.util.Arrays;


public class NextPermutation {
	public final static void main(String[] args) {
		int[] num = {1,3,2};
		NextPermutation t = new NextPermutation();
		t.nextPermutation(num);
		for (int i =0; i< num.length; i++){
			System.out.print(num[i] + " ");
		}
	}
	
	
    /* AC
     * From the lowest digit scan, find the smallest number that larger than cur before it. if not, move forward
    if nothing found until the highest digit, return the sorted version
    O(N^2)*/
	/*Update
	 * after swap should ensure the substring is in ascending order*/
    public void nextPermutation(int[] num) {
        for (int i=num.length - 1; i>=0; i--) {
            int minLarge = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i+1; j <= num.length - 1; j++){
//                if (num[j] < minLarge && num[j] > num[i]) {
//                    index = j;
//                    minLarge = num[j];
//                }
            	// Optimal solution because all digits after i is in descending order
                if (num[j] > num[i]) {
                    index = j;
                    minLarge = num[j];
                    break;
                }
            }
            if (index != -1) {
                swap(num, index, i);
                quicksort(num, i+1, num.length-1);
                return;
            }
        }
        Arrays.sort(num);
    }
        
    private void swap(int[] num, int a, int b){
                int tmp = num[a];
                num[a] = num[b];
                num[b] = tmp;
    }
    
    private void quicksort(int[] num, int l, int r) {
        if (l >= r) return;
        int pivolt = num[r];
        int p = l;
        for (int i=l; i<=r-1; i++){
            if (num[i] <= pivolt) {
                swap (num, p, i);
                p++;
            }
        }
        swap(num, p, r);
        quicksort(num, l, p-1);
        quicksort(num, p+1, r);
    }
    
	

	/* should choose the smallest one and switch
	 * [1,3,2] -> [2,1,3]
	 * Wrong! [2,3,1] -> [3,1,2]*/
	
//    public void nextPermutation(int[] num) {
//        for (int i = num.length - 2; i>=0; i--) {
//            if (num[i] < num[i+1]) { // first occurance that num[i] < num[i+1], mean previous num[i] >= num[i+1], the last one is the smallest
//                swap(num, i, num.length-1);
//                // resort the substring as ascending order
//                int p = num.length-1;
//                while (p-1 > i && num[p] < num[p-1]){ // bubble the swapped number to right place
//                    swap(num, p, p-1); 
//                    p--;
//                }
//                //assert [i+1, num.length-1] descending order
//                for (int j=0; j<=(num.length-1 - (i+1) + 1)/2; j++) {
//                    swap(num, i+1+j, num.length-1-j);
//                }
//                return;
//            }
//        }
//        Arrays.sort(num);
//    }
//    
//    private void swap(int[] num, int a, int b){
//                int tmp = num[a];
//                num[a] = num[b];
//                num[b] = tmp;
//    }
	
	/* Wrong! Can't just swap two adjacent neighbor. should choose the smallest one and switch
	 * [1,3,2] -> [2,1,3]*/
//    public void nextPermutation(int[] num) {
//        for (int i = num.length - 2; i>=0; i--) {
//            if (num[i] < num[i+1]) {
//                int tmp = num[i];
//                num[i] = num[i+1];
//                num[i+1] = tmp;
//                return;
//            }
//        }
//        Arrays.sort(num);
//    }
}
