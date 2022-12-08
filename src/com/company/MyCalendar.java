package com.company;

import java.util.Calendar;
import java.util.Date;

public class MyCalendar {
    private int[][] calendar;
    private int month;
    private int year;

    public MyCalendar(int month, int year) {
        calendar = new int[6][7];
        this.month = month;
        this.year = year;
    }

    public void printCalendar() {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0
                / 4 - y0
                / 100 + y0
                / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7;
        int noOfDays = month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ? 31 :
                month == 4 || month == 6 || month == 9 || month == 11 ? 30 : isLeapYear(month) ? 29 : 28;
        int temp = d0;
        int currentDay = 1;
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                for (int j = temp; j < 7; j++) {
                    calendar[i][j] = currentDay;
                    currentDay += 1;
                }
                continue;
            }
            for(int j=0;j<7;j++){
                calendar[i][j]=currentDay<=noOfDays?currentDay:0;
                currentDay+=1;
            }
        }
        System.out.println("SUN MON TUE WED THU FRI SAT");
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if(calendar[i][j]!=0){
                    System.out.print(calendar[i][j]+(calendar[i][j]<9?"   ":"  "));
                }
                else{
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }


    private boolean isLeapYear(int number) {
        if (number < 1000) {
            return false;
        }
        if ((number % 4 == 0 && number % 100 != 0) || (number % 4 == 0 && number % 100 == 0 && number % 400 == 0)) {
            return true;
        }
        return false;
    }


}
