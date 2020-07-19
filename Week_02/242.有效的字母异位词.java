import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start

// 1. clarification 弄清楚问题  
// 2. possible solutions -> optimal (time & space)  可能的解法
// 3. code 
// 4. test cases

// 1. 暴力法 排序 然后比较 s和sorted(s) 是否相等O(nlogn)
// class Solution{
//     public boolean isAnagram(String s, String t) {
//         // 如果长度不等，则不是变位词
//         if (s.length() != t.length()) {
//             return false;
//         }
//         // 把字符串转换为字符数组
//         char [] str1 = s.toCharArray();
//         char [] str2 = t.toCharArray();
//         // 字符数组排序
//         Arrays.sort(str1);
//         Arrays.sort(str2);
//         // 判断是否相等
//         return Arrays.equals(str1, str2);
//     }
// }

// 复杂度分析
// 时间复杂度 排序O(nlogn) 
// 空间复杂度 如果是heapsort则为O(1)  java字符串转数组需要O(n)

// 2. hash, map --> 统计每个字符的频数
// 用一个计数器来统计字符串s和t中字符出现的频率 
// 在s中出现+1 在t中出现-1 若最后都为0 则说明t是s的重新排列

// class Solution{
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }
//         // 声明一个26位的计数器表 来记录每个字符出现的频次
//         int[] counter = new int[26];
//         // 遍历长度相等的两字符串
//         for (int i=0; i < s.length() ;i++) {
//             // 得到索引为i的字符的频次计算， 在s中+1, 在t中-1
//             counter[s.charAt(i) - 'a']++;
//             counter[t.charAt(i) - 'a']--;
//         }
//         // 遍历处理后的counter数组 增强for循环
//         for (int count : counter) {
//             if (count != 0) {
//                 return false;
//             }
//         }
//         // 若counter数组全部为零
//         return true;
//     }
// }


// 3 先用计数器表计算s，然后用t减少计数器表中的每个字母的计数器。
// 如果在任何时候计数器低于0， 我们知道t包含一个不再s中的字母，并立即返回false
class Solution{
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 声明字符计数器数组
        int[] counter = new int[26];
        for (int i=0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++; 
        }
        for (int i=0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

// 复杂度分析
// 时间复杂度 O(N)
// 空间复杂度 O(1)

// @lc code=end

