package com.cest.binarySearchTree;

/**
 * 二分搜索树
 * 这个是不可以添加重复元素的二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    //该树有多少个节点
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //添加任意节点
    public void add(E e){
        root = add(root,e);
    }

    //添加节点 递归
    public Node add(Node node,E e){

        if(node == null){
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }

        return node;
    }

    //遍历 已根节点为主 如果root节点在前 就是前序遍历 在中 就是中序遍历 在后 就是后序遍历
    //其中 中序遍历是有序的 因为先找比根节点小的 然后找根节点 再找比根节点大的

    public void preOrder(){
        preOrder(root);
    }

    public void midOrder(){
        midOrder(root);
    }

    //前序遍历
    public void preOrder(Node node){

        if(node == null){
            return;
        }

        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void midOrder(Node node){
        if(node == null){
            return;
        }

        preOrder(node.left);
        System.out.print(node.e + " ");
        preOrder(node.right);
    }

    //拿到最小值
    public E minimun(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    //拿到最小值的节点
    public Node minimum(Node node){

        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }

    //拿到最大值的元素
    public E maxmum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }

        return maxmum(root).e;
    }

    //拿到最大值得节点
    public Node maxmum(Node node){

        if(node.right == null){
            return node;
        }

        return maxmum(node);
    }

    //删除最小值
    public E removeMin(){
        E e = minimum(root).e;
        removeMin(root);
        return e;
    }

    //删除最小的节点 一直向左递归
    private Node removeMin(Node node){

        if(node.left == null){
            Node right = node.right;
            node.right = null;
            size --;
            return right;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除最大值
    public E removeMax(){
        E maxmum = maxmum();
        removeMax(root);
        return maxmum;
    }

    //删除最大的节点 一直向右递归
    public Node removeMax(Node node){

        if(node.right == null){
            Node left = node.left;
            node.left = null;
            size --;
            return left;
        }

        node.right = removeMax(node.right);
        return node;
    }


    private Node remove(Node node,E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else {

            if(node.right == null){
                Node left = node.left;
                node.left = null;
                size --;
                return left;
            }

            if(node.left == null){
                Node right = node.right;
                node.right = null;
                size --;
                return right;
            }

            Node newNode = minimum(node.right);
            newNode.left = node.left;
            newNode.right = removeMin(node.right);
            node.right = node.left = null;
            return newNode;
        }
    }

}
