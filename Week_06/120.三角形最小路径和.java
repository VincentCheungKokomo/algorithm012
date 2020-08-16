// import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         // 解法1: 递归 
//         return dfs(triangle, 0, 0);
//     }

//     // 暴力搜索
//     private int dfs(List<List<Integer>> triangle, int i, int j) {
//         if (i == triangle.size()) { // 到达底部位置
//             return 0;
//         }
//         return Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
//     }
// }

// 解法2 递归 + 记忆化   
// class Solution {
//     Integer[][] memo;
//     public int mininumTotal(List<List<Integer>> triangle) {
//         memo = new Integer[triangle.size()][triangle.size()];
//         return dfs(triangle, 0, 0);  // 自顶向下
//     }

//     private int dfs(List<List<Integer>> triangle, int i, int j) {
//         if (i == triangle.size()) {
//             return 0;
//         }
//         if (memo[i][j] != null) {
//             return memo[i][j]; // 记忆数组
//         }
//         return Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
//     }
// }


// 解法3 动态规划  自底向上

// class Solution {
//     public int mininumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         // 1. 状态定义  dp[i][j]表示从点(i, j)到底边到最小路径和
//         int[][] dp = new int[n+1][n+1]; // 不需要这么多空间
        
//         // 从三角形到最后一行开始递推
//         for (int i = n-1; i >= 0; i--) {
//             for (int j = 0; j <= i; j++) { // 只需考虑与其相关到两个位置的元素
//                 dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
//             }
//         }
//         return dp[0][0];
//     }
// }


// 空间优化
class Solution {
    public int mininumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 1. 状态定义  dp[i][j]表示从点(i, j)到底边到最小路径和
        int[] dp = new int[n+1]; 

        // 从三角形到最后一行开始递推
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) { // 只需考虑与其相关到两个位置的元素
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
// 1. brute-force， 递归， n层 left or right O(2^n)
// 2. DP
    // a. 重复性 (分治) problem(i, j) = min(sub(i+1, j), sub(i+1, j+1)) + a[i, j]
    // b. 定义状态数组  f[i, j]
    // c. DP方程 f[i, j] = min(f[i+1, j], f[i+1, j+1]) + a[i, j]


// @lc code=end

