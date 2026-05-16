package src;

public class StringToIntegerATOI {
    public static void main(String[] args) {
        String input = "++1";

        System.out.println(myATOI(input));
    }

    public static int myATOI(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int ans = 0, sign = 1, i = 0;

        //ignoring leading ' '
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        //handling signs
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        //process digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            //checking overflow
            if(ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return sign * ans;
    }
}
