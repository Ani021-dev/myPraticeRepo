package src;

public class MaxWaterInTank {
    public static void main(String[] ar) {
        int[] arr = {1, 8, 6, 2, 5, 8, 2, 3, 1};
        System.out.println(getMaxWater(arr));
    }

    public static int getMaxWater(int[] arr) {
        int l = 0, r = arr.length - 1, sum, min, max = 0;

        while (l < r) {
            min = Math.min(arr[l], arr[r]);
            sum = (r - l) * min;
            max = Math.max(sum, max);

            while(l < r && arr[l] <= min) l++;
            while(l < r && arr[r] <= min) r--;
        }
        return max;
    }
}
