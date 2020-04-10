package 剑指offer.week1.不修改数组找出重复的数字;

/**
 * 题目描述:
 * 给定一个长度为 n+1 的数组nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
 * 请找出数组中任意一个重复的数，但不能修改输入的数组。
 * 样例:
 *     给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 *     返回 2 或 3。
 *
 * 题解链接:https://www.acwing.com/solution/acwing/content/693/
 * 题目思路:二分法&抽屉原理
 * 补充:
 *
 * 二分法模板
 * int bsearch_1(int l, int r)
 * {
 *     while (l < r)
 *     {
 *         int mid = l + r >> 1;
 *         if (check(mid)) r = mid;
 *         else l = mid + 1;
 *     }
 *     return l;
 * }
 */
public class Solution {
    static int duplicateInArray(int[] nums){

        //注意这里的区间指的是数的取值范围,而不是数组下标
        int l = 1, r = nums.length - 1;

        while (l < r){
            int mid = l + r >> 1; //[1, mid] , [mid + 1, r]
            int s = 0;  //s表示统计左区间中有多少个数字
            for (int x : nums) {
                if(x >= l && x <= mid) s++;
            }
            //缩小区间
            if(s > mid - l + 1) r = mid;
            else l = mid + 1;
        }
        return r;
    }

//    测试
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(duplicateInArray(nums));
        //结果输出: 3
    }
}
