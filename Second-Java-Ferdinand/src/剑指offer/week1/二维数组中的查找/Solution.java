package 剑指offer.week1.二维数组中的查找;

/**
 * 二维数组中的查找
 * 题目描述:
 *     在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *     请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 样例:
 *     输入数组：
 *     [
 *       [1,2,8,9]，
 *       [2,4,9,12]，
 *       [4,7,10,13]，
 *       [6,8,11,15]
 *     ]
 *     如果输入查找数值为7，则返回true，
 *     如果输入查找数值为5，则返回false。
 */
public class Solution {
   static boolean searchArray(int[][] array, int target){
        if(array == null || array[0].length == 0) return false;
        int i = 0 , j = array[0].length - 1;
        int n = array.length;

        while (i < n && j >= 0){
            if(array[i][j] > target) j--;
            else if(array[i][j] < target) i++;
            else return true;
        }
        return false;
    }

//    测试
    public static void main(String[] args) {
        int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(searchArray(array, 7));//true
        System.out.println(searchArray(array, 5));//false




    }
}
