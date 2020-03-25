/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题10-II 青蛙跳台阶问题
 * 题目链接:https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
 //本题主要运用的思路是动态规划
 //与递归的思路相比有很大的优势,减少了许多的重复计算
class Solution {
    public int numWays(int n) {
        //首先考虑三种特殊情况
        if(n == 0){
            return 1;
        } else if(n == 1 || n == 2){
            return n;
        }
        //创建长整形数组用于保存索引n对应的结果值
        long [] dp = new long[n+1];

        dp[1] = 1;
        dp[2] = 2;
         //从第三个结果开始计算
        for(int i=3; i <= n; i ++){
            dp[i] = dp[i - 1] + dp[i - 2];  //状态转移条件
            dp[i] = dp[i] % 1000000007; //按照题目要求进行取模
        }
        return (int)dp[n];  //长整型转为整形
    }
}