package src;

public class MaxScoreSplittingArray {
    public static void main(String[] ar) {
        String s = "1111";

        System.out.println(getMaxScore(s));
    }

    public static int getMaxScore(String s) {
        int max = 0, zero, one = 0, n = s.length() -1;

        zero = s.charAt(0) == '0' ? 1 : 0;
        max = zero;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '0'){
                zero++;
            }else{
                one++;
                zero--;
            }
            if(max < zero){
                max = zero;
            }
        }
        one += s.charAt(n) == '1' ? 1 : 0;
        return max + one;
    }
}
