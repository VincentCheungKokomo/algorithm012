import java.util.HashMap;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start

// 方法1 暴力法
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // 双重遍历
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = 0; j < nums.length; j++) {
//                 if (nums[i] + nums [j] == target) {
//                     return new int [] {i, j};
//                 }
//             }
//         }
//         throw new IllegalArgumentException("No two sum solution");
//     }
// }

// 时间复杂度 O(n^2)
// 空间复杂度 O(1)

// 方法2 哈希表 
// 利用哈希表把查找的时间复杂度降为O(1)
// map <x, target - x>
// 两遍哈希
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             map.put(nums[i], i); // 把元素放入哈希表map value -> index
//         }
//         // 判断target - nums[i] 是否在哈希表map中
//         for (int i = 0; i < nums.length; i++) {
//             // 与目标的差值
//             int complement = target - nums[i]; 
//             if (map.containsKey(complement) && map.get(complement) != i) {
//                 // 返回符合条件的下标
//                 return new int[] {i, map.get(complement)}; 
//             }
//         }
//         throw new IllegalArgumentException("No two sum solution");
//     }
// }


// 方法3 一遍哈希
class Solution {
    public int [] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); 
        // 建立哈希表的同时， 判断其是否存在符合条件的元素， 并返回其下标
        for (int i = 0; i < nums.length; i++) {
            int complement  = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i); // 建立hash表
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


// @lc code=end

