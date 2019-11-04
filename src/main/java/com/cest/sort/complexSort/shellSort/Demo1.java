package com.cest.sort.complexSort.shellSort;

/**
 * 希尔排序
 *
 */
public class Demo1 {

    /**
     * 交换式排序
     * @param nums
     * @return
     */
    public static int[] shellExchangeSort(int[] nums){
        //步长
        for (int gap = nums.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < nums.length ; i++) {
                for (int j = i - gap; j >= 0 ; j -= gap) {

                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {

    }
}
