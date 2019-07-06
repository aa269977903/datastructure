package com.leedcode.stack.leetcode682;


import java.util.Stack;

/**
 * 你现在是棒球比赛记录员。
 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效?回合得分的总和。
 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效?回合得分的两倍。
 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效?回合的分数是无效的，应该被移除。
 输入: ["5","2","C","D","+"]
 输出: 30
 解释:
 第1轮：你可以得到5分。总和是：5。
 第2轮：你可以得到2分。总和是：7。
 操作1：第2轮的数据无效。总和是：5。
 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 O(n)
 */
public class Solution {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < ops.length; i++) {
            if(ops[i].equals("+")){
                Integer popNew = stack.pop();
                Integer peekOld = stack.peek();
                Integer popNewAndOld = popNew + peekOld;
                stack.push(popNew);
                stack.push(popNewAndOld);
            }else if(ops[i].equals("D")){
                Integer prepeek= stack.peek();
                stack.push(prepeek*2);
            }else if(ops[i].equals("C")){
                stack.pop();
            }else if(ops[i].matches("^-?\\d+(\\.\\d+)?$")){
                stack.push(Integer.valueOf(ops[i]));
            }else{
                throw new IllegalArgumentException("you put wrong string");
            }
        }

        int sum = 0;

        for (Integer integer : stack) {
            sum += integer;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(new Solution().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
