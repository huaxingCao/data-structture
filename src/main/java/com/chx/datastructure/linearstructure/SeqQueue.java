package com.chx.datastructure.linearstructure;

import com.sun.media.jfxmediaimpl.HostUtils;

/**
 * 循环队列
 */
public class SeqQueue<E> {
    private int maxSize;

    private Object[] elements;

    private int front;

    private int rear;

    /**
     * 初始化队列，队列默认大小为10
     */
    public SeqQueue() {
        int defaultSize = 10;
        this.maxSize = defaultSize;
        this.elements = new Object[this.maxSize];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 初始化队列，队列大小为maxSize
     * @param maxSize 最大大小
     */
    public SeqQueue(int maxSize) {
        this.maxSize = maxSize;
        this.elements = new Object[this.maxSize];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 是否为空队列
     * @return true/false
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 队列是否已满
     * @return true/false
     */
    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    /**
     * 返回队头元素
     * @return 队头元素，如果队列为空，返回null
     */
    public E getFront() {
        E frontElement = null;
        if (!this.isEmpty()) {
            frontElement = (E) elements[this.front + 1];
        }

        return frontElement;
    }

    /**
     * 在队尾插入元素
     * @param ele 元素
     * @return 是否插入
     */
    public boolean enQueue(E ele) {
        boolean isEnQueue;
        if (this.isFull()) {
            isEnQueue = false;
        } else {
            int newRear = (this.rear + 1) % maxSize;
            elements[newRear] = ele;
            this.rear = newRear;
            isEnQueue = true;
        }

        return isEnQueue;
    }

    /**
     * 在队头删除元素
     * @return 是否删除
     */
    public boolean deQueue() {
        boolean isDeQueue;
        if (this.isEmpty()) {
            isDeQueue = false;
        } else {
            int newFront = (this.front + 1) % maxSize;
            this.front = newFront;
            isDeQueue = true;
        }

        return isDeQueue;
    }

    /**
     * 清空队列元素
     */
    public void clear() {
        this.front = 0;
        this.rear = 0;
    }
}
