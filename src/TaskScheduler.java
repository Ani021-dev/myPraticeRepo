package src;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        System.out.println(scheduler(task, n));
    }

    public static int scheduler(char[] task, int n) {
        int[] freq = new int[26];

        for (char c : task) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idel = (maxFreq - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idel -= Math.min(freq[i], maxFreq - 1);
        }

        return task.length + Math.max(idel, 0);
    }
}
