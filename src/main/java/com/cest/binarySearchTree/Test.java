package com.cest.binarySearchTree;

import java.util.Random;

/**
 * Created by cestlavie on 2019/7/9.
 */
public class Test {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        Random random = new Random();

        int maxValue = 1000;

        for (int i = 0; i < 10; i++) {
            bst.add(random.nextInt(maxValue));
        }

        bst.preOrder();
        System.out.println();
        bst.midOrder();
    }
}
