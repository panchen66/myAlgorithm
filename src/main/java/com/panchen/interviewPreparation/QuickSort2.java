package com.panchen.interviewPreparation;

/**
 * @Description:
 * @author: chenp
 * @date: 2020/02/08 20:31
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] num = {30, 24, 5, 58, 18, 36, 12, 42, 39};
        quickSort(num, 0, num.length - 1);
        for (int k : num) {
            System.out.print(k + ",");
        }
    }

    static void quickSort(int R[], int lo, int hi) {
        int i = lo, j = hi;
        int temp;
        if (i < j) {
            temp = R[i];
            while (i != j) {
                while (j > i && R[j] > temp) {
                    --j;
                }
                R[i] = R[j];
                while (i < j && R[i] < temp) {
                    ++i;
                }
                R[j] = R[i];
            }
            R[i] = temp;
            quickSort(R, lo, i - 1);
            quickSort(R, i + 1, hi);
        }
    }

}
