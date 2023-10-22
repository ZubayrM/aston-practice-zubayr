package com.zubayr.MyArrayList;

import java.util.Comparator;

public interface MySortedList<E> extends MyCollection<E> {

    void sort(Comparator<? super E> comparator) throws InterruptedException;

}
