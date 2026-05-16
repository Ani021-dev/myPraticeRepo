package src;

public class MaxNestingDepthParenthesis {
    public static void main(String[] args){
        String input = "(1+(2*3)+((8)/4))+1";

        System.out.print(maxDepth(input));
    }

    public static int maxDepth(String input) {
        int max = 0, count = 0;

        for(char c : input.toCharArray()) {
            switch (c) {
                case '(' : count++;
                            break;
                case ')' : max = Math.max(max, count--);
                            break;
            }
        }
        return max;
    }
}
