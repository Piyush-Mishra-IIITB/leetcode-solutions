class Solution {

    public class Pair {
        int row;
        int col;
        int steps;
        int kLeft;

        public Pair(int row, int col, int steps, int kLeft) {
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.kLeft = kLeft;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][][] vis = new boolean[n][m][k + 1];
        q.add(new Pair(0, 0, 0, k));
        vis[0][0][k] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int steps = p.steps;
            int rem = p.kLeft;

            if (r == n - 1 && c == m - 1) {
                return steps;
            }
            if (r + 1 < n) {
                int newRem = rem - grid[r + 1][c];

                if (newRem >= 0 && !vis[r + 1][c][newRem]) {
                    vis[r + 1][c][newRem] = true;
                    q.add(new Pair(r + 1, c, steps + 1, newRem));
                }
            }
            if (r - 1 >= 0) {
                int newRem = rem - grid[r - 1][c];

                if (newRem >= 0 && !vis[r - 1][c][newRem]) {
                    vis[r - 1][c][newRem] = true;
                    q.add(new Pair(r - 1, c, steps + 1, newRem));
                }
            }
            if (c + 1 < m) {
                int newRem = rem - grid[r][c + 1];

                if (newRem >= 0 && !vis[r][c + 1][newRem]) {
                    vis[r][c + 1][newRem] = true;
                    q.add(new Pair(r, c + 1, steps + 1, newRem));
                }
            }
            if (c - 1 >= 0) {
                int newRem = rem - grid[r][c - 1];

                if (newRem >= 0 && !vis[r][c - 1][newRem]) {
                    vis[r][c - 1][newRem] = true;
                    q.add(new Pair(r, c - 1, steps + 1, newRem));
                }
            }
        }

        return -1;
    }
}