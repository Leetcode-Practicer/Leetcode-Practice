/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题14-I 剪绳子 
 * 题目链接:https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 
 * 本题思路: m个数和一定的情况下，数字越均匀，积越大
 *          所以将绳子分别切分为2,3,4,5...段,每段的长度一致
 *          特例:比如11 平均分成3段: 3 4 4
 *               11/3=3 11%3=2
 *               且分为3 3 3然后将2 平均分成 1 1 加到其中两段上 
 */
class Solution {

    private int product(int n, int m){
        int length = n / m;     //每段的基本长度
        int remainder = n % m;  //余数
        int product = 1;      //最终结果初始化,因为是乘积,所以不能初始化为0

        for (int i=0 ; i<remainder ; i++){   //先把余数均分成 remainder个1,分到基本长度的绳子上
            product = product * (length+1);
        }
        for (int j=0 ; j<m-remainder; j++){ //剩余的基本长度的绳子再进行乘积
            product = product * length;
        }

        return product;
    }

    //取较大的值函数
    private int max(int a, int b){
        return a > b ? a : b;
    }

    public int cuttingRope(int n) {
        int res = 0;

        //从2开始到 n/2+1结束,因为超过绳子长度的一半的段数,就会出现很多个1,所以没必要计算
        for(int i=2; i<= n/2+1 ; i++){   
            res = max(res, product(n, i));
        }
        return res;
    }
}