package com.chx.pratice;

import java.util.ArrayDeque;

/**
 * leetcode 第225题
 */
public class MyStack {
    private ArrayDeque<Integer> primaryQueue;

    private ArrayDeque<Integer> secondaryQueue;

    public MyStack() {
        this.primaryQueue = new ArrayDeque();
        this.secondaryQueue = new ArrayDeque();
    }

    public void push(int x) {
        secondaryQueue.addLast(x);
        while (!primaryQueue.isEmpty()) {
            secondaryQueue.addLast(primaryQueue.pollFirst());
        }
        ArrayDeque<Integer> tmp = primaryQueue;
        primaryQueue = secondaryQueue;
        secondaryQueue = tmp;
    }

    public int pop() {
        return primaryQueue.pollFirst();
    }

    public int top() {
        return primaryQueue.peekFirst();
    }

    public boolean empty() {
        return primaryQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        ms.push(6);
        ms.pop();
        System.out.println(ms.empty());
        System.out.println(ms.top());
    }

}
