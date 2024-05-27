package src;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 2, 5, 6, 3, 4};
        int low = 0, high = arr.length - 1;
        System.out.println("------Before Sort----------");
        System.out.println(Arrays.toString(arr));
        System.out.println("------After Sort----------");
        System.out.println(Arrays.toString(mergeSort(arr, low, high)));
    }

    public static int[] mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return arr;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
        return arr;
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low, right = mid + 1, count = 0;
        int[] temp = new int[arr.length];

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[count++] = arr[left];
                left++;
            } else {
                temp[count++] = arr[right];
                right++;
            }
        }

        while (left <= mid) {
            temp[count++] = arr[left];
            left++;
        }

        while (right <= high) {
            temp[count++] = arr[right];
            right++;
        }

        if (high + 1 - low >= 0)
            System.arraycopy(temp, 0, arr, low, high + 1 - low);
    }
}

class InversionCount {
    static int c = 0;
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println(getCountInv(arr));
    }

    public static int getCountInv(int[] arr) {
        int low = 0, high = arr.length - 1;
        mergeSort(arr,low, high);
        return c;
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return ;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low, right = mid + 1, count = 0;
        int[] temp = new int[arr.length];

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[count++] = arr[left];
                left++;
            } else {
                temp[count++] = arr[right];
                c += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp[count++] = arr[left];
            left++;
        }

        while (right <= high) {
            temp[count++] = arr[right];
            right++;
        }

        if (high + 1 - low >= 0)
            System.arraycopy(temp, 0, arr, low, high + 1 - low);
    }
}
