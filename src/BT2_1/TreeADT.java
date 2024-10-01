package BT2_1;

import java.util.Iterator;

public interface TreeADT<T extends Comparable<T>> {
    boolean isEmpty();

    int size();

    int height();

    boolean contains(T element);

    void add(T element);

    void remove(T element);

}
