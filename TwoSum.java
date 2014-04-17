package Leetcode;

import java.util.Arrays;

public class TwoSum {
    /*Brute force should be O(N^2) worse case*/
    /*Use sort and binary search O(NlogN)
     * Wrong!!!
     * Update: should not sort cuz you are suppose to return index dude!!*/
	
	/* The thing is, if you don't sort it and 
	you wanna search for two sum in their original index, you have to do it O(N^2) or HashMap, which takes O(N) space
	So I just search the two number and then get their location. It still will be O(NlogN)*/
	
	/* 还是不行。1.不能保证哪个前哪个后 2. 如果两个重复的数字，则返回值是一样的。不能这么干*/
	/* 但查了之后发现，就得这么干，先sort一遍。但sort之后用前后加的方法~最多O(N/2)
	 * 
	 * Arrays.sort() 用的是dual pivot quick sort. if I wrote quick sort by myself, it will TLE.
	 * Dual pivot quick sort 挺有意思的*/
	
	public final static void main(String[] args) {
		TwoSum t = new TwoSum();
		int[] numbers = {3,2,4};
		//t.twoSum(numbers, 6);
	}
	
	
	//2
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        
        // find the two numbers
        int[] copy = numbers.clone();
        Arrays.sort(copy);
        int l = 0;
        int r = copy.length - 1;
        while (copy[l] + copy[r] != target){
            int sum = copy[l] + copy[r];
            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        
        // locate the two numbers in numbers[]. from front and end in case there are two same numbers
        for (int i=0; i< numbers.length; i++) {
            if(numbers[i] == copy[l]) {
                res[0] = i+1;
                break;
            }
        }
        for (int i=numbers.length-1; i>=0; i--) {
            if (numbers[i] == copy[r]) {
                res[1] = i+1;
                break;
            }
        }
        
        //check whether the two index are inorder
        if(res[0] > res[1]) {
            int tmp = res[0];
            res[0] = res[1];
            res[1] = tmp;
        }
        return res;
    }
	
	
	//1
//    public int[] twoSum(int[] numbers, int target) {
//        int[] res = new int[2];
//        Arrays.sort(numbers);
//        for(int i=0; i<numbers.length-1; i++) {
//            int t = target - numbers[i];
//            int index2 = binarySearch(numbers, i+1, numbers.length-1, t);
//            if (index2 > 0) {
//                res[0] = i+1;
//                res[1] = index2+1;
//                return res;
//            }
//        }
//        return res;
//    }
//    
//    private int binarySearch(int[] numbers, int l, int r, int target) {
//        while (l < r) {
//            int m = (l + r) / 2;
//            if (numbers[m] == target) return m;
//            
//            if (numbers[m] < target) {
//                l = m + 1;
//            } else {
//                r = m - 1;
//            }
//        }
//        
//        if (numbers[l] == target) return l;
//        return -1;
//    }
	
	//0 brute force
//    public int[] twoSum(int[] numbers, int target) {
//        int[] res = new int[2];
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i; j < numbers.length ; j++) {
//                if (numbers[i] + numbers[j] == target) {
//                    res[0] = i+1;
//                    res[1] = j+1;
//                    return res;
//                }
//            }
//        }
//        return res;
//    }
}
