package BT1_1;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

public class CarList extends SinglyLinkedList<Car> {
//    private int size = 0;
//    private SinglyNode<Car> head = null;
//    private SinglyNode<Car> tail = null;


    public void addLast(String name, double price) {
        Car element = new Car(name, price);

        if (element.getName().charAt(0) == 'B' || element.getPrice() > 100) return;

        if (size == 0) {
            SinglyNode<Car> newNode = new SinglyNode<>(element, null);
            head = tail = newNode;
        } else {
            tail.setNext(new SinglyNode<>(element, null));
            tail = tail.getNext();
        }
        size++;
    }


    public void addIndex2(String name, double price, int index) {//add indexCoDieuKien
        Car element = new Car(name, price);
        SinglyNode<Car> currentNode = head;
//        SinglyNode<Car> prevNode = head;
        while (currentNode != null) {
            if (currentNode.getData().getPrice() < index) {//true
                currentNode.setNext(new SinglyNode<>(element, currentNode.getNext()));
                break;
            }
//            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        size++;
    }

    public void deleteIndex() {
        SinglyNode<Car> currentNode = head;
        SinglyNode<Car> prevNode = head;
        while (currentNode != null) {
            if (isPrime((int) currentNode.getData().getPrice())) {
                if (currentNode.equals(head)) {
                    removeFirst();
                } else if (currentNode == tail) {
                    removeLast();
                } else {
                    prevNode.setNext(currentNode.getNext());
                    currentNode.setNext(null);
                    size--;
                }
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    public void deleteIndexLast() {
        SinglyNode<Car> currentNode = head;
        SinglyNode<Car> prevNode = head;
        SinglyNode<Car> LastPrimeNode = null;
        SinglyNode<Car> primeNode = null;

        while (currentNode != null) {
            if (isPrime((int) currentNode.getData().getPrice())) {
                LastPrimeNode = prevNode;
                primeNode = currentNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (primeNode == null) return;

        if (primeNode.equals(head)) {
            SinglyNode<Car> firstNode = head;
            SinglyNode<Car> nextNode = firstNode.getNext();
            head = nextNode;
            firstNode.setData(null);
            firstNode.setNext(null);
        } else if (primeNode == tail) {
            LastPrimeNode.setNext(null);
            tail = LastPrimeNode;
        } else {
            LastPrimeNode.setNext(primeNode.getNext());
            primeNode.setNext(null);
        }
        size--;
    }

    public void f3toTail() {
        SinglyNode<Car> currentNode = head;
        SinglyNode<Car> prevNode = head;
        SinglyNode<Car> lastBigest = null;
        SinglyNode<Car> bigestNode = null;
        double max = Double.MIN_VALUE;

        while (currentNode != null) {
            if (currentNode.getData().getPrice() > max) {
                max = currentNode.getData().getPrice();
                lastBigest = prevNode;
                bigestNode = currentNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (bigestNode == null) throw new RuntimeException("List empty bro");

        Car temp = bigestNode.getData();

        if (bigestNode.equals(head)) {
            removeFirst();
        } else if (bigestNode.equals(tail)) {
            removeLast();
        } else {
            lastBigest.setNext(bigestNode.getNext());
            bigestNode.setNext(null);
        }

//        //Set to the head.
//        bigestNode.setNext(head);
//        head = bigestNode;
        if (isEmpty()) {
            addLast(temp);
        } else {
            //Set to the tail
            tail.setNext(new SinglyNode<>(temp, null));
            tail = tail.getNext();
        }
        size++;
    }

    public void f3toHead() {
        SinglyNode<Car> currentNode = head;
        SinglyNode<Car> prevNode = head;
        SinglyNode<Car> lastBigest = null;
        SinglyNode<Car> bigestNode = null;
        double max = Double.MIN_VALUE;

        while (currentNode != null) {
            if (currentNode.getData().getPrice() > max) {
                max = currentNode.getData().getPrice();
                lastBigest = prevNode;
                bigestNode = currentNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        Car temp = bigestNode.getData();

        if (bigestNode.equals(head)) {
            removeFirst();
        } else if (bigestNode.equals(tail)) {
            removeLast();
        } else {
            lastBigest.setNext(bigestNode.getNext());
            bigestNode.setNext(null);
        }

//        //Set to the head.

        if (isEmpty()) {
            addLast(temp);
        } else {
            //Set to the tail
            SinglyNode<Car> lol = new SinglyNode<Car>(temp, head);
            head = lol;
        }
        size++;
    }


    public void swapNearMax() {
        SinglyNode<Car> currentNode = head;
        SinglyNode<Car> prevNode = head;
        SinglyNode<Car> lastBigest = null;
        SinglyNode<Car> bigestNode = null;
        double max = Double.MIN_VALUE;

        while (currentNode != null) {
            if (currentNode.getData().getPrice() > max) {
                max = currentNode.getData().getPrice();
                lastBigest = prevNode;
                bigestNode = currentNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (bigestNode == null) throw new RuntimeException("List empty bro");

        if (bigestNode == tail || bigestNode == head) return;


        Car tempValue = lastBigest.getData();
        lastBigest.setData(bigestNode.getNext().getData());
        bigestNode.getNext().setData(tempValue);
    }


    private void insertionSort(SinglyNode<Car> headNode) {
        SinglyNode<Car> dummyHead = new SinglyNode<>(null, head);
        SinglyNode<Car> prevNode = head;
        SinglyNode<Car> currentNode = head.getNext();

        while (currentNode != null) {
            if (currentNode.getData().getPrice() >= prevNode.getData().getPrice()) {
                prevNode = currentNode;
                currentNode = currentNode.getNext();
                continue;
            }

            SinglyNode<Car> temp = dummyHead;
            while (currentNode.getData().getPrice() > temp.getNext().getData().getPrice()) {
                temp = temp.getNext();
            }

            prevNode.setNext(currentNode.getNext());
            currentNode.setNext(temp.getNext());
            temp.setNext(currentNode);
            currentNode = prevNode.getNext();
            head = dummyHead.getNext();
        }

    }


    public void sortingWithInsertion() {
        insertionSort(head);
    }

    public void f41() {
        bubbleSort(head);
    }

    public void f51() {
        reverse();
    }

    private boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    private void swap(SinglyNode<Car> ptr1, SinglyNode<Car> ptr2) {
        Car tmp = ptr2.getData();
        ptr2.setData(ptr1.getData());
        ptr1.setData(tmp);
    }


    private void bubbleSort(SinglyNode<Car> head) {
        boolean swapped;
        SinglyNode<Car> current;

        if (head == null)
            return;

        do {
            swapped = false;
            current = head;

            while (current.getNext() != null) {
                if (current.getData().getPrice() > current.getNext().getData().getPrice()) {
                    swap(current, current.getNext());
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }

    public void bubbleSortEVEN() {
        boolean swapped;
        SinglyNode<Car> current;

        if (head == null)
            return;

        do {
            swapped = false;
            current = head;

            while (current.getNext() != null && current.getNext().getNext() != null) {
                if (current.getData().getPrice() > current.getNext().getNext().getData().getPrice()) {
                    swap(current, current.getNext().getNext());
                    swapped = true;
                }
                current = current.getNext().getNext();
            }
        } while (swapped);
    }

    public void bubbleSortODD() {
        boolean swapped;
        SinglyNode<Car> current;

        if (head == null)
            return;

        do {
            swapped = false;
            current = head.getNext();

            while (current.getNext() != null && current.getNext().getNext() != null) {
                if (current.getData().getPrice() < current.getNext().getNext().getData().getPrice()) {
                    swap(current, current.getNext().getNext());
                    swapped = true;
                }
                current = current.getNext().getNext();
            }
        } while (swapped);
    }

    public void bubbleSortEVENVALUE() {
        boolean swapped;
        SinglyNode<Car> current;

        if (head == null)
            return;

        do {
            swapped = false;
            current = head;

            while (current != null && current.getData().getPrice() % 2 != 0) current = current.getNext();

            while (current != null) {
                SinglyNode<Car> nextEven = current.getNext();
                while (nextEven != null && nextEven.getData().getPrice() % 2 != 0) nextEven = nextEven.getNext();

                if (nextEven != null && current.getData().getPrice() > nextEven.getData().getPrice()) {
                    swap(current, nextEven);
                    swapped = true;
                }
                current = nextEven;
            }


        } while (swapped);
    }


    private void reverse() {
        SinglyNode<Car> prev = null;
        SinglyNode<Car> cur = head;


        while (cur != null) {
            SinglyNode<Car> next = cur.getNext();
            if (next == null) head = cur;
            if (prev == null) tail = cur;
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
    }

    @Override
    public String toString() {
        if (size == 0) return "()";
        StringBuilder sb = new StringBuilder(size);
//        sb.append("[");

        SinglyNode<Car> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.getData().toString());
            if (currentNode.getNext() != null) sb.append(", ");
            currentNode = currentNode.getNext();
        }
//        sb.append("]");
        return sb.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

}
