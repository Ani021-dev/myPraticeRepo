package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParathesis {
    public static void main(String[] ar) {
        int n = 4;
        int[] nu = new int[4];
        System.out.println(generatePara(n));
    }

    public static List<String> generatePara(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), res);
        return res;
    }

    public static void backtrack(int open, int close, StringBuilder sb, List<String> res) {
        if(close == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }

        if(open > close || open < 0) return;

        if(open > 0){
            sb.append('(');
            backtrack(open - 1, close, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append(')');
        backtrack(open, close - 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
