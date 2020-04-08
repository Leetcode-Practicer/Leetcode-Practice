/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题66 构建乘积数组
 * 题目链接:https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
class Solution {
    public int[] constructArr(int[] a) {
        int size = a.length;
        if(size == 0){
            return new int[0];
        }

        int[] b = new int[size];

        // 先用b[i]保存a[i]左侧的乘积
        b[0] = 1;
        for(int i = 1; i < size; i++){
            b[i] = b[i-1] * a[i-1];
        }
        
        // temp暂存右侧的乘积
        int temp = 1;
        for(int j = size - 2; j >= 0; j--){
            temp = temp * a[j+1];
            b[j] = b[j] * temp;   //右侧乘积乘以左侧乘积即为结果
        }
        return b;
    }
}