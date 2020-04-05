/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题50 第一个只出现一次的字符
 * 题目链接:https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
*/

//本题目的主要思路是利用字典表存储字符，然后二次遍历
class Solution {
    public char firstUniqChar(String s) {
        //初始化HashMap
        Map<Character, Boolean> dic = new HashMap<>();

        //字符串转为字符数组
        char[] strArr = s.toCharArray();
        // 循环放入HashMap中，如果已经存在，则value改为false
        for(char c:strArr){
            if(dic.containsKey(c)){
                dic.put(c,false);
            }else{
                dic.put(c,true);
            }
        }

        //遍历找到第一个值为true的key
        for(char c : strArr){
            if(dic.get(c)){
                return c;
            }
        }
        //否则返回空格字符
        return ' ';
        
    }
}