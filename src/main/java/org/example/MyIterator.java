package org.example;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator <T> implements Iterator {
    private T[] object;
    private int index = 0;
    private int length;


    public MyIterator(T[] object) {
        this.object = object;
        this.length = object.length;
    }

    @Override
    public boolean hasNext() {
        return index < length;
    }

    @Override
    public T next() {
        if(index < length) {
            return  object[index++];
        } else {
            throw new NoSuchElementException("No elements remain");
        }
    }

    @Override
    public void remove() {
        int tempLength = length-1;
        T[] temp = (T[]) new Object[tempLength];
        if (index >= 0) System.arraycopy(object, 0, temp, 0, index);
        if (length + 1 - (index + 1) >= 0)
            System.arraycopy(object, index + 1, temp, index + 1, length + 1 - (index + 1));
        object = temp;
        length = tempLength;
    }
}
