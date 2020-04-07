/*
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题61 扑克牌中的顺子
 * 题目链接:https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
*/

// 本题目的主要思路是 利用最大值-最小值<5
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums); //排序
        int res = 0;
        for(int i = 0; i < 4; i++){
            if(nums[i] == 0) continue;   //如果为0,则是大王,直接跳过此次循环,也可以改成差＋0
            if(nums[i] == nums[i + 1]) return false; //如果两个数字相等则直接跳过
            
            res = res + (nums[i+1] - nums[i]);
        }
        return res < 5;
    }
}