package BT1_1;

public class Queue<T> {
    protected int size = 0;
    protected SinglyNode<T> head = null;
    protected SinglyNode<T> tail = null;

    public Queue() {

    }

    public void clear() {
        SinglyNode<T> currentNode = head;
        while (currentNode != null) {
            SinglyNode<T> nextNode = currentNode.getNext();
            currentNode.setData(null);
            currentNode.setNext(null);
            currentNode = nextNode;
        }

        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T enqueue(T element) {
        addLast(element);
        return element;
    }

    private void addLast(T element) {
        if (size == 0) {
            SinglyNode<T> newNode = new SinglyNode<>(element, null);
            head = tail = newNode;
        } else {
            tail.setNext(new SinglyNode<>(element, null));
            tail = tail.getNext();
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List!");
        return head.getData();
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty List!");
        return tail.getData();
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Empty List!");
        SinglyNode<T> firstNode = head;
        T res = firstNode.getData();
        SinglyNode<T> nextNode = firstNode.getNext();
        head = nextNode;
        firstNode.setData(null);
        firstNode.setNext(null);
        size--;
        if (size == 0) tail = head = null;
        return res;
    }

    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder(size);
        sb.append("[");

        SinglyNode<T> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.getData());
            if (currentNode.getNext() != null) sb.append(", ");
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
