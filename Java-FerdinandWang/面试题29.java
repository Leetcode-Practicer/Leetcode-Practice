/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题29 顺时针打印矩阵
 * 题目链接:https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
*/

// 本题主要思路是硬解
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){  //二维数组为空则直接返回一个空数组
            return new int[0];
        }

        int[] res = new int[(r + 1) * (b + 1)];  //结果数组，长度为二维数组的长*宽
        int x = 0;   //结果数组下标
        int l = 0;   //左边界
        int r = matrix[0].length - 1;  //右边界
        int t = 0;    //上边界
        int b = matrix.length - 1; //下边界
        
        //设置死循环
        //在判断边界时 向内收缩1
        while(true){
            //r-->l
            for(int i = l; i <= r; i++){
                res[x++] = matrix[t][i];  //依次打印到结果数组尾部
            }
            //判断是否超出下边界 
            if(++t > b){
                break;
            }

            //t-->b 
            for(int i = t; i <= b; i++){
                res[x++] = matrix[i][r];
            }
            //判断是否超出左边界
            if(--r < l){
                break;
            }

            //r-->l
            for(int i = r; i >= l; i--){
                res[x++] = matrix[b][i];
            }
            //判断是否超出上边界
            if(--b < t){
                break;
            }

            //b-->t
            for(int i = b ; i >= t; i--){
                res[x++] = matrix[i][l];
            }
            //判断是否超出右边界
            if(++l > r){
                break;
            }

        }
        // 返回结果
        return res;
    }
}