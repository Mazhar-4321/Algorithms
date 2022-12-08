package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UnOrderedList<K extends Comparable<K>> {
    private INode<K> head;
    private INode<K> tail;
    private int size;
    private int index;

    public UnOrderedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(K item) {
        size++;
        INode<K> newNode = new ListNode<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;

    }

    public void remove(K item) {
        INode<K> tempNode = head;
        if (tempNode == null) {
            return;
        }
        if (head.getKey().compareTo(item) == 0) {
            head = head.getNext();
            size--;
            return;
        }
        while (tempNode.getNext() != null) {
            if (tempNode.getNext().getKey().compareTo(item) == 0) {
                tempNode.setNext(tempNode.getNext().getNext());
                size--;
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

    public int index(K item) {
        index = -1;
        search(item);
        return index;
    }
  public K getHeadData(){
        return head==null?null:head.getKey();
  }
    public void storeDataIntoFile() {
        File file = new File("D:\\Algorithms\\src\\resources\\data.csv");
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

    public void insert(int i, K item) {
        if (i > size) {
            System.out.println("Invalid Index");
            return;
        }
        INode<K> newNode = new ListNode<>(item);
        INode<K> tempNode = head;
        if (i == 0) {
            add(item);
            return;
        }
        while (i != 1) {
            i--;
            tempNode = tempNode.getNext();
        }
        newNode.setNext(tempNode.getNext());
        if (tempNode == tail) {
            tail = newNode;
        }
        tempNode.setNext(newNode);

    }

    public K pop() {
        if (head == null)
            return null;
        K headData=head.getKey();
        head = head.getNext();
        size--;
        return headData;
    }

    public void pop(int i) {
        if (i > size) {
            return;
        }
        if (i == 0 && head != null) {
            head = head.getNext();
            size--;
            return;
        }
        INode<K> tempNode = head;
        while (i != 1) {
            i--;
            tempNode = tempNode.getNext();
        }
        size--;
        tempNode.setNext(tempNode.getNext().getNext());
        if (i == size - 1) {
            tail = tempNode;
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
