/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题03 数组中重复的数字
 * 题目链接:https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;  //数组长度
        for(int i=0; i<len; i++){   

            while(nums[i] != i){   //如果索引!=索引值 则继续循环替换
                if(nums[i] == nums[nums[i]]){
                    return nums[i];      //直到替换到相等值,则表示找到了重复数字
                }
                swap(nums, i, nums[i]);
            }

        }
        return -1;
    }

    //替换函数
    public void swap(int nums[], int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}