package com.company;

public class Stack<K extends Comparable<K>> {
    private UnOrderedList<K> list;
    public Stack(){
        list= new UnOrderedList<>();
    }
    public void push(K item){
        list.add(item);
    }
    public void pop(){
        list.pop();
    }
    public K peek(){
        return list.getHeadData();
    }
    public boolean isEmpty(){
        return  list.size()==0;
    }
    public int size(){
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
