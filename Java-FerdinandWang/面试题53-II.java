/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题53-II 在排序数组中查找数字 II
 * 题目链接:https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
*/
//本题目的主要思路是用二分法（大多数排序数组的题目都可以用二分法的思路）
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        // 二分法核心代码
        // 找到nums[m] != m 的那个数
        while(i <= j){
            int m = (i + j) / 2;
            if(m == nums[m]){
                i = m + 1;
            }else{
                j = m - 1;
            }
        }
        
        // 此时i、j、m 都相等
        return i;
    }
}