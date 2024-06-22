package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingSubintervals {
    public static void main(String[] args) {
        int[][] arr = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};

        System.out.println(Arrays.deepToString(mergeOverlapings(arr)));
    }

    public static int[][] mergeOverlapings(int[][] arr) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < arr.length; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1])
                ans.add(arr[i]);
            else {
                ans.get(ans.size() - 1)[1] = Math.max(arr[i][0], ans.get(ans.size() - 1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
