package com.xuhang.springbootdemo.test;

/**
 * @author xuhang
 * @date 2019/8/1 10:50
 */
public class MergeLinkedList {

    static  class Node{
        public int data;
        public Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node Merge (Node head1,Node head2){
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        //往新链表一个个添加节点 直至有一个链表为空
        //tmp存放最后一个添加进新链表的节点 用于后续的拼接
        Node newhead = null;

        Node tmp = null;

        while (head1!=null && head2 !=null) {
            if (head1.data < head2.data) {
                if (newhead == null) {
                    newhead = tmp = head1;
                } else {
                    tmp.next = head1;
                    tmp = tmp.next;
                }
                head1 = head1.next;
            } else {
                if (newhead == null) {
                    newhead = tmp = head2;
                } else {
                    tmp.next = head2;
                    tmp = tmp.next;
                }
                head2 = head2.next;
            }
        }
        //拼接剩余链表至新链表尾节点
        if (head1 == null) {
            tmp.next = head2;
        } else {
            tmp.next = head1;
        }
        return newhead;
    }

}
