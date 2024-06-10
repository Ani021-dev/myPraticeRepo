package src;

public class RepeatedMaxInt {
    public static void main(String[] str) {
        int[] inp = {1, 1, 1, 1, 4, 5};

        System.out.println(getMaxRepeatedNum(inp));
    }

    public static int getMaxRepeatedNum(int[] inp) {
        int count = 0, ele = -1; int n = inp.length;

        //Moore's Voting Principle
        for (int j : inp) {
            if (count == 0) {
                count = 1;
                ele = j;
            } else if (j == ele) {
                count++;
            } else {
                count--;
            }
        }

        int cnt1 = 0;
        for (int j : inp) {
            if (j == ele) {
                cnt1++;
            }
        }

        return cnt1 >= n/2 ? ele : -1;
    }
}
