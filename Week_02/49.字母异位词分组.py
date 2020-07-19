#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
# 方法1 排序数组分类 
# 将键存储为散列化元组
# strs = ['are', 'bat', 'ear', 'code', 'tab', 'era']

# ans = {
#     ('a', 'e', 'r'): ['are', 'ear', 'era'],
#     ('a', 'b', 't'): ['bat', 'tab'],
#     ('c', 'd', 'e', 'o'): ['code']
# }

# class Solution:
#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
#         # 一种特殊类型的字典本身就保存了默认值defaultdict()，
#         # defaultdict类的初始化函数接受一个类型作为参数，
#         # 当所访问的键不存在的时候，可以实例化一个值作为默认值。
#         ans = collections.defaultdict(list)
#         for s in strs:
#             # 返回一个可迭代对象中以ascii码排好序的列表
#             # tuple不可变 ['a', 'e', 'r'] -> ('a', 'e', 'r')
#             ans[tuple(sorted(s))].append(s)
#         return ans.values()

# 方法2 按计数分类
class Solution:
    def groupAnagrams(strs):
        ans = collections.getdefaultdict(list)
        for s in strs: # 遍历字符串数组
            count = [0] * 26 
            for c in s: # 遍历单个字符串
                count[ord(c) - ord('a')] += 1 # 更新count数组
            ans[tuple(count)].append(s)
        return ans.values()


# @lc code=end

