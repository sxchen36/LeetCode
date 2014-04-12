package Leetcode;

public class ContainMostWater {
	/*AC. 
	 * 1. 只有两种情况，left短，那么就找更长的left， right短，那么就找更长的right */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int vol = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            vol = Math.max(vol, h*(right-left)); 
            if (height[left] < height[right]) { // Trick!!!
                left++;
            } else {
                right--;
            }
        }
        return vol;
    }
}
