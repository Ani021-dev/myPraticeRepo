package src;

public class MaxWaterInTank {
    public static void main(String[] ar) {
        int[] arr = {1, 8, 6, 2, 5, 4, 7, 3, 8};
        System.out.println(getMaxWater(arr));
    }

    public static int getMaxWater(int[] arr) {
        int l = 0, r = arr.length - 1, min = 0, ans = 0, sum = 0;

        while (l < r) {
            min = Math.min(arr[l], arr[r]);
            sum = (r - l) * min;
            ans = Math.max(ans, sum);

            while (arr[l] <= min && l < r) l++;
            while (arr[r] <= min && l < r) r--;
        }
        return ans;
    }
}
