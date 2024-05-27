package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    private static Map<Character, List<Character>> map = new HashMap<>() {{
        put('2', List.of('a', 'b', 'c'));
        put('3', List.of('d', 'e', 'f'));
        put('4', List.of('g', 'h', 'i'));
        put('5', List.of('j', 'k', 'l'));
        put('6', List.of('m', 'n', 'o'));
        put('7', List.of('p', 'q', 'r', 's'));
        put('8', List.of('t', 'u', 'v'));
        put('9', List.of('w', 'x', 'y', 'z'));
    }};

    public static void main(String[] args) {
        String inp = "23";

        System.out.println(getRes(inp));
    }

    public static List<String> getRes(String inp) {
        List<String> res = new ArrayList<>();
        if (inp.isEmpty())
            return res;

        StringBuilder sb = new StringBuilder();
        dfs(0, inp, sb, res);
        return res;
    }

    private static void dfs(int i, String inp, StringBuilder sb, List<String> res) {
        if(i == inp.length()){
            res.add(sb.toString());
            return;
        }

        for(char c : map.get(inp.charAt(i))){
            sb.append(c);
            dfs(i+1, inp, sb, res);
            sb.deleteCharAt(i);
        }
    }
}
