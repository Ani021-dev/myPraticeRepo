package src;

import java.util.Arrays;

public class MatrixSearching {

    public static class Found {
        boolean isFound;
        int[] pos;

        Found(boolean value, int[] place) {
            this.isFound = value;
            this.pos = place;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        int target = 11;
        Found res = matrixSearch(mat, target);
        System.out.printf("%s %s%n", res.isFound, Arrays.toString(res.pos));
    }

    public static Found matrixSearch(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length, l = 0, r = n - 1, mid;

        while (l <= r) {
            mid = (l + r) / 2;

            if (target == mat[mid][0]) {
                return new Found(true, new int[]{mid, 0});
            }

            if (target == mat[mid][m - 1]) {
                return new Found(true, new int[]{mid, m - 1});
            }

            if (target > mat[mid][0] && target < mat[mid][m - 1]) {
                return binarySearch(mat, m, target, mid);
            }

            if (target > mat[mid][0]) {
                l = mid + 1;
            }
            if (target < mat[mid][0]) {
                r = mid - 1;
            }
        }
        return new Found(false, new int[]{});
    }

    public static Found binarySearch(int[][] mat, int m, int target, int x) {
        int l = 0, r = m - 1, mid;

        while (l <= r) {
            mid = (l + r) / 2;

            if (target == mat[x][mid]) {
                return new Found(true, new int[]{x, mid});
            }

            if (target > mat[x][mid]) {
                l = mid + 1;
            }

            if (target < mat[x][mid]) {
                r = mid - 1;
            }
        }
        return new Found(false, new int[]{});
    }
}
