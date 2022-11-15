package com.chx.datastructure.linearstructure;

public class LinkedStack<E> {
    private int size;

    private Node<E> elements;

    public LinkedStack() {
        size = 0;
        elements = null;
    }

    /**
     * 是否为空
     * @return true/false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取栈顶元素
     * @return 栈顶元素
     */
    public E getTop() {
        E top;
        if (isEmpty()) {
            top = null;
        } else {
            top = elements.getElement();
        }

        return top;
    }

    /**
     * 元素入栈
     * @param ele 元素
     * @return true
     */
    public boolean push(E ele) {
        Node<E> newNode = new Node<>();
        newNode.setElement(ele);
        newNode.setNext(elements);
        elements = newNode;
        size++;

        return true;
    }

    /**
     * 删除栈顶元素
     * @return true/false
     */
    public boolean pop() {
        boolean isPop;
        if (isEmpty()) {
            isPop = false;
        } else {
            Node<E> nextNode = elements.getNext();
            elements = nextNode;
            size--;
            isPop = true;
        }

        return isPop;
    }

    /**
     * 清空栈
     * @return true
     */
    public boolean clear() {
        elements = null;
        size = 0;
        return true;
    }
}
