package com.chx.pratice;

import java.util.Stack;

/**
 * leetcode 第232题
 */
public class MyQueue {
    private Stack<Integer> primaryStack;

    private Stack<Integer> tmpStack;

    public MyQueue() {
        this.primaryStack = new Stack();
        this.tmpStack = new Stack();
    }

    public void push(int x) {
        while (!primaryStack.empty()) {
            tmpStack.push(primaryStack.pop());
        }

        primaryStack.push(x);

        while (!tmpStack.empty()) {
            primaryStack.push(tmpStack.pop());
        }
    }

    public int pop() {
        return primaryStack.pop();
    }

    public int peek() {
        return primaryStack.peek();
    }

    public boolean empty() {
        return primaryStack.empty();
    }

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);

        System.out.println(mq.peek());

        System.out.println(mq.pop());

        System.out.println(mq.empty());
    }
}
