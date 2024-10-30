package dsa.algo.search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 4, 5, 6};
        display(arr);
        System.out.println(search(arr, 5));
    }

    private static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static void display(int[] arr) {
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
