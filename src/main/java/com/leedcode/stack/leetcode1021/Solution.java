package com.leedcode.stack.leetcode1021;

import java.util.Stack;

/**
 * 有效括号字符串为空?("")、"(" + A + ")"?或?A + B，其中?A 和?B?都是有效的括号字符串，+?代表字符串的连接。例如，""，"()"，"(())()"?和?"(()(()))"?都是有效的括号字符串。

 如果有效字符串?S?非空，且不存在将其拆分为?S = A+B?的方法，我们称其为原语（primitive），其中?A 和?B?都是非空有效括号字符串。

 给出一个非空有效字符串?S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中?P_i?是有效括号字符串原语。

 对?S?进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S
 输入："(()())(())"
 输出："()()()"
 */

public class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        int start = 0;
        int end = 0;
        boolean flag = true;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c == '('){
                stack.push('(');
                if(flag){
                    start = i;
                    flag = false;
                }
            }

            if(c == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    end = i;
                    flag = true;
                    stringBuffer.append(S.substring(start + 1,end));
                }
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String S = "(()())(())";
        System.out.println(new Solution().removeOuterParentheses(S));
    }
}
