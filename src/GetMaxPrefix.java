package src;

public class GetMaxPrefix {
    public static void main(String[] args) {
        String[] ar = {"flower", "flight", "flow"};
        System.out.println(getPrefix(ar));
    }

    public static String getPrefix(String[] ar) {
        if (ar == null || ar.length == 0) return "";
        String prefix = ar[0];
        for (String s : ar) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
