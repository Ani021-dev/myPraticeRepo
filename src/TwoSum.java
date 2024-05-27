package src;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 0, 5, 7};
        int target = 7;

        getSum(arr, target).forEach(ar -> System.out.println(Arrays.toString(ar)));
    }

    public static List<int[]> getSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                ans.add(new int[]{map.get(target - arr[i]), i});
            } else {
                map.put(arr[i], i);
            }
        }

        return ans;
    }
}

class TwoSumInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 6;
        System.out.println(Arrays.toString(getTarget(arr, target)));
    }

    public static int[] getTarget(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            if (target > (arr[low] + arr[high]))
                low++;
            else if (target < (arr[low] + arr[high]))
                high--;
            else {
                return new int[] {low, high};
            }
        }
        return null;
    }
}
