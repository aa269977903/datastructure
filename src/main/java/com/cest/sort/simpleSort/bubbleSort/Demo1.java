package com.cest.sort.simpleSort.bubbleSort;

/**
 *  冒泡排序（Bubble Sort）是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 *  走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 */
public class Demo1 {

    public static int[] bubbleRiseSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if(nums[j - 1] > nums[j]){
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    public static int[] bubbleDownSort(int[] nums){
        int[] ints = bubbleRiseSort(nums);
        int length = Math.round(ints.length/2) + ints.length%2;
        for (int i = 0; i < length; i++) {
            int tmp = ints[i];
            ints[i] = ints[ints.length-1 - i];
            ints[ints.length-1 - i] = tmp;
        }
        return ints;
    }

    public static void main(String[] args) {



        int[] nums = {9,3,1,2,31,421,3,3,5,6};
        int[] ints = bubbleDownSort(bubbleRiseSort(nums));
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
