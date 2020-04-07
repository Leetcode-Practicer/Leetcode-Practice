/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题59-I 滑动窗口的最大值
 * 题目链接:https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */

//本题的主要思路是利用双端队列
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 三种情况直接返回空数组
        if(nums == null || k < 1 || nums.length < k){
            return new int[0];
        }

        
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> qMax = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while(!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]){
                qMax.pollLast();
            }
            // 不走 while 的话，说明我们正常在队列尾部添加元素
            qMax.addLast(i);
            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if(qMax.peekFirst() == (i - k)){
                qMax.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if(i >= (k - 1)){
                res[index++] = nums[qMax.peekFirst()];
            }
        }

        return res;

    }
}