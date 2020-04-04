/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题40 最小的K个数
 * 题目链接:https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
*/

//本题目的主要思路：利用快排将数组从小到大排序，取前K个即可
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int size = arr.length;
        quickSort(arr, 0, size - 1);  //快排

        //初始化结果数组
        int[] res = new int[k];
        //将前K个数复制到结果数组中
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }

        return res;

    }


    //快排函数
    private static void quickSort(int[] a, int p, int r){
        if(p >= r) return;
        int q = partition(a, p, r);
        quickSort(a, p, q - 1);
        quickSort(a, q + 1, r);
    }

    //获取快排分区点函数
    private static int partition(int [] a, int p, int r){
        int pivot = a[r];
        int i = p;
        for(int j = p; j<r; ++j){
            if(a[j] < pivot){
                if(i == j){
                    ++i;
                }else{
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }
}