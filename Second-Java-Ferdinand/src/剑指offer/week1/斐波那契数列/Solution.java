package 剑指offer.week1.斐波那契数列;

/**
 * 链接:斐波那契数列的各种求法
 * https://www.acwing.com/blog/content/25/
 */

public class Solution {
    static final int MOD = 1000000007;

    static long f_final(long n) {

        long[][] a = {
                {1, 1},
                {1, 0}
        };

        long[][] unit = {
                {1, 0},
                {0, 1}
        };

        long[][] x = {
                {1, 1},
                {0 ,0}
        };

        long k = n - 1;

        //快速幂的核心代码
        while(k != 0){
            //if k 是奇数,则 x^k = x * x^(k-1)
            if((k&1) == 1){
              unit = mul(unit, a);
            }
            a = mul(a, a);
            k = k >> 1;
        }

        long res[][] = mul(x, unit);

        return res[0][0];
    }

    /**
     * 两个二维矩阵相乘
     * @param a
     * @param b
     */
    static long[][] mul(long a[][], long b[][]){
        long[][] res = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    long x = res[i][j] + (long)a[i][k] * b[k][j];
                    res[i][j] = x % MOD;
                }
            }
        }
        return res;
    }

    //求斐波那契数列
    static long fib(int n) {
        if(n <= 1){
            return n;
        }
        return f_final(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(100000000));
    }
}
