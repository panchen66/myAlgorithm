package com.panchen.myAlgorithm;

public class BinarySearch {

    public static void main(String[] args) {

        int[] test = {1, 3, 5, 7, 7, 8, 9, 10, 11};
        System.out.print(toBinarySearch(test, 0, 7));
    }

    private static int toBinarySearch(int[] arr, int n, int key) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) >> 1;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
