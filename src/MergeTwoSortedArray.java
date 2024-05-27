package src;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5}, arr1 = {1, 3, 5, 6};

        System.out.println(merge(arr, arr1));
    }

    public static List<Integer> merge(int[] arr, int[] arr1){
        int m = arr.length, n = arr1.length, i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();

        while(i < n && j < m){
            if(arr[i] > arr1[j]){
                ans.add(arr1[j]);
                j++;
            }else {
                ans.add(arr[i]);
                i++;
            }
        }

        while(j < m){
            ans.add(arr1[j++]);
        }
        while(i < n){
            ans.add(arr[i++]);
        }
        return ans;
    }
}
