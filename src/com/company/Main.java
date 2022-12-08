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
    private static final int RANGE_PRIME_NUMBERS = 7;
    private static final int GUESS_A_NUMBER = 9;
    private static final int CUSTOMIZE_MESSAGE_DEMONSTRATION = 12;
    private static final int UNORDERED_LIST_MANIPULATION = 13;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome To Algorithms");
        System.out.println("Press 1 to Find Permutation Of Strings,2 to perform Binary Seaarch,3 for Insertion Sort," +
                "\n4 for Bubble Sort,5 For Merge Sort,6 for Anagrams,7 for Range Prime Numbers,9 For Guess A Number Game\n" +
                ",12 for Customizing Message");
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
                Integer[] numbers = new Integer[number];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = scanner.nextInt();
                }
                main.bubbleSort(numbers);
                break;
            case ANAGRAM_DETECTION:
                System.out.println("Enter Two Strings to Check for Anagram");
                String string1 = scanner.next();
                String string2 = scanner.next();
                main.checkForAnagrams(string1, string2);
                break;
            case RANGE_PRIME_NUMBERS:
                main.printPrimeNumbersInRange(0, 1000);
                break;
            case GUESS_A_NUMBER:
                System.out.println("Enter a Number So That I can Guess");
                number = scanner.nextInt();
                main.guessANumber(number);
                break;
            case CUSTOMIZE_MESSAGE_DEMONSTRATION:
                System.out.println("Enter Enter A Message");
                scanner.nextLine();
                String message = scanner.nextLine();
                main.customizeMessageUsingRegexAndStringFunctions(message);
                break;
            case UNORDERED_LIST_MANIPULATION:
                main.readTextFileAndManipulateLinkedList();
                break;

        }
    }

    private void customizeMessageUsingRegexAndStringFunctions(String message) {
        message = "Hello <<name>> , We have your full name as <<full name>> in our system. your contact number is 91-1234567891. Please Let us Know in case of any clarification Thank you BridgeLabz 01/01/2006";
        message = message.replaceAll("91\\-[0-9]{10}", "91-8125629427");
        message = message.replaceAll("<<name>>", "Mazhar");
        message = message.replaceAll("<<full name>>", "Ali Syed");
        message = message.replaceAll("[0-9]{2}/[0-9]{2}/[0-9]{4}", new Date().getDate() + "/" + new Date().getMonth() + "/" + (new Date().getYear() + 1900));
        System.out.println(message);
    }

    private void guessANumber(int number) {
        int upperLimit = (int) Math.pow(2, number);
        int lowerLimit = 0;
        System.out.println("I can Guess Your Number If It Exist betwee " + lowerLimit + "and " + upperLimit);
        while (lowerLimit <= upperLimit) {
            int midValue = (lowerLimit + upperLimit) / 2;
            System.out.println("Is Your Number Between " + lowerLimit + " and " + midValue);
            System.out.println("Press 1 for Yes , 2 for No, 3 If I Guessed Your Number i.e" + midValue);
            int option = scanner.nextInt();
            if (option == 1) {
                upperLimit = midValue - 1;
            } else {
                lowerLimit = midValue + 1;
            }
        }
    }

    private void printPrimeNumbersInRange(int start, int end) {
        start = start < 2 ? 2 : start;
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            int factors = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    factors++;
                }
            }
            if (factors == 2 && isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPalindrome(int num) {
        int temp = num;
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return temp == rev;
    }

    private void checkForAnagrams(String string1, String string2) {
        Map<Character, Integer> charactersMap = new HashMap<>();
        for (char x : string1.toCharArray()) {
            if (charactersMap.containsKey(x)) {
                charactersMap.put(x, charactersMap.get(x) + 1);
            } else {
                charactersMap.put(x, 1);
            }
        }
        for (char x : string2.toCharArray()) {
            if (charactersMap.containsKey(x) && charactersMap.get(x) > 0) {
                charactersMap.put(x, charactersMap.get(x) - 1);
            } else {
                System.out.println("Not an Anagaram");
                return;
            }
        }
        System.out.println("Anagrams");
    }

    private <T extends Comparable<T>> void mergeSort(T[] words) {
        mergseSortAlgorithm(words, 0, words.length - 1);
        for (T word : words) {
            System.out.println(word);
        }
    }

    private <T extends Comparable<T>> void mergseSortAlgorithm(T[] words, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergseSortAlgorithm(words, first, mid);
            mergseSortAlgorithm(words, mid + 1, last);
            merge(words, first, mid, last);
        }
    }

    private <T extends Comparable<T>> void merge(T[] words, int first, int mid, int last) {
        int i, j, k;
        int n1 = mid - first + 1;
        int n2 = last - mid;
        T[] LeftArray = (T[]) new Object[n1];
        T[] RightArray = (T[]) new Object[n2];
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

    private <T extends Comparable<T>> void bubbleSort(T[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j + 1 < numbers.length; j++) {
                if (numbers[j].compareTo(numbers[j + 1]) > 1) {
                    T temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        for (T number : numbers) {
            System.out.println(number);
        }
    }

    private <T extends Comparable<T>> void insertionSort(T[] words) {
        int n = words.length;
        for (int i = 1; i < n; ++i) {
            T currentWord = (T) words[i];
            int j = i - 1;
            while (j >= 0 && words[j].compareTo(currentWord) > 0) {
                words[j + 1] = words[j];
                j = j - 1;
            }
            words[j + 1] = currentWord;
        }
        for (T word : words) {
            System.out.println(word);
        }
    }

    private <T extends Comparable<T>> void binarySearch(T inputString) {
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
            if (inputString.compareTo((T) sortedWords.get(middle)) == 0) {
                System.out.println("Word Found at index :" + middle);
                break;
            }
            if (inputString.compareTo((T) sortedWords.get(middle)) > 0) {
                first = middle + 1;
                continue;
            }
            last = middle - 1;
        }
    }

    private <T extends Comparable<T>> void sortWords(ArrayList<T> sortedWords) {
        for (int i = 0; i < sortedWords.size(); i++) {
            int minIndex = i;
            T minString = sortedWords.get(i);
            for (int j = i + 1; j < sortedWords.size(); j++) {
                if (minString.compareTo(sortedWords.get(j)) > 0) {
                    minIndex = j;
                    minString = sortedWords.get(j);
                }
            }
            T temp = sortedWords.get(i);
            sortedWords.set(i, sortedWords.get(minIndex));
            sortedWords.set(minIndex, temp);
        }
        System.out.println(sortedWords);
    }


    private void findPermutationOfStrings(String inputString) {

    }

    private <K> void findPermutationOfStringsUsingRecursion(K inputString) {
    }

    private void readTextFileAndManipulateLinkedList() {
        String path = "D:\\Algorithms\\src\\resources\\data.csv";
        UnOrderedList<String> list = new UnOrderedList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");
                for (int i = 0; i < words.length; i++) {
                    list.add(words[i]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        manipulateUserInputOnList(list);
    }

    private void manipulateUserInputOnList(UnOrderedList<String> list) {
        System.out.println("Enter a Word");
        String word = scanner.next();
        System.out.println(list);
        if (list.search(word)) {

            list.remove(word);
            System.out.println("item exist, hence removed from list");
        } else {
            System.out.println("item doesn't exist, hence added to list");
            list.add(word);
        }
        System.out.println(list);
        list.storeDataIntoFile();
    }
}
