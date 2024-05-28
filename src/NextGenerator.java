package src;

import java.util.Arrays;

public class NextGenerator {
    public static void main(String[] ar) {
        int[] arr = {1, 2, 1};

        System.out.println(Arrays.toString(getNextGen(arr)));
    }

    public static int[] getNextGen(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = arr.length - 1, max = Integer.MAX_VALUE;

            while (i < j) {
                if (arr[i] < arr[j] && max >= arr[j])
                    max = arr[j];
                j--;
            }
            arr[i] = max;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
