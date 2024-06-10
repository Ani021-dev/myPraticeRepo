package src;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] ar) {
        String inp = "{[{()]}";

        System.out.println(isValidParanthesis(inp));
    }

    public static boolean isValidParanthesis(String inp) {
        Stack<Character> stk = new Stack<>();

        for (char ch : inp.toCharArray()) {
            switch (ch) {
                case '(' : stk.push(')');
                            break;
                case '{' : stk.push('}');
                            break;
                case '[' : stk.push(']');
                            break;
                default : if(!stk.isEmpty() && stk.pop() != ch)
                            return false;
            }
        }
        return stk.isEmpty();
    }

}
