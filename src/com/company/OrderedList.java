package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderedList<K extends Comparable<K>> {
    int size;
    private INode<K> head;
    private INode<K> tail;
    private int index;

    public OrderedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(K item) {
        INode<K> tempNode = head;
        INode<K> insertAfter = null;
        INode<K> newNode = new ListNode<>(item);
        while (tempNode != null) {
            if (tempNode.getKey().compareTo(item) <= 0) {
                insertAfter = tempNode;
            }
            tempNode = tempNode.getNext();
        }
        if (insertAfter == null && head != null) {
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }
        if (insertAfter == null && head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        if (insertAfter == tail) {
            append(item);
            return;
        }
        insertAfter(insertAfter.getKey(), item);
    }

    private void insertAfter(K item1, K item2) {
        INode<K> tempNode = head;
        INode<K> newNode = new ListNode<>(item2);
        while (tempNode != null) {
            if (tempNode.getKey().equals(item1)) {
                newNode.setNext(tempNode.getNext());
                tempNode.setNext(newNode);
                if (tempNode == tail) {
                    tail = newNode;
                }
                size++;
                return;
            }
            tempNode = tempNode.getNext();
        }
    }

    public void append(K item) {
        size++;
        INode<K> newNode = new ListNode<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
    }

    public void remove(K item) {
        INode<K> tempNode = head;
        if (tempNode == null) {
            return;
        }
        if (head.getKey().compareTo(item) == 0) {
            head = head.getNext();
            return;
        }
        while (tempNode.getNext() != null) {
            if (tempNode.getNext().getKey().compareTo(item) == 0) {
                tempNode.setNext(tempNode.getNext().getNext());
                return;
            }
            tempNode = tempNode.getNext();
        }
    }

    public boolean search(K item) {
        INode<K> tempNode = head;
        while (tempNode != null) {
            if (tempNode.getKey().compareTo(item) == 0) {
                return true;
            }
            index++;
            tempNode = tempNode.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int index(K item) {
        index = -1;
        search(item);
        return index;
    }

    public K pop() {
        if (head == null)
            return null;
        K headData = head.getKey();
        head = head.getNext();
        return headData;
    }

    public K pop(int i) {
        if (i > size) {
            return null;
        }
        K itemdata;
        if (i == 0 && head != null) {
            itemdata = head.getKey();
            ;
            head = head.getNext();
            return itemdata;
        }
        INode<K> tempNode = head;
        while (i != 1) {
            i--;
            tempNode = tempNode.getNext();
        }
        itemdata = tempNode.getNext().getKey();
        tempNode.setNext(tempNode.getNext().getNext());
        if (i == size - 1) {
            tail = tempNode;
        }
        return itemdata;
    }

    public void storeDataIntoFile() {
        File file = new File("D:\\Algorithms\\src\\resources\\numbers.csv");
        FileWriter fr = null;
        INode<K> tempNode = head;
        if (head == null) {
            return;
        }
        try {
            fr = new FileWriter(file, false);
            String data = "";
            while (tempNode.getNext() != null) {
                data += tempNode.getKey() + ",";
                tempNode = tempNode.getNext();
            }
            data += tempNode.getKey();
            fr.write(data);
            fr.write("\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public String toString() {
        String data = "[";
        if (head == null) {
            return "[]";
        }
        INode<K> tempNode = head;
        while (tempNode.getNext() != null) {
            data += tempNode.getKey() + "->";
            tempNode = tempNode.getNext();
        }
        data += tempNode.getKey() + "]";
        return data;
    }
}
