package dsa.algo.sort;

import java.util.Arrays;

// best O(n) if elements are sorted already
// average O(n^2)
// worst O(n^2)
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        display(arr);

        insertionSort(arr);
        display(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    private static void display(int[] arr) {
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
