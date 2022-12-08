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
    private static final int ORDERED_LIST_MANIPULATION = 14;
    private static final int SIMPLE_BALANCED_PARENTHESIS = 15;
    private static final int BANKING_CASH_COUNTER_SIMULATOR = 16;
    private static final int PRINT_CALENDAR = 17;
    private static final int NO_OF_BSTS = 18;
    private static final int RANGE_PRIME_NUMBERS_IN_2D = 19;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome To Algorithms");
        System.out.println("Press 1 to Find Permutation Of Strings,2 to perform Binary Seaarch,3 for Insertion Sort," +
                "\n4 for Bubble Sort,5 For Merge Sort,6 for Anagrams,7 for Range Prime Numbers,9 For Guess A Number Game\n" +
                ",12 for Customizing Message,13 for Unordered List Manipulation,14 for Ordered List Manipulation\n" +
                ",15 for Validate Parenthesis,16 for Cash Counter Simulator,17 for Calendar Simulator\n" +
                "18 to print Unique BSTS,19 to print Range Prime Numbers of 2D ");
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
            case ORDERED_LIST_MANIPULATION:
                main.readTextFileAndMaipulateOrderedLinkedList();
                break;
            case SIMPLE_BALANCED_PARENTHESIS:
                main.perfomBalancedParenthesisValidationOnExpression();
                break;
            case BANKING_CASH_COUNTER_SIMULATOR:
                main.simulateCashCounterSystem();
                break;
            case PRINT_CALENDAR:
                main.printCalendar();
                break;
            case NO_OF_BSTS:
                main.printNoOfUniqueBSTs();
                break;
            case RANGE_PRIME_NUMBERS_IN_2D:
                main.storeAndPrintRangePrimeNumbersIn2D();
                break;


        }
    }

    private void storeAndPrintRangePrimeNumbersIn2D() {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue= new Queue<>();
        int[][] primeNumbersArray = new int[10][100];
        int index = 0;
        for (int i = 3; i <= 1000; i += 2) {
            int factors = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    factors += 1;
                }
            }
            if (i % 100 == 1) {
                index += 1;
            }
            if (factors == 2) {
                primeNumbersArray[index][i % 100] = i;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                if (checkForAnagramsOfPrimeNumbers(primeNumbersArray, primeNumbersArray[i][j])) {
                    stack.push(primeNumbersArray[i][j]);
                    queue.enqueue(primeNumbersArray[i][j]);
                }
            }
            System.out.println();
        }
        while (queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }

    private boolean checkForAnagramsOfPrimeNumbers(int[][] primeNumbersArray, int primeNumber) {
        if (primeNumber < 100) {
            int anagram1 = primeNumber;
            int anagram2 = Integer.parseInt("" + primeNumber + "".charAt(1) + primeNumber + "".charAt(0));
            if (primeNumbersArray[0][anagram2] != 0) {
                return true;
            }
        } else {
            String numberToString = primeNumber + "";
            int firstNumber = Integer.parseInt(numberToString.charAt(0) + "");
            int index = firstNumber;
            int anagram1 = Integer.parseInt("" + numberToString.charAt(0) + numberToString.charAt(1) + numberToString.charAt(2));
            index = Integer.parseInt(anagram1 + "".charAt(0) + "");
            if (primeNumbersArray[index][anagram1 % 100] != 0) {
                return true;
            }
            int anagram2 = Integer.parseInt("" + numberToString.charAt(0) + numberToString.charAt(2) + numberToString.charAt(1));
            index = Integer.parseInt(anagram2 + "".charAt(0) + "");
            if (primeNumbersArray[index][anagram2 % 100] != 0) {
                return true;
            }
            int anagram3 = Integer.parseInt("" + numberToString.charAt(1) + numberToString.charAt(0) + numberToString.charAt(2));
            index = Integer.parseInt(anagram3 + "".charAt(0) + "");
            if (primeNumbersArray[index][anagram3 % 100] != 0) {
                return true;
            }
            int anagram4 = Integer.parseInt("" + numberToString.charAt(1) + numberToString.charAt(2) + numberToString.charAt(0));
            index = Integer.parseInt(anagram4 + "".charAt(0) + "");
            if (primeNumbersArray[index][anagram4 % 100] != 0) {
                return true;
            }
            int anagram5 = Integer.parseInt("" + numberToString.charAt(2) + numberToString.charAt(1) + numberToString.charAt(0));
            index = Integer.parseInt(anagram5 + "".charAt(0) + "");
            if (primeNumbersArray[index][anagram5 % 100] != 0) {
                return true;
            }
            int anagram6 = Integer.parseInt("" + numberToString.charAt(2) + numberToString.charAt(0) + numberToString.charAt(1));
            index = Integer.parseInt(anagram6 + "".charAt(0) + "");
            if (primeNumbersArray[index][anagram6 % 100] != 0) {
                return true;
            }
            return false;
        }
return false;
    }

    private void printNoOfUniqueBSTs() {
        System.out.println("Enter a Number");
        int number = scanner.nextInt();
        int countOfBSTS = getFactorial(2 * number) / getFactorial(number + 1) * getFactorial(number);
        System.out.println(countOfBSTS);
    }

    private int getFactorial(int number) {
        int factorial = 1;
        while (number > 1) {
            factorial = factorial * number;
            number -= 1;
        }
        return factorial;
    }

    private void printCalendar() {
        System.out.println("Enter month and Year");
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        MyCalendar m = new MyCalendar(month, year);
        m.printCalendar();
    }

    private void simulateCashCounterSystem() {
        System.out.println("Enter Number Of People You Want to Allow to wait in Queue");
        int number = scanner.nextInt();
        System.out.println("Please Enter Your Capital");
        long capitalAmount = scanner.nextLong();
        Queue<Integer> queue = new Queue<>();
        for (int i = 1; i <= number; i++) {
            queue.enqueue(i);
        }
        System.out.println("People In The Queue");
        System.out.println(queue);
        for (int i = 1; i <= number; i++) {
            System.out.println("Person" + i + " Turn");
            System.out.println("Enter 1 to Deposit and 2 to WithDraw");
            while (true) {
                int option = scanner.nextInt();
                long amount = 0;
                if (option == 2) {
                    System.out.println("How Much Cash You Want to Withdraw:");
                    amount = scanner.nextLong();
                    if (amount > capitalAmount) {
                        System.out.println("Sorry Your Amount Exceeds Our Capital, Enter a Different Amount");
                        System.out.println("Enter 1 to Deposit and 2 to WithDraw");
                        continue;
                    }
                    capitalAmount -= amount;
                    break;
                }
                if (option == 1) {
                    System.out.println("How Much Cash You Want to Deposit:");
                    amount = scanner.nextLong();
                    capitalAmount += amount;
                    break;
                }
            }
            queue.dequeue();
            System.out.println("People In The Queue");
            System.out.println(queue);
        }
        System.out.println("Amount Available:" + capitalAmount + " and Queue Size is" + queue.size());
    }

    private void perfomBalancedParenthesisValidationOnExpression() {
        System.out.println("Enter Arithmetic Expression:");
        String arithmeticExpression = scanner.next();
        Stack<Character> stack = new Stack<>();
        for (char character : arithmeticExpression.toCharArray()) {
            if (character == '(') {
                stack.push(character);
            }
            if (character == ')' && stack.peek() == '(') {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Arithmetic Expression is Balanced");
        } else
            System.out.println("Arithmetic Expression is Not Balanced");
    }

    private void readTextFileAndMaipulateOrderedLinkedList() {
        String path = "D:\\Algorithms\\src\\resources\\numbers.csv";
        OrderedList<Integer> list = new OrderedList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");
                for (int i = 0; i < words.length; i++) {
                    list.add(Integer.parseInt(words[i]));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        manipulateUserInputOnOrderedList(list);
    }

    private void manipulateUserInputOnOrderedList(OrderedList<Integer> list) {
        System.out.println("Enter a Number");
        Integer number = scanner.nextInt();
        System.out.println(list);
        if (list.search(number)) {

            list.remove(number);
            System.out.println("item exist, hence removed from list");
        } else {
            System.out.println("item doesn't exist, hence added to list");
            list.add(number);
        }
        System.out.println(list);
        list.storeDataIntoFile();
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
