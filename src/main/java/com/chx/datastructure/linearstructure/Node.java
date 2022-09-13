package com.chx.datastructure.linearstructure;

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
