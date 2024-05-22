package src;

import java.util.Arrays;

public class NextPermutations {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        System.out.println(Arrays.toString(getNextPermutations(arr)));
    }

    public static int[] getNextPermutations(int[] arr) {
        int n = arr.length, i = n - 2;

        for (; i >= 0; --i) {
            if (arr[i] < arr[i + 1])
                break;
        }

        if (i >= 0) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
        }

        return revArr(arr, i + 1, n - 1);
    }

    public static int[] revArr(int[] arr, int i, int n) {
        while (i < n) {
            int temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
            i++;
            n--;
        }
        return arr;
    }
}
