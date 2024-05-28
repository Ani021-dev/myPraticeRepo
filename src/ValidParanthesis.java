package src;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] ar) {
        String inp = "{[()]}";

        System.out.println(isValidParanthesis(inp));
    }

    public static boolean isValidParanthesis(String inp) {
        Stack<Character> stk = new Stack<>();

        for (char c : inp.toCharArray()) {
            switch (c){
                case '(' : stk.push(')');
                            break;
                case '{' : stk.push('}');
                            break;
                case '[' : stk.push(']');
                            break;
                default: if(stk.isEmpty() || stk.pop() != c)
                            return false;
            }
        }
        return stk.isEmpty();
    }

}
