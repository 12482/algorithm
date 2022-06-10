package com.study.algorithm.simple.link_list;

import com.study.algorithm.simple.common.DoubleNode;
import com.study.algorithm.simple.common.Node;

/**
 * 链表的翻转，单链表，双链表
 */
public class Reverse {


    private static DoubleNode doubleReverse(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.last = next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    private static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }

    private static void testDoubleNode(){
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);
        n1.next = n2;
        n2.next = n3;
        n2.last = n1;

        n3.next=n4;
        n3.last = n2;

        n4.last = n3;

        DoubleNode r = doubleReverse(n1);

        while (r != null){
            System.out.println(r.last +"<==" + r +" ==>" +r.next);
            r = r.next;
        }

    }


    private static void testNode(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node r = reverse(n1);
        while (r != null) {
            System.out.println(r.toString());
            r = r.next;
        }
    }

    public static void main(String[] args) {

//        testNode();
        testDoubleNode();
    }
}
