package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllSubsets {
    public static void main(String[] args) {
        int[] arr = {2, 2, 6};

        System.out.println(printAllSubsets(arr));
    }

    public static Set<List<Integer>> printAllSubsets(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(arr, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int[] arr, int start, List<Integer> path, Set<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            backtrack(arr, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
