package src;

public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";

        System.out.println(isInterleaving(s1, s2, s3));
    }

    public static boolean isInterleaving(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] validityArr = new Boolean[s1.length() + 1][s2.length() + 1];
        return find(s1, s2, 0, 0, s3, validityArr);
    }

    public static boolean find(String s1, String s2, int i1, int i2, String s3, Boolean[][] validArr) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return true;
        }
        if (validArr[i1][i2] != null) {
            return validArr[i1][i2];
        }

        boolean isValid = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2)) {
            isValid |= find(s1, s2, i1 + 1, i2, s3, validArr);
        }
        if (!isValid && i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2)) {
            isValid = find(s1, s2, i1, i2 + 1, s2, validArr);
        }
        validArr[i1][i2] = isValid;
        return isValid;
    }
}
