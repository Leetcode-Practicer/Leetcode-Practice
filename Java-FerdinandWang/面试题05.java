/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题05 替换空格
 * 题目链接:https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 
 * 此题目比较简单
 * 将字符串转化为字符数组,循环然后遇到空格就替换,然后再组装起来
 */
class Solution {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c==' '){
                builder.append("%20");
            }else{
                builder.append(c);
            }
        }
        return builder.toString();
    }
}