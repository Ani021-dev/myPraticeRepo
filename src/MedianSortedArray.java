package src;

public class MedianSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2}, arr2 = {3, 4};

        System.out.println(getMedian(arr1, arr2));
    }

    public static double getMedian(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length, i = 0, j = 0, k = 0;
        int[] merged = new int[n + m];
        while (i < n && j < m) {
            if (arr1[i] < arr2[j])
                merged[k++] = arr1[i++];
            else
                merged[k++] = arr2[j++];
        }

        while (i < n) {
            merged[k++] = arr1[i++];
        }

        while (j < m) {
            merged[k++] = arr2[j++];
        }

        if ((m + n) % 2 == 0)
            return (merged[(m + n) / 2 - 1] + merged[(m + n) / 2]) / 2.0;
        else
            return merged[(m + n) / 2];
    }
}
