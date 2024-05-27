package src;

import java.util.Arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        System.out.println("------------------Before Rotation----------------");
        System.out.println(Arrays.deepToString(mat));

        System.out.println("--------------------After Rotation---------------");
        System.out.println(Arrays.deepToString(rotateMat(mat)));
    }

    public static int[][] rotateMat(int[][] mat) {
        int n = mat.length;

        //Transpose Matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //Reversing each row of the Matrix
        for (int[] ints : mat) {
            reverseArr(ints);
        }
        return mat;
    }

    public static void reverseArr(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
