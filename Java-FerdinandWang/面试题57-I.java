/*
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题57 和为s的两个数
 * 题目链接:https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
*/

// 本题采用双指针的思路
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int i = 0;
        int j = nums.length - 1;
        //i、j指针分别从数组的左右两端出发
        while(i < j){
            // 求和
            int sum = nums[i] + nums[j];
            //左边指针右移一位
            if(sum < target){
                i++;

            // 右边指针左移一位
            }else if(sum > target){
                j--;
            }else{
                // 找到相等的则直接返回
                return new int[]{nums[i], nums[j]};
            }
        }

        return new int[0];
    }
}