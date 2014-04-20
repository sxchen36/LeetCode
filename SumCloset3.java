package Leetcode;

import java.util.Arrays;

public class SumCloset3 {
	public static final void main(String[] args) {
		SumCloset3 t = new SumCloset3();
		int[] num = { 1, 1, -1 };
		System.out.print(t.threeSumClosest(num, 2));
	}
	


	/*
	 * Init thinking: 1. sort first cuz there is no need to keep the order for
	 * index 2. find the divide point between negative and positive number - if
	 * the three numbers includes negative, find the closest number in the
	 * array, the others two should sum up to close to 0 - if the three numbers
	 * are all positive, all three must smaller than target
	 * 
	 * 修修补补好半天，但觉得思路应该是错了。
	 * 
	 * 
	 * 看了别人的答案，发现还是乖乖地把第一个数从0数到length吧，剩下两个数的遍历可以有trick
	 * 基本也就是Brute force 了，O（N^3）
	 */
	
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = num[0]+num[1]+num[2];
        for (int i=0; i<num.length; i++) {
            int left = i+1;
            int right = num.length-1;
            while (left < right){
                int threeSum = num[i] + num[left] + num[right];
                if (threeSum == target) return target;
                
                if (threeSum > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(threeSum-target) < Math.abs(target - min)) min = threeSum;
            }
        }
        return min;
    }
	
	
	
//	public int threeSumClosest(int[] num, int target) {
//		Arrays.sort(num);
//		int tarIndex = BSF(num, target);
//
//		// find the divident point
//		int firstPos = 0;
//		while (firstPos < num.length && num[firstPos] < 0) {
//			firstPos++;
//		}
//		if (firstPos == 0) { // all positive
//			if (tarIndex < 3) {
//				return num[0] + num[1] + num[2];
//			} else {
//				return num[0] + num[1] + num[tarIndex];
//			}
//		} else if (firstPos == num.length) { // all negative
//			if (target > num.length - 3) {
//				return num[num.length - 1] + num[num.length - 2]
//						+ num[num.length - 3];
//			} else {
//				return num[num.length - 1] + num[num.length - 2]
//						+ num[tarIndex];
//			}
//		} else {
//			int neg = 0;
//			int pos = num.length - 1;
//			int minPosSum = num[num.length - 1] + num[num.length - 2]
//					+ num[num.length - 3];
//			int maxNagSum = num[0] + num[1] + num[2];
//			while (neg < firstPos && pos >= firstPos) {
//				if (neg == tarIndex) {
//					neg++;
//					continue;
//				} else if (pos == tarIndex) {
//					pos--;
//					continue;
//				}
//
//				int threeSum = num[neg] + num[pos] + num[tarIndex];
//				if (threeSum == target)
//					return threeSum; // sum will be the closest number
//
//				if (threeSum - target > 0) {
//					minPosSum = Math.min(threeSum, minPosSum);
//					pos--;
//				} else {
//					maxNagSum = Math.max(threeSum, maxNagSum);
//					neg++;
//				}
//			}
//			return (Math.abs(target - minPosSum) < target - maxNagSum) ? minPosSum
//					: maxNagSum;
//		}
//	}
//
//	// return the index of target if exist.
//	// return the index of the number that closest to target
//	private int BSF(int[] num, int target) {
//		int l = 0;
//		int r = num.length - 1;
//		while (l < r) {
//			int m = (l + r) / 2;
//			if (num[m] == target)
//				return m;
//
//			if (num[m] > target) {
//				r = m - 1;
//			} else {
//				l = m + 1;
//			}
//		}
//		if (num[l] < target) {
//			if (l == num.length - 1)
//				return l;
//			return (Math.abs(num[l] - target) < Math.abs(num[l + 1] - target)) ? l
//					: l + 1;
//		} else {
//			if (l == 0)
//				return 0;
//			return (Math.abs(num[l] - target) < Math.abs(num[l - 1] - target)) ? l
//					: l - 1;
//		}
//
//	}

}
