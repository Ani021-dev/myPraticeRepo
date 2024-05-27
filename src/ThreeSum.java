package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 1, 2};

        System.out.println(getThreeSum(arr));
    }

    public static List<List<Integer>> getThreeSum(int[] arr) {
        int n = arr.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n && arr[i] <= 0; i++) {
            if (i != 0 && arr[i] == arr[i + 1]) continue;
            getTwoSum(-arr[i], i + 1, arr, res);
        }
        return res;
    }

    public static void getTwoSum(int target, int start, int[] arr, List<List<Integer>> res) {
        int low = start, high = arr.length - 1;

        while (low < high) {
            if (arr[low] + arr[high] > target) {
                low++;
                continue;
            }
            if (arr[low] + arr[high] < target) {
                high--;
                continue;
            }

            res.add(Arrays.asList(-target, arr[low], arr[high]));
            low++;high--;

            while(low < high && arr[high] == arr[high + 1])
                high--;
        }
    }
}