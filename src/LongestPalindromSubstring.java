package src;

import java.util.List;

public class LongestPalindromSubstring {
    static int start = 0;
    static int end = 0;
    public static void main(String[] arg) {
        String s = "babad";

        System.out.println(getLongestPali(s));
        List<Integer> abc;
    }

    public static String getLongestPali(String s) {
        getPalStr(s, 0);
        return s.substring(start, end + 1);
    }

    public static void getPalStr(String s, int i) {
        int left = i, right = i, n = s.length();

        if(i >= n - 1)
            return;

        while(right < n - 1 && s.charAt(right) == s.charAt(right + 1))
            right++;
        i = right;

        while(left > 0 && right < n - 1 && s.charAt(left-1) == s.charAt(right+1)){
            left--;
            right++;
        }

        if((right - left) > (end - start)){
            end = right;
            start = left;
        }
        getPalStr(s, i + 1);
    }
}
