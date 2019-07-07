package com.cest.linklist.commonlinklist;

/**
 * 链表 null -> 1 -> 2 -> 3
 * 当前对象储存下一个对象 建议有一个虚拟头结点
 * Created by Administrator on 2019/7/7.
 * 无虚拟头结点写法
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node head;

    public LinkedList() {
        size = 0;
        head = null;
    }

    //获取链表的长度
    public int getSize(){
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向链表头添加元素
    public void addFirst(E e){
        //        Node node = new Node(e);
        //        node.next = head;
        //        head = node;

        head = new Node(e,head);
        size ++;
    }

    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        //如果不加空结点 需要判断head结点
        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for (int i = 0; i < (index - 1); i++) {
                prev = prev.next;
            }

            prev.next = new Node(e,prev.next);

            size ++;
        }
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }
}
