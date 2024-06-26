package src;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] inp = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(iterateMatrixSpirally(inp));
    }

    public static List<Integer> iterateMatrixSpirally(int[][] inp) {
        int n = inp.length, m = inp[0].length, di = 0, x = 0, y = 0;
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int i = 0; i < n * m; i++) {
            ans.add(inp[x][y]);
            visited[x][y] = true;

            int cr = x + dr[di];
            int cc = y + dc[di];

            if (0 <= cr && cr < n && 0 <= cc && cc < m && !visited[cr][cc]){
                x = cr;
                y = cc;
            }else{
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }
}
