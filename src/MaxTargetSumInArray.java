package src;

public class MaxTargetSumInArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, 1, -2, 5, -10, 2, 4, 5, -11};

        System.out.println(getMaxTarget(arr)); //getting max target
    }

    public static int getMaxTarget(int[] arr) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int i : arr) {
            sum += i;
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}
