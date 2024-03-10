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
        System.out.println("Break here:");
        System.out.println("Is a BST: " + bst.isBinarySearchTree());
        var list = bst.getNodesAtDistance(0);
        System.out.println(list);
    }
}
