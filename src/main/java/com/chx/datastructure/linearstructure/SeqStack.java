package com.chx.datastructure.linearstructure;

public class SeqStack<E> {
    /**
     * 堆栈的最大大小
     */
    private int maxSize;

    /**
     * 栈顶下标
     */
    private int top = -1;

    /**
     * 堆栈元素列表
     */
    private Object[] elements;

    /**
     * 初始化
     */
    public SeqStack() {
        maxSize = 10;
        elements = new Object[maxSize];
    }

    /**
     * 初始化
     * @param stackSize  堆栈最大大小
     */
    public SeqStack(int stackSize) {
        maxSize = stackSize;
        elements = new Object[maxSize];
    }

    /**
     * 是否满了
     * @return true/false
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 是否为空
     * @return true/false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 返回栈顶元素
     * @return 栈顶元素
     */
    public E getTop() {
        E ele;
        if (isEmpty()) {
            ele = null;
        } else {
            ele = (E) elements[top];
        }

        return ele;
    }

    /**
     * 栈顶中插入元素
     * @param ele 入栈的元素
     * @return true/false
     */
    public boolean push(E ele) {
        boolean isPush;
        if (isFull()) {
            isPush = false;
        } else {
            elements[++top] = ele;
            isPush = true;
        }

        return isPush;
    }

    /**
     * 输出栈顶元素
     * @return true/false
     */
    public boolean pop() {
        boolean isPop;
        if (isEmpty()) {
            isPop = false;
        } else {
            top--;
            isPop = true;
        }

        return isPop;
    }

    /**
     * 清空栈顶元素
     */
    public void clear() {
        top = -1;
    }
}
