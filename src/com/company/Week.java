package com.company;

public class Week implements Comparable {
    private String day;
    private int date;

    public Week(String day, int date) {
        this.date = date;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
