package src;

public class GetMaxPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flight", "flow"};

        System.out.println(getPrefix(strs));
    }

    public static String getPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (String str : strs) {
            while(str.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}