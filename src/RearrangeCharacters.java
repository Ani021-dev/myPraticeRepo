package src;

public class RearrangeCharacters {
    public static void main(String[] args) {
        String s = "abcba", target = "abc";

        System.out.println(rearrangeChar(s, target));
    }

    public static int rearrangeChar(String s, String target) {
        int[] freqS = new int[26], freqTar = new int[26];

        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        for (char c : target.toCharArray()) {
            freqTar[c - 'a']++;
        }

        int min = Integer.MAX_VALUE, temp = 0;

        for (char c : target.toCharArray()) {
            int x = freqS[c - 'a'];
            int y = freqTar[c - 'a'];

            if(x >= y){
                min = Math.min(min, x/y);
                temp++;
            }
        }
        return temp == target.length() ? min : 0;
    }
}
