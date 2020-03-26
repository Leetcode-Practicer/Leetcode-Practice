/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题04 二维数组中的查找
 * 题目链接:https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //判断二维数组为空
        if(matrix==null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int j = matrix[0].length - 1, i = 0;
        while(i<matrix.length && j>=0){
            if(matrix[i][j] > target){  //以矩阵右上角的数为起点,如果矩阵元素大于目标值,则表示目标元素不在此列
                j--; 
            }else if(matrix[i][j] < target){    //以矩阵右上角的数为起点,如果矩阵元素小于目标值,则表示目标元素不在此行
                i++;
            }else{
                return true;
            }
        }
        return false;  //全部循环完,如果找不到,则返回false
    }
}