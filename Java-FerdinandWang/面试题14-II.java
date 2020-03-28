/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题14-II 剪绳子 
 * 题目链接:https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * 
 * 
 * 我们首先考虑对于一段长n的绳子，我们可以切出的结果包含什么？
 * 1会包含吗？ 不会，因为1 * (k - 1) < k, 只要把1和任何一个其他的片段组合在一起就有个更大的值
 * 2可以
 * 3可以
 * 4可以吗？ 它拆成两个2的效果和本身一样，因此也不考虑
 * 5以上可以吗？ 不可以，这些绳子必须拆，因为总有一种拆法比不拆更优，比如拆成 k / 2 和 k - k / 2
 * 
 * 综上, 最后的结果只包含2和3(当然当总长度为2和3时单独处理), 
 * 那么很显然n >= 5时， 3*(n - 3) >= 2 * (n - 2) ，
 * 因此我们优先拆成3，最后剩余的拆成2。最后的结果一定是由若干个3和1或2个2组成.
 * 
 */
class Solution {
    public int cuttingRope(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int mod = (int)1e9 + 7;
        long res = 1;
        while(n > 4) {
            res *= 3;     //结果*3
            res %= mod;
            n -= 3;   //绳子长度-3
        }
        return (int)(res * n % mod); 
    }
}