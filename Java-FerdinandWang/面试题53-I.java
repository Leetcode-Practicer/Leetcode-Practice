/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题53-I 在排序数组中查找数字 I
 * 题目链接:https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
*/

// 本题的主要思路是，从数组两端出发，去找target的左右边界，右边界-左边界+1 即为目标数字出现的次数
class Solution {
    public int search(int[] nums, int target) {

        //数组长度
        int size = nums.length;
        int left = 0;
        int right = size - 1;

        //如果数组为空，或者数组的第一个数大于target ，或者数组的最后一个数小于target，都返回0
        if(size == 0||nums[left] > target || nums[right] < target){
            return 0;
        }

        // 找到左边界，如果找不到那么left的值为size
        for(int i = 0; i < size; i++){
            left = i;
            if(nums[i] == target){
                break;
            }
        }
        // 找到右边界，如果找不到那么right为 -1
        for(int j = size - 1; j >= 0; j--){
            right = j;
            if(nums[j] == target){
                break;
            }
        }

        //出现次数为right - left + 1
        return right < left ? 0 : (right - left + 1);
    }
}