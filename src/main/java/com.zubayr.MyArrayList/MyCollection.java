package com.zubayr.MyArrayList;

import java.util.Collection;
import java.util.Comparator;

public interface MyCollection<E> {

    void add(int index, E element);
    void addAll(Collection<? extends E> collection);
    void clear();
    E get(int index);
    boolean isEmpty();
    void remove(int index);
    void remove(Object o);
}
