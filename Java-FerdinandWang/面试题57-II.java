/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题57-II 和为s的连续正数序列
 * 题目链接:https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
*/
// 本题目的思路主要是双指针
class Solution {


    private int capacity = 10;
    private int[][] res = new int[capacity][];

    public int[][] findContinuousSequence(int target) {
        int small = 1;
        int big = 2;
        int sum;
        int x = 0; //临时数组下标
        int y = 0;
        while(small < big && small <= (target/2)){
            sum = (big - small + 1) * (big + small) / 2;
            if(sum < target){
                big++;
            }else if(sum > target){
                small++;
            }else{
                int [] tmp = new int[big - small + 1];
                for(int i = small; i <= big; i++){
                    tmp[x++] = i;
                }
                x = 0;
                res[y] = tmp;
                y++;
                if(y == capacity){
                    enlargeCapacity();
                }
                small++;
            }
        }

        changeCapacity(y);
        return res;
    }

    //结果数组扩容 
    private void enlargeCapacity(){
        capacity = capacity + 10;
        res = Arrays.copyOf(res, capacity);
    }

    //删除多余的空间
    private void changeCapacity(int retCapacity){
        res = Arrays.copyOf(res,retCapacity);
    }
}