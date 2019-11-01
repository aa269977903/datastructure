package com.cest.sort.basicSort;

import lombok.extern.slf4j.Slf4j;

/**
 * 直接插入排序的基本思想是：将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序
 * 的元素小，则交换，直到全部元素都比较过为止
 * Created by cestlavie on 2019/11/1.
 */
@Slf4j
public class Demo1 {

    //可重复数据排序 从小到大
    public static int[] basicRiseSort(int[] nums){
        if(nums.length > 0){
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[i] < nums[j]){
                        //临时接收i 从j到i依次往后移
                        int tmp = nums[i];
                        for (int k = i; k > j; k--) {
                            nums[k] = nums[k-1];
                        }
                        nums[j] = tmp;
                    }
                }
            }
        }
        return nums;
    }

    //可重复数据排序 从大道小
    public static int[] basicDownSort(int[] nums){
        int[] intNews = new int[nums.length];
        int[] ints = basicRiseSort(nums);
        for (int i = 0; i < nums.length; i++) {
            intNews[i] = ints[(nums.length - 1) - i];
        }
        return intNews;
    }

    public static void main(String[] args) {
        int[] nums = {9,3,1,2,31,421,3,3,5,6};
        int[] ints = basicDownSort(basicRiseSort(nums));
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
