import java.util.ArrayDeque;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         // 方法1 暴力法 直接遍历每个滑动窗口，找到每个窗口的最大值。
//         // 一共有n-k+1个滑动窗口，每个有k个元素，于是算法复杂度为O(NK),表现较差
//         int n = nums.length;
//         if (n * k == 0) return new int[0];
//         int [] output = new int[n - k + 1]; // 窗口的个数
//         for (int i = 0; i < n - k + 1; i++) {
//             int max = Integer.MIN_VALUE;
//             for (int j = i; j < i + k; j++) {
//                 max = Math.max(max, nums[j]);
//             }
//             output[i] = max;
//         } 
//         return output;
//     }
// }
// 时间复杂度 O(NK) ，其中N为数组中元素的个数
// 空间复杂度 O(N-K+1), 用于输出数组

// 方法2 双端队列
// 处理前k个元素，初始化双端队列
// 遍历整个数组，在每一步：清理双向队列：
// 只保留当前滑动窗口中有的元素索引
// 移除比当前元素小的所有元素，他们不可能是最大的
// 将当前元素添加到双端队列中
// 将deque[0]添加到输出中
// 返回输出数组

// class Solution {
//     // 声明双端队列
//     ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
//     int [] nums;

//     public void clean_deque(int i, int k) {
//         // remove indexes of elements not from sliding window
//         if (!deq.isEmpty() && deq.getFirst() == i - k) 
//             deq.removeFirst();
        
//         // remove from deq indexes of all elements
//         // which are smaller than current elements nums[i]
//         while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) 
//             deq.removeLast();
//     }

//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         if (n * k == 0) return new int[0];
//         if (k == 1) return nums;

//         // init deque and output
//         this.nums = nums;
//         int max_idx = 0;
//         for (int i = 0; i < k; i++) {
//             clean_deque(i, k); // 清理deq中第一个元素
//             deq.addLast(i); // 往deq添加一个元素
//             // compute max in nums[:k]
//             if (nums[i] > nums[max_idx]) max_idx = i;
//         }

//         int [] output = new int[n - k + 1];
//         output[0] = nums[max_idx];

//         // build output
//         for (int i = k; i < n; i++) {
//             clean_deque(i, k);
//             deq.addLast(i);
//             output[i - k +1] = nums[deq.getFirst()];
//         }
//         return output;
//     } 
// }


// 方法3
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1]; // number of windows
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < n; ++i) {
            int start = i - k;
            if (start >= 0) {
                maxPQ.remove(nums[start]);
            }
            maxPQ.offer(nums[i]);
            if (maxPQ.size() == k) { 
                result[i - k + 1] = maxPQ.peek(); // 窗口内的最大值
            }
        }
        return result;
    }
}
// @lc code=end

