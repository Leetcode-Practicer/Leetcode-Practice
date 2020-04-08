/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题65 不用加减乘除做加法
 * 题目链接:https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
// 本题目不能用加减乘除,则只能考虑位运算
class Solution {
    public int add(int a, int b) {
        while (a != 0) {
            int temp = a ^ b;  //异或运算模拟加法
            a = (a & b) << 1;  //与运算再左移一位模拟进位
            b = temp;
        }
        return b;
    }
}
