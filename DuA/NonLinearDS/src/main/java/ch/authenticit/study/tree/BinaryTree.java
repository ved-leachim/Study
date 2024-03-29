package ch.authenticit.study.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    public void insert(int value) {
        var newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        var leafNode = getLeafNode(root, value);
        if (value > leafNode.value)
            leafNode.rightChild = newNode;
        else
            leafNode.leftChild = newNode;
    }

    public boolean find(int value) {
        if (root == null)
            return false;
        return findValue(root, value);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public int height() {
        return height(root);
    }

    public int min() {
        return min(root);
    }

    public boolean equals(BinaryTree tree) {
        if (tree == null)
            return false;

        return equals(root, tree.root);
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        // Base Condition
        // If tree is empty
        if (root == null)
            return true;
        // Current Node is not in Range
        if (root.value < min || root.value > max)
            return false;
        // Recursion: Root, Left, Right
        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
            for (var value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeafs() {
        return countLeafs(root);
    }

    private int countLeafs(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return countLeafs(root.leftChild) + countLeafs(root.rightChild);
    }

    public int max() {
        if (root == null)
            throw new IllegalStateException("Cannot get max of an empty tree.");

        return max(root);
    }

    private int max(Node root) {
        if (isLeaf(root))
            return root.value;

        return max(root.rightChild);
    }

    public boolean areSibling(int first, int second) {
        if (root == null)
            return false;
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node root, int first, int second) {
        if (root.leftChild == null || root.rightChild == null)
            return false;

        if (root.leftChild.value == first)
            return root.rightChild.value == second;

        if (root.rightChild.value == first)
            return root.leftChild.value == second;

        return areSibling(root.leftChild, first, second) ||
                areSibling(root.rightChild, first, second);
    }

    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();

        if (root == null || isLeaf(root))
            return list;
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> ancestors) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        if (getAncestors(root.leftChild, value, ancestors) ||
        getAncestors(root.rightChild, value, ancestors)){
            ancestors.add(root.value);
            return true;
        }

        return false;
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    // O(n)
    private int min(Node root) {
        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(root.value, Math.min(left, right));
    }

    private boolean equals(Node root, Node otherRoot) {
        // If both nodes are null
        if (root == null && otherRoot == null)
            return true;

        // If both nodes are not null
        if (root != null && otherRoot != null) {
            return root.value == otherRoot.value
                    && equals(root.leftChild, otherRoot.leftChild)
                    && equals(root.rightChild, otherRoot.rightChild);
        }

        // If one node is null but the other is not
        return false;
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private Node getLeafNode(Node current, int value) {
        if (value > current.value) {
            if (current.rightChild == null)
                return current;
            return getLeafNode(current.rightChild, value);
        } else {
            if (current.leftChild == null)
                return current;
            return getLeafNode(current.leftChild, value);
        }
    }

    private boolean findValue(Node current, int value) {
        if (value == current.value)
            return true;

        if (value > current.value) {
            if (current.rightChild == null)
                return false;
            return findValue(current.rightChild, value);
        } else {
            if (current.leftChild == null)
                return false;
            return findValue(current.leftChild, value);
        }
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
}
