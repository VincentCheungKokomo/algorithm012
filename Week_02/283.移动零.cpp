/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
public:
    int j = 0; // 非零元素待插入位置
    void moveZeroes(vector<int>& nums) {
        for(int i=0; i<nums.size(); i++){
            if(nums[i] != 0){
                num[j] = num[i]; // 移动非零元素
                if(i!=j){ // 代表之前有0元素
                    nums[i] = 0;
                }
                j++; 
            }
        }
    }
};
// @lc code=end

