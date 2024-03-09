package ch.authenticit.study;

import ch.authenticit.study.tree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        var bst = new BinaryTree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);
        var bst2 = new BinaryTree();
        bst2.insert(7);
        bst2.insert(4);
        bst2.insert(9);
        bst2.insert(1);
        bst2.insert(6);
        bst2.insert(8);
        bst2.insert(10);

        System.out.println("Height: " + bst.height());
        System.out.println("Min: " + bst.min());
        System.out.println("bst equal to bst2 " + bst.equals(bst2));
    }
}
