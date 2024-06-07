package src;

import java.util.Arrays;

public class RecognisingString {
    public static void main(String[] args) {
        String s = "aaab";

        System.out.println(recognizeString(s));
    }

    public static String recognizeString(String s) {
        int n = s.length();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int max = 0, letter = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                letter = i;
            }
        }

        if (max > (n + 1) / 2) return "";

        char[] res = new char[n];
        int index = 0;

        while (count[letter] > 0) {
            res[index] = (char) (letter + 'a');
            index += 2;
            count[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= n) {
                    index = 1;
                }

                res[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return String.valueOf(res);
    }
}
