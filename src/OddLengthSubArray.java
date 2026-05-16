package src;

public class OddLengthSubArray {
    public static void main(String[] args) {
        int[] arr = {1,2};

        System.out.print(getSumOfOddLengthSubArray(arr));
    }

    public static int getSumOfOddLengthSubArray(int[] arr) {
        int totalSum = 0;
        int arrLength = arr.length;
        if(arr.length == 0){
            return 0;
        }

        for(int i = 0; i < arrLength; i++) {
            int totalSubArray = (i + 1) * (arrLength - i);
            int totalOddSubArray = (totalSubArray + 1) / 2;
            totalSum += arr[i] * totalOddSubArray;
        }

        return totalSum;
    }
}
