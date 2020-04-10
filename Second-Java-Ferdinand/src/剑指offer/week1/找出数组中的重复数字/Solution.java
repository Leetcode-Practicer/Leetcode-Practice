package 剑指offer.week1.找出数组中的重复数字;

public class Solution {
    public int duplicateInArray(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] < 0 || nums[i] >= n){ //如果越界，则直接返回-1
                return -1;
            }
            while(i != nums[i] && nums[nums[i]] != nums[i]){ //把索引为i的数字放到索引为num[i]上
                swap(nums, i, nums[i]);
            }
            if(nums[i] != i && nums[nums[i]] == nums[i]){ //如果索引为i的数不是i,且索引为num[i]的值是正确的,所以找到了重复值
                return nums[i];
            }
        }
        return -1;
    }

    int[] swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
