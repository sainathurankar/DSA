package dsa.algo.sort;

import java.util.Arrays;

// O(n^2)
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        display(arr);

        selectionSort(arr);
        display(arr);
    }

    private static void selectionSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int minIndex = i;

            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    private static void display(int[] arr) {
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
