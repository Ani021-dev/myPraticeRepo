package src;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class RearrangingStringKDistance {
    public static void main(String[] ar) {
        String str = "aabbcc";
        int k = 1;

        System.out.println(rearrangeString(str, k));
    }

    public static String rearrangeString(String str, int k) {
        int[] count = new int[26];

        for (char c : str.toCharArray()) {
            ++count[c - 'a'];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); //for desc ordering

        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                pq.offer(new int[]{count[i], i});
            }
        }

        Deque<int[]> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            int curr = c[0];
            int currIndex = c[1];

            sb.append((char)('a' + currIndex));
            dq.offer(new int[] {curr - 1, currIndex});

            if(dq.size() >= k){
                int[] pollFirst = dq.pollFirst();
                assert pollFirst != null;
                if(pollFirst[0] > 0){
                    pq.offer(pollFirst);
                }
            }
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }
}
