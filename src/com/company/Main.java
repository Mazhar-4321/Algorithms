package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final int PERMUTATION_OF_STRINGS = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome To Algorithms");
        System.out.println("Press 1 to Find Permutation Of Strings");
        Main main = new Main();
        int option = scanner.nextInt();
        String inputString;
        switch (option) {
            case PERMUTATION_OF_STRINGS:
                inputString = scanner.next();
                main.findPermutationOfStrings(inputString);
                break;
        }
    }

    private void findPermutationOfStrings(String inputString) {

    }
    private void findPermutationOfStringsUsingRecursion(String inputString){

    }
}
