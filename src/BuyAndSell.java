package src;

public class BuyAndSell {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 4, 17};

        System.out.println(getMaxProfit(arr));
    }

    public static int getMaxProfit(int[] arr){
        int maxProf = 0, minProf = Integer.MAX_VALUE;

        for(int i : arr){
            minProf = Math.min(i, minProf);
            maxProf = Math.max(maxProf, i - minProf);
        }
        return maxProf;
    }
}
