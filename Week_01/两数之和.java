// 时间复杂度分析  O(n^2)
// 空间复杂度 O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        int numsSize = nums.length;
        for(int i = 0; i < numsSize - 1; i++) {
            for (int j = i+1; j < numsSize; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return new int[0]; // 长度为0的数组，不是null
    }
}