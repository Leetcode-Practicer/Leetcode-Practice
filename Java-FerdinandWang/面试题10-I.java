/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题10-I 斐波那契数列
 * 题目链接:https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */

 //本题主要运用的思路是动态规划
 //与递归的思路相比有很大的优势,减少了许多的重复计算
class Solution {
    public int fib(int n) {
        //先考虑两种特殊情况
        if(n == 0 || n == 1){
            return n;
        }
        //创建长整形数组用于保存索引n对应的结果值
        long [] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        //从第三个结果开始计算
        for(int i=2 ; i <= n ; i ++){
            dp[i] = dp[i - 1] + dp[i - 2];  //转移条件
            dp[i] = dp[i] %  1000000007;  //根据题目要求进行取模
        }
        return (int)dp[n];  //长整形转回int
    }
}