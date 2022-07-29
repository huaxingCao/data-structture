package com.chx.linearstructure;

import java.util.Arrays;

public class SeqList<E> {
    /**
     * 当前最大长度
     */
    private int maxLength = 10;

    /**
     * 每次增加的长度
     */
    private int diff = 10;

    /**
     * 元素序列
     */
    private Object[] elementArray;

    /**
     * 顺序表长度
     */
    public int length = 0;

    /**
     * 初始化顺序表
     */
    public SeqList() {
        this.elementArray = new Object[this.maxLength];
    }

    /**
     * 初始化顺序表
     * @param elements
     */
    public SeqList(E[] elements) {
        if (elements.length > maxLength)
            this.maxLength = (elements.length / this.maxLength + 1) * this.maxLength;

        this.elementArray = Arrays.copyOf(elements, this.maxLength);
        this.length = elements.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void test() {
        System.out.println("max length: " + this.maxLength);
        System.out.println("length: " + this.length);
        System.out.print("all element: ");
        for (int i=0; i<this.elementArray.length;i++) {
            System.out.print(elementArray[i]);
            System.out.print(" ");
        }
    }

    private void expend(int expendLength) {
        this.maxLength = this.maxLength + expendLength;
        this.elementArray = Arrays.copyOf(this.elementArray, this.maxLength);
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(E element) {
        if (this.length == this.maxLength)
            this.expend(this.diff);
        this.elementArray[this.length] = element;
        this.length += 1;
    }

    /**
     * 
     * @param index
     * @param element
     * @return
     */
    public boolean insert(int index, E element) {
        boolean res = false;
        if (index <= this.length && index >= -1) {
            if (this.length == this.maxLength)
                this.expend(this.diff);

        }
        return res;
    }

//    public E find(int i) {
//
//    }
//
//    public int search(E element) {
//
//    }
//
//    public boolean delete(int index) {
//
//    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
        SeqList<Integer> list = new SeqList<>(arr);
        list.add(1);
        list.test();
    }
}
