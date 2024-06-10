package src;

import java.util.Arrays;

public class NextGenerator {
    public static void main(String[] ar) {
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(getNextGen(arr)));
    }

    public static int[] getNextGen(int[] arr) {
        int len = arr.length, top = -1;
        int[] stk = new int[2 * len];

        for (int i = len - 1; i >= 0; i--) {
            stk[++top] = arr[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            while (top >= 0 && stk[top] <= arr[i]) {
                top--;
            }

            stk[++top] = arr[i];
            if (top > 0) arr[i] = stk[top - 1];
            else arr[i] = -1;
        }
        return arr;
    }
}

class NextGeneratorII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1}, arr1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(getNextGenII(arr, arr1)));
    }

    public static int[] getNextGenII(int[] arr, int[] arr1) {
        int len = arr.length;
        int[] map = new int[5550];
        map[arr1[len - 1]] = -1;

        for (int i = len - 2; i >= 0; i--) {
            int k = arr1[i];
            int v = arr1[i + 1];

            if (k > v) {
                do {
                    v = map[v];
                } while (k > v && v != -1);
            }
            map[k] = v;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map[arr[i]];
        }
        return arr;
    }
}
