/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题39 数组中出现次数超过一半的数字
 * 题目链接:https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
*/
class Solution {
    public int majorityElement(int[] nums) {
        //用HashMap来存储数组中的数字和出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
    
        //放到列表中根据value进行排序
        List<Map.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));
    
        //列表的第一个
        return list.get(0).getKey();
    }

}