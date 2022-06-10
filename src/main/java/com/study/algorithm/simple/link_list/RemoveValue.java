package com.study.algorithm.simple.link_list;

import com.study.algorithm.simple.common.DoubleNode;
import com.study.algorithm.simple.common.Node;

/**
 * 删除给定的值
 */
public class RemoveValue {

    public static Node remove(Node head, int value){
        Node reHead = null;
        Node tmp = head;
        //找到要返回的链表的头
        while (tmp != null){
            if(tmp.value == value){
                tmp = tmp.next;
            } else {
              reHead = tmp;
              break;
            }
        }
        if(reHead == null){
            return null;
        }

        //从新头开始遍历
        Node pre = reHead;
        Node next = pre.next;
        while (next != null){
            if(next.value == value){
                pre.next = next.next;
            }else{
                pre = next;
            }
            next = next.next;
        }
        return reHead;
    }

    private static DoubleNode remove(DoubleNode head, int value){
        DoubleNode reHead = null;
        while (head != null){
            if(head.value.equals(value)){
                reHead = head;
                break;
            }else{
                head = head.next;
            }
        }
        if(reHead == null){
            return null;
        }
        reHead.last = null;

        DoubleNode pre = null;
        DoubleNode cur = reHead;
        DoubleNode next = cur.next;
        while (next != null){
            if(next.value.equals(value)){
                cur.next = next.next;
            }else{
                cur.last = pre;
                pre = cur;
                cur = cur.next;
            }
            next = cur.next;

        }
        return reHead;
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

        DoubleNode r = remove(n1,0);

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

        Node r = remove(n1,1);
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
