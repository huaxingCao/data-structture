package com.chx.datastructure.linearstructure;

public class LinkedQueue<E> {
    private int maxSize;

    private int size;

    private Node<E> front;

    private Node<E> rear;

    /**
     * 初始化队列，队列默认大小为10
     */
    public LinkedQueue() {
        int defaultSize = 10;
        this.maxSize = defaultSize;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    /**
     * 初始化队列，队列大小为maxSize
     * @param maxSize 最大大小
     */
    public LinkedQueue(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    /**
     * 是否为空队列
     * @return true/false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 队列是否已满
     * @return true/false
     */
    public boolean isFull() {
        return this.size == this.maxSize;
    }

    /**
     * 返回队头元素
     * @return 队头元素，如果队列为空，返回null
     */
    public E getFront() {
        E frontElement = null;
        if (!this.isEmpty()) {
            frontElement = this.front.getElement();
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
            Node<E> newNode = new Node<>();
            newNode.setElement(ele);

            if (this.isEmpty()) {
                this.front = newNode;
            } else {
                this.rear.setNext(newNode);
            }
            this.rear = newNode;
            this.size = this.size + 1;
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
            Node<E> nextNode = this.front.getNext();
            this.front = nextNode;
            if (this.size == 1)
                this.rear = null;
            this.size -- ;
            isDeQueue = true;
        }

        return isDeQueue;
    }

    /**
     * 清空队列元素
     */
    public void clear() {
        this.front = null;
        this.rear = null;
    }
}
