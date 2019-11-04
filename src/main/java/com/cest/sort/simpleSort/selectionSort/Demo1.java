package com.cest.sort.simpleSort.selectionSort;

/**
 * 选择排序
 * ①. 从待排序序列中，找到关键字最小的元素；
 * ②. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
 * ③. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
 */
public class Demo1 {

    public static int[] selectRiseSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }

            if(min != i){
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {9,3,1,2,31,421,3,3,5,6};
        int[] ints = selectRiseSort(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
