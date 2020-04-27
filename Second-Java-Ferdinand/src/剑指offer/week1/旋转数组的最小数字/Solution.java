package 剑指offer.week1.旋转数组的最小数字;
/**
 * 旋转数组的最小数字
 * 题目描述:
 *     把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *     输入一个升序的数组的一个旋转，输出旋转数组的最小元素。
 *     例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *     数组可能包含重复项。
 *
 * 注意：数组内所含元素非负，若数组大小为0，请返回-1。
 * 样例:
 *     输入：nums=[2,2,2,0,1]
 *     输出：0
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        if (n < 0) return -1;

        //去除数组尾部的重复数组,否则不符合二分法规则
        while(n > 0 && nums[n] == nums[0]) {
            n--;
        }

        //如果最后一个数比第一个数大,那么说明数组没有进行旋转
        if(nums[n] >= nums[0]) return nums[0];

        //二分法代码
        int l = 0, r = n;
        while(l < r){
            int mid = l + r >> 1;
            //条件是中间的值比第一个值要小
            if(nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[r];
    }
}
