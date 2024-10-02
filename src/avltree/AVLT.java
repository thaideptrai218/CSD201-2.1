package avltree;

public class AVLT<T extends Comparable<T>> {
    public class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;
        private int height;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public Node<T> root;

    public AVLT() {
    }


    //check Empty
    public boolean isEmpty() {
        return root == null;
    }

    //return height of a node
    public int height() {
        return height(root);
    }

    //recursive function support
    private int height(Node<T> node) {
        if (node == null) return -1;
        return node.height;
    }

    //check is tree is balance from the root
    public boolean isBalance() {
        return isBalance(root);
    }

    //recursive finction to check;
    private boolean isBalance(Node<T> node) {
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalance(node.left) && isBalance(node.right);
    }

    public boolean search(T value) {
        return search(value, root);
    }

    private boolean search(T value, Node<T> node) {
        if (node == null) return false;

        if (value.compareTo(node.value) == 0) return true;

        return value.compareTo(node.value) < 0 ? search(value, node.left) : search(value, node.right);
    }

    public void insert(T value) {
        root = insert(value, root);
    }

    private Node<T> insert(T value, Node<T> node) {
        if (node == null) {
            node = new Node<>(value);
            return node;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insert(value, node.left);
        }

        if (value.compareTo(node.value) > 0) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right) + 1);
        return rotate(node);
    }

    public void remove(T value) {
        root = remove(value, root);
    }

    private Node<T> remove(T value, Node<T> node) {
        if (node == null) return null;

        if (value.compareTo(node.value) == 0) {
            if (node.left == null && node.right == null) return null;

            if (node.left == null) return node.right;

            if (node.right == null) return node.left;

            Node<T> max = findMin(node.right);
            node.value = max.value;
            node.right = remove(max.value, node.right);
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            return node;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = remove(value, node.left);
        }

        if (value.compareTo(node.value) > 0) {
            node.right = remove(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }


    private Node<T> findMin(Node<T> node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }

    private Node<T> findMax(Node<T> node) {
        if (node.right == null) return node;
        return findMax(node.left);
    }


    private Node<T> rotate(Node<T> node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) >= 0) {
                // left left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) <= 0) {
                // right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // left right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node<T> rightRotate(Node<T> p) {
        Node<T> c = p.left;
        Node<T> t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    private Node<T> leftRotate(Node<T> c) {
        Node<T> p = c.right;
        Node<T> t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right) + 1);
        p.height = Math.max(height(p.left), height(p.right) + 1);

        return p;
    }


}
