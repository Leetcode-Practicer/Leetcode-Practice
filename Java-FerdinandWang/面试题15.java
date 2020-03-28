/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题15 二进制中1的个数 
 * 题目链接:https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
/**
 * n&1 = 1, 表示n的最右边1位是1
 * n&1 = 0, 表示n的最右边1位是0
 */
        while(n!=0){
            res += n&1;   
            n = n>>>1;   //无符号向右移位
        }
        return res;
    }
}