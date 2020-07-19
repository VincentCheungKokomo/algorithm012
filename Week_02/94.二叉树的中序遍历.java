import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {val = x;}
 }

 // 递归
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//          // 返回的遍历结果 初始化为空列表
//         List <Integer> res = new ArrayList<>();
//         helper(root, res);
//         return res;
//     }

//     public void helper(TreeNode root, List<Integer> res) {
//         if (root != null) {
//             // 递归遍历左子树
//             if (root.left != null) {
//                 helper(root.left, res);
//             }
//             // 访问根节点
//             res.add(root.val);
//             // 递归遍历右子树
//             if (root.right != null) {
//                 helper(root.right, res);
//             }
//         }
//     }
// }


// 利用栈来模仿递归的过程
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        TreeNode curr = root; // 记录当前访问节点
        // 若根节点存在 且 栈不空 则继续遍历
        while (curr != null || !stack.isEmpty()) {
            // 若根节点存在 则一直遍历其左子树 直到访问到叶子节点结束
            while (curr != null) {
                stack.push(curr); // 当前节点入栈
                curr = curr.left; // 左子树根节点入栈
            }
            // 若无左子树 则访问其父节点 并出栈
            curr = stack.pop(); 
            res.add(curr.val);
            // 访问当前节点的右子树
            curr = curr.right;
        }
        return res;
    }
}
// 时间复杂度 O(n)
// 空间复杂度 O(n)

 




// @lc code=end

