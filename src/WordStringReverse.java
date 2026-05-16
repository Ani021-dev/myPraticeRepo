package src;

public class WordStringReverse {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        char[] ch = s.toCharArray();

        int slow = 0, fast = 0;

        while(slow < ch.length) {
            while(fast < ch.length && ch[fast] != ' ') {
                fast++;
            }

            reverseString(ch, slow, fast - 1);

            while(fast < ch.length && ch[fast] == ' ') {
                fast++;
            }
            slow = fast;
        }
        
        return new String(ch);
    }

    public static void reverseString(char[] ch, int slow, int fast) {
        while(slow < fast) {
            char temp = ch[slow];
            ch[slow] = ch[fast];
            ch[fast] = temp;

            slow++;
            fast--;
        }
    }
}
