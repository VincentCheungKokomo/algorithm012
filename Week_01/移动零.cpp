class Solution {
    public:
    // 非零元素待插入位置
    void moveZeroes(vector<int>& nums) {
        int j = 0;  // 非零元素待插入位置
        for(int i=0; i<nums.size(); i++){
            if(nums[i] != 0){
                nums[j] = nums[i]; // 移动非零元素
                if(i!=j){ // 代表之前有0元素
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
};