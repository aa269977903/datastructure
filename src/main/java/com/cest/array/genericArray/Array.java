package com.cest.array.genericArray;

/**
 * Created by Administrator on 2019/7/4.
 */
public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数,传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 默认一个数量
    public Array(){
        this(0);
    }

    //  返回长度
    public int getSize(){
        return size;
    }

    //  返回长度
    public int getCapactiy(){
        return data.length;
    }

    //  返回数组为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 添加新元素
    public void add(int index , E e){
        if(size == data.length){
            throw new IllegalArgumentException("Add failed Array is full");
        }

        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for (int i = size-1; i >= index ; i--){
            data[i+1] = data[i];
        }

        data[index] = e;

        size++;
    }

    // 所有元素前面添加一个元素
    public void addFirst(E e){
        add(0,e);
    }

    //  所有元素之后添加一个元素
    public void addLast(E e){
        add(size,e);
    }

    //  获取index位置的元素
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        return data[index];
    }

    //  修改索引处的元素
    public void set(int index , E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        data[index] = e;
    }

    //  查找数组之中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        E ret = data[index];
        for(int i = index ; i < size ; i++){
            data[i] = data[i+1];
        }

        size--;
        data[size] = null;
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }


    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int i = find(e);
        if(i != -1){
            remove(i);
        }
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
