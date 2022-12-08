package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final int PERMUTATION_OF_STRINGS = 1;
    private static final int BINARY_SEARCH = 2;
    private static final int INSERTION_SORT = 3;
    private static final int BUBBLE_SORT = 4;
    private static final int MERGE_SORT = 5;
    private static final int ANAGRAM_DETECTION = 6;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome To Algorithms");
        System.out.println("Press 1 to Find Permutation Of Strings,2 to perform Binary Seaarch,3 for Insertion Sort," +
                "4 for Bubble Sort,5 For Merge Sort,6 for Anagrams");
        Main main = new Main();
        int option = scanner.nextInt();
        String inputString;
        switch (option) {
            case PERMUTATION_OF_STRINGS:
                inputString = scanner.next();
                main.findPermutationOfStrings(inputString);
                break;
            case BINARY_SEARCH:
                System.out.println("Enter a Word to Perform Search");
                inputString = scanner.next();
                main.binarySearch(inputString);
                break;
            case INSERTION_SORT:
                System.out.println("Enter Number Of Words You Want to Sort");
                int number = scanner.nextInt();
                String[] words = new String[number];
                for (int i = 0; i < words.length; i++) {
                    words[i] = scanner.next();
                }
                main.insertionSort(words);
                break;
            case MERGE_SORT:
                System.out.println("Enter Number Of Words You Want to Sort");
                number = scanner.nextInt();
                words = new String[number];
                for (int i = 0; i < words.length; i++) {
                    words[i] = scanner.next();
                }
                main.mergeSort(words);
                break;
            case BUBBLE_SORT:
                System.out.println("Enter Number Of Integers You Want to Sort");
                number = scanner.nextInt();
                int[] numbers = new int[number];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = scanner.nextInt();
                }
                main.bubbleSort(numbers);
                break;
            case ANAGRAM_DETECTION:
                System.out.println("Enter Two Strings to Check for Anagram");
                String string1 = scanner.next();
                String string2 = scanner.next();
                main.checkForAnagrams(string1,string2);
                break;
        }
    }

    private void checkForAnagrams(String string1, String string2) {
        Map<Character,Integer> charactersMap = new HashMap<>();
        for(char x: string1.toCharArray()){
            if(charactersMap.containsKey(x)){
                charactersMap.put(x,charactersMap.get(x)+1);
            }else{
                charactersMap.put(x,1);
            }
        }
        for(char x: string2.toCharArray()){
            if(charactersMap.containsKey(x)&&charactersMap.get(x)>0){
                charactersMap.put(x,charactersMap.get(x)-1);
            }else{
                System.out.println("Not an Anagaram");
                return;
            }
        }
        System.out.println("Anagrams");
    }

    private void mergeSort(String[] words) {
        mergseSortAlgorithm(words, 0, words.length - 1);
        for (String word : words) {
            System.out.println(word);
        }
    }

    private void mergseSortAlgorithm(String[] words, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergseSortAlgorithm(words, first, mid);
            mergseSortAlgorithm(words, mid + 1, last);
            merge(words, first, mid, last);
        }
    }

    private void merge(String[] words, int first, int mid, int last) {
        int i, j, k;
        int n1 = mid - first + 1;
        int n2 = last - mid;
        String[] LeftArray = new String[n1];
        String[] RightArray = new String[n2];
        for (i = 0; i < n1; i++)
            LeftArray[i] = words[first + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = words[mid + 1 + j];
        i = 0;
        j = 0;
        k = first;
        while (i < n1 && j < n2) {
            if (LeftArray[i].compareTo(RightArray[j]) <= 0) {
                words[k] = LeftArray[i];
                i++;
            } else {
                words[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            words[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            words[k] = RightArray[j];
            j++;
            k++;
        }

    }

    private void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j + 1 < numbers.length; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private void insertionSort(String[] words) {
        int n = words.length;
        for (int i = 1; i < n; ++i) {
            String currentWord = words[i];
            int j = i - 1;
            while (j >= 0 && words[j].compareTo(currentWord) > 0) {
                words[j + 1] = words[j];
                j = j - 1;
            }
            words[j + 1] = currentWord;
        }
        for (String word : words) {
            System.out.println(word);
        }
    }

    private void binarySearch(String inputString) {
        String path = "D:\\Algorithms\\src\\resources\\data.csv";
        ArrayList<String> sortedWords = new ArrayList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");
                for (int i = 0; i < words.length; i++) {
                    sortedWords.add(words[i]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        sortWords(sortedWords);
        int first = 0, last = sortedWords.size() - 1;

        while (first <= last) {
            int middle = (first + last) / 2;
            if (inputString.equalsIgnoreCase(sortedWords.get(middle))) {
                System.out.println("Word Found at index :" + middle);
                break;
            }
            if (inputString.compareTo(sortedWords.get(middle)) > 0) {
                first = middle + 1;
                continue;
            }
            last = middle - 1;
        }
    }

    private void sortWords(ArrayList<String> sortedWords) {
        for (int i = 0; i < sortedWords.size(); i++) {
            int minIndex = i;
            String minString = sortedWords.get(i);
            for (int j = i + 1; j < sortedWords.size(); j++) {
                if (minString.compareTo(sortedWords.get(j)) > 0) {
                    minIndex = j;
                    minString = sortedWords.get(j);
                }
            }
            String temp = sortedWords.get(i);
            sortedWords.set(i, sortedWords.get(minIndex));
            sortedWords.set(minIndex, temp);
        }
        System.out.println(sortedWords);
    }


    private void findPermutationOfStrings(String inputString) {

    }

    private void findPermutationOfStringsUsingRecursion(String inputString) {

    }
}
