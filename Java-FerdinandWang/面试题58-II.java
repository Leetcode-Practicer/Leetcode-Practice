/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题58-II 左旋转字符串
 * 题目链接:https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
*/
// 第一种方法类似于第二种方法的详细实现过程
class Solution {
    public String reverseLeftWords(String s, int n) {
        if(s == null){
            return null;
        }
        char[] charArr = s.toCharArray();
        int size = charArr.length;
        
        char[] res = new char[size];
        int x = 0;
        
        for(int i = n; i < size; i++){
            res[x++] = charArr[i];
        }
        for(int j = 0; j < n; j++){
            res[x++] = charArr[j];
        }

        return String.valueOf(res);
    }


    /**第二种方法
    class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n) + s.substring(0,n);
        }
    }
    */
}