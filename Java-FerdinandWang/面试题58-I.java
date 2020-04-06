/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题58-I 翻转单词顺序
 * 题目链接:https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
*/

class Solution {
    public String reverseWords(String s) {

        // 去掉前后的空格，匹配一个或者多个空格
        String [] strArr = s.trim().split("\\s+");

        // 组装字符串
        StringBuilder sb = new StringBuilder();
        for(int i = strArr.length -1; i >= 0; i--){
            sb.append(strArr[i] + " ");
        }
        // 去掉字符串最后的空格
        return sb.toString().trim();

    }
}