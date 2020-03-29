/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题21 调整数组顺序使奇数位于偶数前面
 * 题目链接:https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
class Solution {
    public int[] exchange(int[] nums) {
        int size = nums.length;   //数组长度
        int i = 0, j = size - 1;   //i为前指针, j为后指针
        int tmp; 
        while(i < j){   //i==j则表示交换结束
            while(i<j && (nums[i]&1) == 1){ //(nums[i]&1) == 1 表示num[i]为奇数
                i++;
            }
            while(i<j && (nums[j]&1) == 0){ //(nums[i]&1) == 0 表示num[i]为偶数
                j--;
            }

            //交换
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        return nums;
    }
    
}