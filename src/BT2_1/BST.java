package BT2_1;

import BT1_1.Queue;

import java.util.Iterator;

public class BST<T extends Comparable<T>> implements TreeADT<T> {
    protected int nodeCount = 0;
    public Node<T> root = null;


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    @Override
    public void add(T element) {
        root = add(root, element);
        nodeCount++;
    }

    @Override
    public void remove(T element) {
        root = remove(root, element);
    }

    public void clear() {
        root = null;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void breadthFirstSearch() {
        if (root == null) return;

        Queue<Node<T>> nodes = new Queue<>();
        nodes.enqueue(root);

        while (!nodes.isEmpty()) {
            Node<T> node = nodes.dequeue();
            System.out.print(" " + node.getData());

            if (node.getLeft() != null) nodes.enqueue(node.getLeft());

            if (node.getRight() != null) nodes.enqueue(node.getRight());
        }
    }

    public Node rotateLeft(Node<T> parent) {
        if (parent == null || parent.getRight() == null) return null;

        Node<T> children = parent.getRight();

        parent.setRight(children.getLeft());
        children.setLeft(parent);
        return children;
    }

    public Node     rotateRight(Node<T> parent) {
        if (parent == null || parent.getLeft() == null) return null;

        Node<T> children = parent.getLeft();
        parent.setLeft(children.getRight());
        children.setRight(parent);
        return children;
    }

    public void rotateRight() {
        root = rotateRight(root);
    }

    public void rotateLeft() {
        root = rotateLeft(root);
    }

    // Private
    private int height(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) return false;

        if (value.compareTo(node.getData()) == 0) return true;

        return value.compareTo(node.getData()) < 0 ? contains(node.getLeft(), value) : contains(node.getRight(), value);
    }

    private Node<T> add(Node<T> current, T value) {
        if (current == null) return new Node<>(value, null, null);

        if (value.compareTo(current.getData()) < 0) current.setLeft(add(current.getLeft(), value));
        else if (value.compareTo(current.getData()) > 0) current.setRight(add(current.getRight(), value));

        return current;
    }

    Node<T> remove(Node<T> current, T value) {
        if (current == null) return null;

        if (value.compareTo(current.getData()) == 0) {
            if (current.getLeft() == null && current.getRight() == null) return null;

            if (current.getRight() == null) return current.getLeft();

            if (current.getLeft() == null) return current.getRight();

            T largest = findGreatest(current.getLeft());
            current.setData(largest);
            current.setLeft(remove(current.getLeft(), largest));
            return current;


        } else if (value.compareTo(current.getData()) < 0) {
            current.setLeft(remove(current.getLeft(), value));
            return current;
        }

        current.setRight(remove(current.getRight(), value));
        return current;
    }

    private T findSmallest(Node<T> root) {
        return root.getLeft() == null ? root.getData() : findSmallest(root.getLeft());
    }

    private T findGreatest(Node<T> root) {
        return root.getRight() == null ? root.getData() : findGreatest(root.getRight());
    }


    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getData());
            traverseInOrder(node.getRight());
        }
    }

    private void traversePreOrder(Node<T> node) {
        if (node != null) {
            System.out.print(" " + node.getData());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    private void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            System.out.print(" " + node.getData());
            traversePostOrder(node.getRight());
        }
    }

    private void treeToString(Node<T> node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.getData().toString()).append(" ");
            treeToString(node.getLeft(), sb);
            treeToString(node.getRight(), sb);
        }
    }

    private String treeToString() {
        StringBuilder sb = new StringBuilder();
        treeToString(root, sb);
        return sb.toString();
    }

    @Override
    public String toString() {
        return treeToString();
    }


}
