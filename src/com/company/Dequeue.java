package com.company;

public class Dequeue<T extends Comparable<T>> {
    private UnOrderedList<T> list;

    public Dequeue() {
        list = new UnOrderedList<>();
    }

    void addFront(T item) {
        list.add(item);
    }

    void addRear(T item) {
        list.append(item);
    }

    T removeFront() {
       return list.pop();
    }

    T removeRear() {
       return list.pop(list.size());
    }

    boolean isEmpty() {
        return list.isEmpty();
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
