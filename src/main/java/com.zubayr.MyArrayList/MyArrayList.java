package com.zubayr.MyArrayList;

import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<E> implements MySortedList<E> {

    private Object[] elements;

    public int arraySize = 0;

    public MyArrayList() {
        this.elements = new Object[arraySize];
    }


    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> comparator) {
        Object base;
        final int start = 0;
        boolean toStart = false;
        for (int i = 0, k = 0; k < arraySize; i++, k++) {
            if (toStart) i = start;
            toStart = false;
            for (int j = 0; j < arraySize; j++) {
                if (i == j) continue;
                if (i == arraySize - 1 && j == arraySize - 1 ) break;

                int compare = comparator.compare((E)elements[i], (E)elements[j]);
                switch (compare){
                    case -1:
                    case 0:
                        continue;
                    case 1: {
                        toStart = true;
                        base =  elements[i];
                        elements[i] = elements[j];
                        elements[j] = base;
                        i = j;
                    }
                }

                if (j == arraySize - 1 && i !=k ) i=k;
            }
        }
    }

    public void add(int index, Object element) {
        arraySize++;
        elements = index >= (arraySize -1) ?
                (arraySize == 1 ?
                        (addToBeginning(element)) : addToEnd(element)) : (index > 0 ?
                addBetween(index, element) : addToBeginning(element));
    }

    private Object[] addToBeginning(Object element) {
        Object[] newArray = createNewCopy(1, elements.length);
        newArray[0] = element;
        return newArray;
    }

    private Object[] createNewCopy(int i, int length) {
        Object[] newArray = new Object[arraySize];
        System.arraycopy(elements, 0, newArray, i, length);
        return newArray;
    }

    private Object[] addToEnd(Object element) {
        Object[] newArray = createNewCopy(0, elements.length);
        newArray[arraySize-1] = element;
        return newArray;
    }

    private Object[] addBetween(int index,Object element){
        Object[] newArray = createNewCopy(0, index);
        newArray[index] = element;
        System.arraycopy(elements, index , newArray, (index +1), arraySize - (index +1));
        return newArray;
    }

    public void addAll(Collection<? extends E> collection) {
        collection.forEach(o-> {
            add(arraySize,o);
        });
    }


    public void clear() {
        elements = new Object[0];
        arraySize = 0;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elements[index];
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    public void remove(int index) {
        arraySize--;
        Object[] newArray = new Object[arraySize];
        for (int i = 0, j = 0; i < arraySize; i++, j++) {
            if (index == i) j++;
            newArray[i] = elements[j];
        }
        elements = newArray;
    }

    public void remove(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (o.equals(elements[i])) {
                remove(i);
                break;
            }
        }
    }
}
