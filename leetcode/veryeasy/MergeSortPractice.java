package leetcode.veryeasy;

import java.util.Arrays;

public class MergeSortPractice {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 2, 8, 5};
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }


    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }


    private static void merge(int[] arr, int l, int m, int r) {
        int ls = m - l + 1;
        int rs = r - m;
        int[] leftArr = new int[ls];
        int[] rightArr = new int[rs];

        for (int i=0; i < ls; i++) {
            leftArr[i] = arr[l + i];
        }


        for (int i=0; i < rs; i++) {
            rightArr[i] = arr[m+i+1];
        }


        int i=0, j=0, k=l;


        while(i<ls && j<rs) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < ls) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }


        while(j < rs) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

}
