/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题12 矩阵中的路径
 * 题目链接:https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */

//本题的解题思路主要是深度优先搜索
//递归实现
class Solution {
    public boolean exist(char[][] board, String word) {
        char [] words = word.toCharArray();   //将待匹配的字符串转化为字符数组
        int boardRow = board.length;         //矩阵的行数
        int boardCol = board[0].length;     //矩阵的列数

        //循环尝试每一个矩阵中的元素,直到返回true
        for(int i = 0; i <= boardRow - 1 ; i ++){
            for (int j = 0; j <= boardCol - 1 ; j++){
                if(dfs(board, words, boardRow, boardCol, i, j, 0)){
                    return true;
                }
            }
        }
        //最终没有一个元素符合要求,则返回false
        return false;
    }

    //深度优先搜索函数
    /**
     * 参数列表
     * @param board 矩阵
     * @param words 待匹配字符数组
     * @param boardRow 矩阵的行数
     * @param boardCol 矩阵的列数
     * @param i 行索引
     * @param j 列索引
     * @param k 字符数组索引
     * @return
     */
    public boolean dfs(char[][] board, char[] words, int boardRow, int boardCol, int i, int j, int k){
        if(i >= boardRow || i < 0 || j >= boardCol || j < 0 || board[i][j] != words[k]){
            //数组越界或者字符不匹配则返回false
            return false;
        }
        if(k == words.length - 1){ //如果字符数组匹配最后一个字符成功,则返回true
            return true;
        }
        char tmp = board[i][j];  //暂存当前位置的元素值
        board[i][j] = '?';   //改成?符

        //为什么是k+1?   因为如果现在进行了四个方向的移动,说明当前字符已经匹配成功,所以进行下一个字符的匹配
        boolean result = dfs(board, words, boardRow, boardCol, i - 1, j, k + 1)  //向上搜索
                || dfs(board, words, boardRow, boardCol, i, j + 1, k + 1)   //向右搜索
                || dfs(board, words, boardRow, boardCol, i + 1, j, k + 1)   //向下搜索
                || dfs(board, words, boardRow, boardCol, i, j - 1, k + 1);  //向左搜索
        board[i][j] = tmp;  //还原矩阵当前元素的值
        
        return result;
    }
}