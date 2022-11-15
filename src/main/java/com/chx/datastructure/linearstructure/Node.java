package com.chx.datastructure.linearstructure;

/**
 * 链表的结点
 * @param <E> 结点中存储的数据类型
 */
public class Node<E> {
    private E element = null;

    private Node<E> next = null;

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }
}
