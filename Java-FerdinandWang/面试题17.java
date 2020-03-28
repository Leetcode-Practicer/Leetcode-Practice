/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题17 打印从1到最大的n位数
 * 题目链接:https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 
 * 本题目没有什么意义
 * 需要看一下原著上的解析
 */
class Solution {
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10,n) - 1];
        for(int i = 0;i < res.length;i++){
            res[i] = i + 1;
        }
        return res;
    }
}
