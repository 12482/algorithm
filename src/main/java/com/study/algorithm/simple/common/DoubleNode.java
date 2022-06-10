package com.study.algorithm.simple.common;

/**
 * 双向链表
 */
public class DoubleNode<T> {

    public T value;

    public DoubleNode<T> next;

    public DoubleNode<T> last;

    public DoubleNode(T v){
        value = v;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
