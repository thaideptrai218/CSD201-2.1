package BT2_1;

import BT1_1.Queue;

public class CarBST extends BST<Car> {
    public void insert(String owner, int price) {
        if (owner.charAt(0) == 'B' || price > 100) return;

        Car car = new Car(owner, price);
        add(car);
    }


    public void traversePreOrder2() {
        traversePreOrder2(root);
    }

    private void traversePreOrder2(Node<Car> node) {
        if (node != null) {
            int currentCarPrice = node.getData().getPrice();
            if (currentCarPrice >= 3 && currentCarPrice <= 5) System.out.print(" " + node.getData());
            traversePreOrder2(node.getLeft());
            traversePreOrder2(node.getRight());
        }
    }

    public void f3() {
        if (root == null) return;

        Queue<Node<Car>> nodes = new Queue<>();
        nodes.enqueue(root);

        while (!nodes.isEmpty()) {
            Node<Car> node = nodes.dequeue();
            if (node.getLeft() != null && node.getRight() != null && node.getData().getPrice() < 7) {
                node = remove(node, node.getData());
                return;
            }

            if (node.getLeft() != null) nodes.enqueue(node.getLeft());

            if (node.getRight() != null) nodes.enqueue(node.getRight());
        }
    }

    public void f4() {
        if (root == null) return;

        Queue<Node<Car>> nodes = new Queue<>();
        nodes.enqueue(root);

        while (!nodes.isEmpty()) {
            Node<Car> node = nodes.dequeue();
            Node<Car> leftNode = node.getLeft();
            Node<Car> rightNode = node.getRight();
            if (leftNode.getLeft() != null && leftNode.getData().getPrice() < 7) {
                node.setLeft(rotateRight(leftNode));
                return;
            }

            if (rightNode.getLeft() != null && rightNode.getData().getPrice() < 7) {
                node.setRight(rotateRight(rightNode));
                ;
                return;
            }

            if (node.getLeft() != null) nodes.enqueue(node.getLeft());

            if (node.getRight() != null) nodes.enqueue(node.getRight());
        }
    }
}
