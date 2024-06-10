package src;

import java.util.Arrays;

public class SortZerosOnes {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 0, 0, 2, 2, 1, 1, 0};
        System.out.println(Arrays.toString(sortArra(arr)));
    }

    public static int[] sortArra(int[] arr) {
        int low = 0, mid = 0, n = arr.length, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                mid++;
                low++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            } else {
                mid++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
