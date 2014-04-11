package Leetcode;
import java.util.Arrays;

public class SingleNumber {
	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 3, 2, 4, 4 };
		int result = singleNumber(A);
		System.out.println(A[result]);
	}

	public static int singleNumber(int[] A) {
		if (A.length == 1) // The edge condition I forgot in the first try
			return A[0];
		Arrays.sort(A);
		for (int i = 0; i < A.length - 1; i = i + 2) {
			if (A[i] - A[i + 1] != 0) {
				return A[i];
			}
		}
		return A[A.length - 1];
	}
}
