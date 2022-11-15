package com.chx.datastructure.linearstructure;

import java.util.Arrays;

/**
 * 线性表实现
 * @param <E> 元素类型
 */
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
        this.length = 0;
    }

    /**
     * 初始化顺序表
     */
    public SeqList(E[] elements) {
        if (elements.length > maxLength)
            this.maxLength = (elements.length / this.maxLength + 1) * this.maxLength;

        this.elementArray = Arrays.copyOf(elements, this.maxLength);
        this.length = elements.length;
    }

    /**
     * 是否是空表
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * 扩展元素列表
     */
    private void expend(int expendLength) {
        this.maxLength = this.maxLength + expendLength;
        this.elementArray = Arrays.copyOf(this.elementArray, this.maxLength);
    }

    /**
     * 添加元素
     */
    public void add(E element) {
        if (this.length == this.maxLength)
            this.expend(this.diff);
        this.elementArray[this.length] = element;
        this.length += 1;
    }

    /**
     * 插入元素，index是插入的位置。时间复杂度 O(n)
     */
    public boolean insert(int index, E element) {
        boolean res = false;
        if (index <= this.length && index >= 0) {
            if (this.length == this.maxLength)
                this.expend(this.diff);
            for (int i = this.length - 1; i >= index; i--) {
                this.elementArray[i + 1] = this.elementArray[i];
            }
            this.elementArray[index] = element;
            this.length += 1;
            res = true;
        }
        return res;
    }

    /**
     * 查找下标为i的元素，无时返回null
     */
    public E get(int i) {
        E res = null;
        if (i >= 0 && i < this.length)
            res = (E) this.elementArray[i];
        return res;
    }

    /**
     * 搜索元素，如果存在返回下标，不存在返回-1。时间复杂度 O(n)
     */
    public int search(E element) {
        int res = -1;
        for (int i = 0; i < this.length; i++) {
            E ele = (E) this.elementArray[i];
            if (ele.equals(element)) {
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * 删除下标i的元素。时间复杂度 O(n)
     */
    public boolean delete(int index) {
        boolean res = false;
        if (index >= 0 && index < this.length) {
            for (int i = index; i <= this.length - 2; i++) {
                this.elementArray[i] = this.elementArray[i + 1];
            }
            this.length -= 1;
            res = true;
        }

        return res;
    }
}
