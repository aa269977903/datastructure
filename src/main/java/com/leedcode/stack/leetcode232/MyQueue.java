package com.leedcode.stack.leetcode232;


import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by Administrator on 2019/7/6.
 */
public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.isEmpty()){
            while (stack2.size() != 0){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int tmp = 0;
        if(stack2.isEmpty()){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        tmp = stack2.pop();
        return tmp;
    }

    /** Get the front element. */
    public int peek() {
        int tmp = 0;
        if(stack2.isEmpty()){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        tmp = stack2.peek();
        return tmp;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.size() == 0 && stack1.size() ==0;
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(111);
    }
}
