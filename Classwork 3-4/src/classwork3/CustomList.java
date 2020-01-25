package classwork3;

import java.util.Arrays;

public class CustomList {
    private final static int DEFAULT_LENGTH = 10;
    private static int index = 0;
    private int[] array;

    public CustomList() {
        this.array = new int[DEFAULT_LENGTH];
    }

    public CustomList(int count) {
        this.array = new int[count];
    }

    public void add(int value) {
        if (array.length * 0.8 < index) {
            int[] newArray = new int[array.length + DEFAULT_LENGTH];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[index++] = value;
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

    public static int fibonacciNumberByIndexRecursion(int index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fibonacciNumberByIndexRecursion(index - 1) + fibonacciNumberByIndexRecursion(index - 2);
        }
    }

    public static int fibonacciNumberByIndexIteration(int index) {
        int preresponse = 0;
        int response = 1;
        int temp;
        for (int i = 0; i < index-1; i++) {
            temp = response;
            response = response + preresponse;
            preresponse = temp;
        }
        return response;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(fibonacciNumberByIndexRecursion(55));
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent + "ms");
        long startTime1 = System.currentTimeMillis();
        System.out.println(fibonacciNumberByIndexIteration(55));
        long timeSpent1 = System.currentTimeMillis() - startTime1;
        System.out.println(timeSpent1 + "ms");
    }
}
