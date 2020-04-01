/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题31 栈的压入、弹出序列
 * 题目链接:https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
*/

//本题目的主要思路：根据弹出序列，模拟栈的压入弹出
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //如果压入序列和弹出序列长度不同，则返回false
        if(pushed.length != popped.length){
            return false;
        }

        //初始化栈
        Stack<Integer> stack = new Stack<Integer>();
        int size = pushed.length;
        int x = 0; //弹出序列数组的下标

        //循环压栈
        for(int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);  //压入数据

            //弹出序列没结束，栈不为空，栈的顶部数据和弹出序列x索引的数据相同，则进入循环
            while(x < size && !stack.isEmpty() && stack.peek() == popped[x]){
                stack.pop();
                x++;
            }
            //如果弹出序列遍历完，跳出循环
            if(x >= size){
                break;
            }
        }

        //下标如果等于size则表示匹配成功 （x != size -1,因为x最后肯定++才能跳出循环）
        return x == size;
    }
}