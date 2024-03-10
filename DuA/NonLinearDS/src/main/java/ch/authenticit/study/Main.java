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
        System.out.println("Size: " + bst.size());
        System.out.println("LeafCount: " + bst.countLeafs());
        System.out.println("Max: " + bst.max());
        System.out.println("Are Sibling: " + bst.areSibling(4, 9));
        bst.traverseLevelOrder();
    }
}
