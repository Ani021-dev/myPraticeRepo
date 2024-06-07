package src;

public class MaxSubstringWithoutRepeating {
    public static void main(String[] ar) {
        String s = "abcabcdbb";

        System.out.println(getMaxLength(s));
        System.out.println();
        System.out.println(getMaxSubstring(s));
    }

    public static int getMaxLength(String s) {
        int left = 0, n = s.length(), firstApp, max = 0;

        for (int i = 0; i < n; i++) {
            firstApp = s.indexOf(s.charAt(i), left);
            if (firstApp != i) {
                left = firstApp + 1;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static StringBuilder getMaxSubstring(String s) {
        int left = 0, n = s.length(), firstApp;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            firstApp = s.indexOf(s.charAt(i), left);
            if(firstApp != i){
                if(sb.length() < (i - left + 1)){
                    sb = new StringBuilder(s.substring(left, i));
                }
                left = firstApp + 1;
            }
        }
        return sb;
    }
}
