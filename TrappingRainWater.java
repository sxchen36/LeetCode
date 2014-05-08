package Leetcode;

public class TrappingRainWater {
	
	public static void main(String[] args) {
		TrappingRainWater w = new TrappingRainWater();
		int[] A = {4,2,3};
		System.out.println(w.trap(A));
	}

	/*
	 * scan the array, for A[i] if A[i+j] < A[i], use A[i] as the unchanged
	 * edge, calculate their difference, add to the sum keep going until reach
	 * meet a A[i+j] that greater than A[i] Wrong: when A[i] is the tallest bay
	 * then it fails
	 * 
	 * Update: 1. Use whole area - block to calculate trap rain is easy 2. scan
	 * the array is not wrong. record the tallest bay and then scan again from
	 * right side
	 */
	public int trap(int[] A) {
		int left = 0;
		int sum = 0;
		int block = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= A[left]) {
				sum += A[left] * (i - left - 1);
				sum -= block;
				block = 0;
				left = i;
			} else {
				block += A[i];
			}
		}

		block = 0;
		// left is the index of the tallest bay in the array
		int right = A.length - 1;
		for (int i = A.length - 2; i >= left; i--) {
			if (A[i] >= A[right]) {
				sum += A[right] * (right - i - 1);
				sum -= block;
				block = 0;
				right = i;
			} else {
				block += A[i];
			}
		}
		return sum;
	}
}
