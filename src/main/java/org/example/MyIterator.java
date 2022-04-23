package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator <T> implements Iterator {
    private T[] object;
    private int index = 0;
    private int length;
    private boolean elementWasRemoved = false;
    private boolean methodNextHasBeenCalled = false;

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
            if(elementWasRemoved) {
                elementWasRemoved = false;
            }
            methodNextHasBeenCalled = true;
            return  object[index++];
        } else {
            throw new NoSuchElementException("No elements remain");
        }
    }

    @Override
    public void remove() {
        if(elementWasRemoved || !methodNextHasBeenCalled) {
            throw new IllegalStateException();
        }
        int tempLength = length-1;
        T[] temp = (T[]) new Object[tempLength];
        for (int i = 0; i < index; i++) {
            temp[i] = object[i];
        }
        for (int i = index+1; i < length; i++) {
            temp[i-1] = object[i];
        }
        object = temp;
        length = tempLength;
        elementWasRemoved = true;
    }
}
