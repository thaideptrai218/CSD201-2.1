package BT3_1;

import BT1_1.Car;
import BT1_1.SinglyNode;

public class StudentList extends DoublyLinkedList<Student> {

    public void f1() {
        this.add(new Student("Dinh", 5));
        this.add(new Student("LOL", 10));
        this.add(new Student("HAHA", 20));
        this.add(new Student("HIHI", 80));
        this.add(new Student("HUHU", 91));
        this.add(new Student("Thai", 1));
        this.add(new Student("ee", 100));
    }

    public void sortAscending() {
        bubbleSort();
    }

    public void addIndex2(String name, double mark) {
        Student object = new Student(name, mark);
        if (isEmpty()) addLast(object);

        if (mark < 50) {
            Node<Student> cur = head;
            while (mark >= cur.getData().getMark()) {
                cur = cur.getNext();
            }
            if (cur == head) addFirst(object);

            else {
                Node<Student> prev = cur.getPrev();
                Node<Student> newStudent = new Node<>(object, prev, cur);
                prev.setNext(newStudent);
                cur.setPrev(newStudent);
            }
        } else {
            Node<Student> cur = tail;
            while (mark <= cur.getData().getMark()) {
                cur = cur.getPrev();
            }
            if (cur == tail) addLast(object);
            else {
                Node<Student> prev = cur.getPrev();
                Node<Student> newStudent = new Node<>(object, cur, cur.getNext());
                cur.getNext().setPrev(newStudent);
                cur.setNext(newStudent);
            }
        }
        size++;
    }

    public void f4() {
        Node<Student> cur = head;

        while (cur != null) {
            Node<Student> nextNode = cur.getNext();

            if (cur.getData().getMark() < 3) remove(cur);
            cur = nextNode;
        }
    }

    public void f5() {
        Node<Student> cur = head;

        while (cur != null) {
            if (cur.getData().getMark() % 5 == 0) System.out.println(cur);
            cur = cur.getNext();
        }
    }

    private void bubbleSort() {
        boolean swapped;
        Node<Student> current;

        if (head == null)
            return;

        do {
            swapped = false;
            current = head;

            while (current.getNext() != null) {
                if (current.getData().getMark() > current.getNext().getData().getMark()) {
                    swap(current, current.getNext());
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }

    private void swap(Node<Student> ptr1, Node<Student> ptr2) {
        Student tmp = ptr2.getData();
        ptr2.setData(ptr1.getData());
        ptr1.setData(tmp);
    }


    public String toString() {
        if (size == 0) return "()";
        StringBuilder sb = new StringBuilder(size);
        Node<Student> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.getData().toString());
            if (currentNode.getNext() != null) sb.append(", ");
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }

    public void print() {
        System.out.println(this);
    }

}
