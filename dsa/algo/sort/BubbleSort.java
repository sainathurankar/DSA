package dsa.algo.sort;

import java.util.Arrays;

// O(n^2)
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        display(arr);

        bubbleSort(arr);
        display(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            boolean flag = false;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }

                if (!flag)
                    break;
            }
        }
    }

    private static void display(int[] arr) {
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
