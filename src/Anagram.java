package src;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("abcd", "dbca"));
    }

    public static boolean isAnagram(String s1, String s2) {
        int[] count = new int[26];

        for (char ch : s1.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            count[ch - 'a']--;
        }

        for (int i : count) {
            if (i != 0)
                return false;
        }

        return true;
    }
}

class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(getAnagramStrings(strs));
    }

    public static List<List<String>> getAnagramStrings(String[] sts) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : sts) {
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
