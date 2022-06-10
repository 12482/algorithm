package com.study.algorithm.simple.link_list;

import com.study.algorithm.simple.common.DoubleNode;

/**
 * 双链表实现队列
 */
public class DoubleLinkedListQueue<T> {

    DoubleNode<T> head;
    DoubleNode<T> tail;

    public void addFromHead(T value) {
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

    public T removeFromHead() {
        if(head == null){
            return null;
        }
        T returnValue = head.value;
        if(head.next != null){
            head = head.next;
            head.last = null;
        }else{
            head = null;
            tail = null;
        }
        return returnValue;
    }


    public void addFromTail(T value) {
        DoubleNode<T> node = new DoubleNode<>(value);
        if(tail == null){
            tail = node ;
            head = node;
        }else{
            tail.next = node;
            node.last = tail;
            tail = node;
        }
    }

    public T removeFromTail(){
        if(tail == null){
            return null;
        }
        T returnValue = tail.value;
        if(tail.last == null){
            tail = null;
            head = null;
        }else{
            tail = tail.last;
            tail.next = null;
        }
        return returnValue;
    }


    public static void main(String[] args) {
        DoubleLinkedListQueue<Integer> queue = new DoubleLinkedListQueue<>();
        queue.addFromHead(4);
        queue.addFromHead(3);
        queue.addFromHead(2);
        queue.addFromHead(1);
        queue.addFromTail(5);
        Integer value = null;
        do {
            value = queue.removeFromHead();
            System.out.println(value);
        }while (value != null);



    }
}
