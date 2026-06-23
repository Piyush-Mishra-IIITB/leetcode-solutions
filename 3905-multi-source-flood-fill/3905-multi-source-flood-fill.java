import java.util.*;

class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {

        Arrays.sort(sources, (a, b) -> b[2] - a[2]);

        int[][] grid = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int[] s : sources) {
            int r = s[0];
            int c = s[1];
            int color = s[2];

            grid[r][c] = color;
            q.offer(new Pair(r, c));
        }

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int r = cur.row;
            int c = cur.col;
            if (r - 1 >= 0 && grid[r - 1][c] == 0) {
                grid[r - 1][c] = grid[r][c];
                q.offer(new Pair(r - 1, c));
            }
            if (r + 1 < n && grid[r + 1][c] == 0) {
                grid[r + 1][c] = grid[r][c];
                q.offer(new Pair(r + 1, c));
            }
            if (c - 1 >= 0 && grid[r][c - 1] == 0) {
                grid[r][c - 1] = grid[r][c];
                q.offer(new Pair(r, c - 1));
            }
            if (c + 1 < m && grid[r][c + 1] == 0) {
                grid[r][c + 1] = grid[r][c];
                q.offer(new Pair(r, c + 1));
            }
        }

        return grid;
    }
}