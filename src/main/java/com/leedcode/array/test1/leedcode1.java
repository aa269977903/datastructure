package com.leedcode.array.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * Created by Administrator on 2019/7/4.
 */
public class leedcode1 {

    /**
     * 穷举法 时间复杂度：O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i+1; i1 < nums.length; i1++) {
                if(nums[i] + nums[i1] == target){
                    return new int[]{i,i1};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if(map.containsKey(i1) && map.get(i1) != i){
                return new int[]{i,map.get(i1)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }



    public static void main(String[] args) {
        int[] ints = twoSum2(new int[]{3, 2, 4}, 6);
        System.out.println(ints);
    }
}
