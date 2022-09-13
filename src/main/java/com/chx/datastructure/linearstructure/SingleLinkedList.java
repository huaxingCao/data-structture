package com.chx.datastructure.linearstructure;

public class SingleLinkedList<E> {
    private Node<E> elements = null;

    /**
     * 单链表长度
     */
    private int length;

    public SingleLinkedList() {}

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        boolean res = true;
        if (this.length > 0) {
            res = false;
        }

        return res;
    }

    private Node<E> findNode(int i) {
        Node<E> res = new Node<>();
        if (i>=0 && i < this.length) {
            Node<E> node = this.elements;
            for (int j = 0; j < i; j++) {
                node = node.getNext();
            }
            res = node;
        }

        return res;
    }

    /**
     * 查找并返回下标为i的元素。时间复杂度为 O(n)
     * @param i 下标
     * @return 下标为i的元素，无时返回null
     */
    public E find(int i) {
        return findNode(i).getElement();
    }

    /**
     * 搜索元素，如果存在就返回第一个元素的下标，
     * 如果不存在返回-1。时间复杂度为
     * @param element 元素
     * @return 下标
     */
    public int search(E element) {
        int index = -1;
        Node<E> node = this.elements;
        for (int i = 0; i < this.length; i++) {
            if (element.equals(node.getElement())) {
                index = i;
                break;
            }
            node = node.getNext();
        }

        return index;
    }

    /**
     * 在下标i的位置插入元素，时间复杂度是 O(n)
     * @param index 下标
     * @param element 要插入的元素
     * @return 是否成功
     */
    public boolean insert(int index, E element) {
        boolean res = false;
        Node<E> newNode = new Node<>();
        newNode.setElement(element);
        if (index == 0) {
            newNode.setNext(this.elements);
            this.elements = newNode;
            res = true;
        } else if (index > 0 && index <= this.length) {
            Node<E> oldNode = findNode(index - 1);
            newNode.setNext(oldNode.getNext());
            oldNode.setNext(newNode);
            res = true;
        }

        return res;
    }

    //public boolean delete(int i) {}

    //public boolean update(int i, E element) {}
}
