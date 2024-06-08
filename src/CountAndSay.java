package src;

public class CountAndSay {
    public static void main(String[] args) {
        int target = 4; //1211 REL (Run-Length Encoding

        System.out.println(getCountAndSay(target));
    }

    public static String getCountAndSay(int target) {
        String curr = "1";

        for (int i = 1; i < target; i++) {
            curr = runLengthEncoding(curr);
        }
        return curr;
    }

    private static String runLengthEncoding(String curr) {
        StringBuilder sb = new StringBuilder();

        char currChar = curr.charAt(0);
        int currCount = 1;

        for (int i = 1; i < curr.length(); i++) {
            char c = curr.charAt(i);

            if (currChar == c) {
                currCount++;
            } else {
                sb.append(currCount);
                sb.append(currChar);
                currChar = c;
                currCount = 1;
            }
        }
        sb.append(currCount);
        sb.append(currChar);
        return sb.toString();
    }
}