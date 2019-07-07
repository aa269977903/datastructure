package com.cest.linklist.commonlinklist;

/**
 * 链表 null -> 1 -> 2 -> 3
 * 当前对象储存下一个对象 建议有一个虚拟头结点
 * Created by Administrator on 2019/7/7.
 * 有虚拟头结点写法
 */
public class LinkedListWithHead<E> {

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
    private Node dummyHead;

    public LinkedListWithHead() {
        size = 0;
        //different new一个空链表
        dummyHead = new Node();
    }

    //获取链表的长度
    public int getSize(){
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }


    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        //需要拿到前一个元素 使用前一个元素指向当前元素 然后当前元素指向后面一个元素
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e,prev.next);

        size ++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

    // 获取第index个元素
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node next = dummyHead.next;
        // 需要拿到当前元素
        for (int i = 0; i < index; i++) {
            next = next.next;
        }

        return next.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改第index个元素
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node next = dummyHead.next;
        // 需要拿到当前元素
        for (int i = 0; i < index; i++) {
            next = next.next;
        }

        next.e = e;
    }

    //看链表是否包含元素e
    public boolean contains(E e){
        Node next = dummyHead.next;
        while(next != null){
            if(next.e.equals(e))
                return true;
            next = next.next;
        }

        return false;
    }

    //删除元素 找到前一个元素 之后 其后一个元素 然后把它置为空
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        Node next = dummyHead.next;

        for (int i = 0; i < index - 1; i++) {
            next = next.next;
        }

        Node result = next.next;

        next.next = result.next;

        result.next = null;

        return result.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }


    public void removeElement(E e){
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }

            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }


}
