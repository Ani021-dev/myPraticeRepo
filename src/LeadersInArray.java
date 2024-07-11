package src;

import java.util.Arrays;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 2};
        System.out.println(Arrays.toString(getLeaders(arr)));
    }

    public static int[] getLeaders(int[] arr) {
        int n = arr.length - 1;
        int prevMax = -1;
        int[] res = new int[n+1];
        for (int i = n; i >= 0; i--) {
            res[i] = prevMax;
            if (arr[i] > prevMax) {
                prevMax = arr[i];
            }
        }
        return res;
    }
}
