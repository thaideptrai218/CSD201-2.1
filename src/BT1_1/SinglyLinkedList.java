package BT1_1;

public class SinglyLinkedList<T> {
    protected int size = 0;
    protected SinglyNode<T> head = null;
    protected SinglyNode<T> tail = null;


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

    public void add(T element) {
        addLast(element);
    }

    public void addLast(T element) {
        if (size == 0) {
            SinglyNode<T> newNode = new SinglyNode<>(element, null);
            head = tail = newNode;
        } else {
            tail.setNext(new SinglyNode<>(element, null));
            tail = tail.getNext();
        }
        size++;
    }

    public void addFirst(T element) {
        if (size == 0) {
            SinglyNode<T> newNode = new SinglyNode<>(element, null);
            head = tail = newNode;
        } else {
            SinglyNode<T> newNode = new SinglyNode<>(element, head);
            head = newNode;
        }
        size++;
    }

    public void addAt(int index, T element) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        if (index == 0) {
            addFirst(element);
            return;
        }
        ;

        if (index == size) {
            addLast(element);
            return;
        }

        int currentIndex = 0;
        SinglyNode<T> currentNode = head;
        SinglyNode<T> prevNode = head;
        while (index != currentIndex) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        SinglyNode<T> newNode = new SinglyNode<>(element, currentNode);
        prevNode.setNext(newNode);
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

    public void removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List!");
        SinglyNode<T> firstNode = head;
        SinglyNode<T> nextNode = firstNode.getNext();
        head = nextNode;
        firstNode.setData(null);
        firstNode.setNext(null);
        size--;
        if (size == 0) tail = head = null;
    }

    public void removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty List!");
        SinglyNode<T> currentNode = head;

        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
        tail = currentNode;
        size--;
        if (size == 0) tail = head = null;
    }

    public SinglyNode<T> getNodeAt(int index) {
        if (isEmpty()) throw new RuntimeException("Empty List!");
        if (index < 0 || index > size) throw new IllegalArgumentException();
        if (index == 0) {
            return head;
        }
        ;
        if (index == size - 1) {
            return tail;
        }

        SinglyNode<T> cur = head;
        int count = 0;
        while (cur != null && count < index) {
            cur = cur.getNext();
            count++;
        }
        return cur;
    }

    public void remove(SinglyNode<T> node) {
        if (node.equals(head)) {
            removeFirst();
            return;
        }
        ;
        if (node.equals(tail)) {
            removeLast();
            return;
        }
        ;

        SinglyNode<T> currentNode = head;
        SinglyNode<T> prevNode = head;
        while (currentNode != null) {
            prevNode = currentNode;
            if (currentNode.equals(node)) {
                prevNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
            }
            currentNode = currentNode.getNext();
        }
        size--;
    }

    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        ;
        if (index == size - 1) {
            removeLast();
            return;
        }
        ;
        int currentIndex = 0;
        SinglyNode<T> currentNode = head;
        SinglyNode<T> prevNode = head;
        while (currentNode != null) {
            if (currentIndex == index) {
                prevNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        size--;
    }

    @Override
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
