package ch.authenticit.study.tree;

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