package src;

import java.util.ArrayList;
import java.util.List;

public class GenerateParathesis {
    public static void main(String[] ar) {
        int target = 4;

        System.out.println(generateParenthesis(target));
    }

    public static List<String> generateParenthesis(int target) {
        List<String> res = new ArrayList<>();
        backtrack(target, target, new StringBuilder(), res);
        return res;
    }

    public static void backtrack(int open, int close, StringBuilder sb, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }

        if (open > close || open < 0) return;

        if (open > 0) {
            sb.append('(');
            backtrack(open - 1, close, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append(')');
        backtrack(open, close - 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}