package src;

public class JumpGame {
    public static void main(String[] args) {
        int[] inp = {3, 2, 1, 0, 4};

        System.out.println(canJump(inp));
    }

    public static boolean canJump(int[] inp) {
        int dest = inp.length - 1;
        for (int i = inp.length - 1; i >= 0; i--) {
            if (i + inp[i] >= dest)
                dest = i;
        }
        return dest == 0;
    }
}
