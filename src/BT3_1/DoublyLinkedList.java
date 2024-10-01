package BT3_1;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    protected int size;
    protected Node<T> head = null;
    protected Node<T> tail = null;

    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getNext();
            currentNode.setNext(null);
            currentNode.setPrev(null);
            currentNode.setData(null);
            currentNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T element) {
        addLast(element);
    }

    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            Node<T> newNode = new Node<>(element, tail, null);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            Node<T> newNode = new Node<>(element, null, head);
            head.setPrev(newNode);
            head = head.getPrev();
        }
        size++;
    }

    public void addAt(int index, T element) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        if (index == 0) {
            addFirst(element);
            return;
        }
        ;

        if (index == size - 1) {
            addLast(element);
            return;
        }

        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            int i;

            Node<T> currentNode;

            if (index < size / 2) {
                i = 0;
                currentNode = head;
                while (i != index) {
                    currentNode = currentNode.getNext();
                    i++;
                }
            } else {
                i = size - 1;
                currentNode = tail;
                while (i != index) {
                    currentNode = currentNode.getPrev();
                    i--;
                }
            }

            Node<T> newNode = new Node<>(element, currentNode, currentNode.getNext());
            currentNode.getNext().setPrev(newNode);
            currentNode.setNext(newNode);
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

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List!");
        T data = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        else head.setPrev(null);
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty List!");
        T data = tail.getData();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) head = null;
        else tail.setNext(null);
        return data;
    }

    public T remove(Node<T> node) {
        if (node.getPrev() == null) {
            removeFirst();
            return null;
        }
        ;
        if (node.getNext() == null) {
            removeLast();
            return null;
        }

        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());

        T data = node.getData();
        size--;
        node.setData(null);
        node.setNext(null);
        node.setPrev(null);
        node = null;

        return data;
    }


    public boolean remove(Object object) {
        Node<T> currentNode = head;

        if (object == null) {
            while (currentNode != null) {
                if (currentNode.getData() == null) {
                    remove(currentNode);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        } else {
            while (currentNode != null) {
                if (currentNode.getData() == object) {
                    remove(currentNode);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        int i;
        Node<T> currentNode;

        if (index < size / 2) {
            i = 0;
            currentNode = head;
            while (i != index) {
                currentNode = currentNode.getNext();
                i++;
            }
        } else {
            i = size - 1;
            currentNode = tail;
            while (i != index) {
                currentNode = currentNode.getPrev();
                i--;
            }
            ;
        }

        return remove(currentNode);
    }

    public int indexOf(Object object) {
        int index = 0;
        Node<T> currentNode = head;

        if (object == null) {
            while (currentNode != null) {
                if (currentNode.getData() == null) {
                    return index;
                }
                currentNode = currentNode.getNext();
                index++;
            }
        } else {
            while (currentNode != null) {
                if (currentNode.getData() == object) {
                    return index;
                }
                currentNode = currentNode.getNext();
                index++;
            }
        }
        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.getData();
                currentNode = currentNode.getNext();
                return null;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder(size);
        sb.append("[");

        Node<T> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.getData());
            if (currentNode.getNext() != null) sb.append(", ");
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }


}
