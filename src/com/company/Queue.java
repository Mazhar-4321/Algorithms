package com.company;

public class Queue<K extends Comparable<K>> {
    private UnOrderedList<K> list;

    public Queue() {
        list = new UnOrderedList<>();
    }

    public void enqueue(K item) {
        list.append(item);
    }

    public K dequeue() {
      return   list.pop();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
