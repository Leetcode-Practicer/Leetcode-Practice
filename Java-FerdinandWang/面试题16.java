/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题16 数值的整数次方
 * 题目链接:https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */

 //本题的主要思路是二分降幂法  比如2的8次方   应该拆成两个2的4次方相乘
class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return x;

        /**
         * Java 代码中 int32 变量 n∈[-2147483648, 2147483647]，因此当 n = -2147483648时
         * 执行n = -n会因越界而赋值出错。
         * 解决方法是先将 n 存入 long 变量 c ，后面用 c 操作即可。
         */
        long c = n;     
        double result = 1;

        if(c < 0){
            c = -c;
            x = 1/x;
        }
        while(c>0){
            if((c&1) == 1){  //如果是奇数幂
                result *= x;
            }
            //降幂
            x *= x;     
            c >>= 1; 
        }
        return result;
    }
}

/**
 * 递归降幂,也是二分法的思想
 * class Solution {
        public double myPow(double x, int n) {
            if(n == 0) return 1;
            if(n == 1) return x;
            if(n == -1) return 1 / x;
            double half = myPow(x, n / 2);
            double mod = myPow(x, n % 2);
            return half * half * mod;
        }
    }
 */