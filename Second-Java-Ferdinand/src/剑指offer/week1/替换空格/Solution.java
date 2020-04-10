package 剑指offer.week1.替换空格;

/**
 * 替换空格
 * 题目描述:
 *     请实现一个函数，把字符串中的每个空格替换成"%20"。
 *     你可以假定输入字符串的长度最大是1000。
 *     注意输出字符串的长度可能大于1000。
 * 样例:
 *     输入："We are happy."
 *     输出："We%20are%20happy."
 */
public class Solution {
    static String replaceSpaces(String str){
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char w : chars) {
            if(w == ' ') stringBuilder.append("%20");
            else stringBuilder.append(w);
        }
        return stringBuilder.toString();
    }
//    测试
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceSpaces(str));
    //  We%20are%20happy.
    }
}
