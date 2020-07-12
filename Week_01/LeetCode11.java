
public class LeetCode11 {
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		maxArea(height);
	}
	

	/**
	 * 双指针法
	 * @param height
	 * @return
	 */
	public static int maxArea2(int[] height) {
		int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
	
	/**
	 * 暴力法
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int max = 0;
        for(int i = 0; i < height.length - 1; i++) {
        	for(int j = i + 1; j < height.length; j++) {
        		int area = (j - i) * Math.min(height[i],height[j]);
        		max = Math.max(max, area);
        	}
        }
        return max;
    }
}
