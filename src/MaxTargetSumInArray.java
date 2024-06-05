package src;

import java.util.ArrayList;
import java.util.List;

public class MaxTargetSumInArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, 1, -2, 5, -10, 2, 4, 5, -11};

        System.out.println(getMaxTarget(arr)); //getting max target

        System.out.println(getSubArray(arr)); // getting subarray with max target
    }

    public static int getMaxTarget(int[] arr) {
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i : arr) {
            sum += i;
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }

    public static List<List<Integer>> getSubArray(int[] arr) {
        int max = Integer.MIN_VALUE, sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        for (int i : arr) {
            sum += i;
            max = Math.max(sum, max);
            if (sum > 0) {
                ll.add(i);
            } else {
                list.add(ll);
                ll.clear();
                sum = 0;
            }
        }
        return list;
    }
}
