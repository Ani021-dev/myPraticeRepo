package src;

public class MissingInt {
    public static void main(String[] args) {
        int[] inp = {7, 8, 9, 11, 12};

        System.out.println(getMissingInt(inp));
    }

    public static int getMissingInt(int[] inp) {
        int index = 0, n = inp.length;

        while (index < n) {
            int idx = inp[index] - 1;
            if (inp[index] > 0 && inp[index] < n && inp[index] > inp[idx])
                swap(inp, index, idx);
            else
                index++;
        }

        for (int i = 0; i < n; i++) {
            if (inp[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    public static void swap(int[] inp, int index, int idx) {
        int temp = inp[index];
        inp[index] = inp[idx];
        inp[idx] = temp;
    }
}
