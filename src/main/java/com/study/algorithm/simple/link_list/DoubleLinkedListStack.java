package com.study.algorithm.simple.link_list;

import com.study.algorithm.simple.common.DoubleNode;

/**
 * 双链表实现队列
 */
public class DoubleLinkedListStack<T> {

    DoubleNode<T> head;
    DoubleNode<T> tail;

    public void push(T value){
        DoubleNode<T> node = new DoubleNode<>(value);
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.last = node;
            head = node;
        }
    }

    public T pop(){
        if(head == null){
            return null;
        }

        T reValue= head.value;
        DoubleNode<T> next = head.next;
        if( next == null){
            head = null;
            tail = null;
        }else{
            head = next;
            head.last = null;
        }
        return reValue;
    }


    public static void main(String[] args) {
        DoubleLinkedListStack<Integer> stack = new DoubleLinkedListStack<>();
        int size = 5;
        for (int i = 0; i < size; i++) {
            stack.push(i);
        }


        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.pop());
    }
}
