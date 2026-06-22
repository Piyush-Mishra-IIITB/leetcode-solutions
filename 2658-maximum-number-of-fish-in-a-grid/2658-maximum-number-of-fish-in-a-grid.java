class Solution {

    public class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int findMaxFish(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] > 0 && !vis[i][j]) {

                    int fish = 0;

                    Queue<Pair> qq = new LinkedList<>();
                    qq.add(new Pair(i, j));
                    vis[i][j] = true;

                    while (!qq.isEmpty()) {

                        Pair p = qq.poll();
                        int r = p.row;
                        int c = p.col;

                        fish += grid[r][c];

                        if (r + 1 < n && grid[r + 1][c] > 0 && !vis[r + 1][c]) {
                            vis[r + 1][c] = true;
                            qq.add(new Pair(r + 1, c));
                        }

                        if (r - 1 >= 0 && grid[r - 1][c] > 0 && !vis[r - 1][c]) {
                            vis[r - 1][c] = true;
                            qq.add(new Pair(r - 1, c));
                        }

                        if (c + 1 < m && grid[r][c + 1] > 0 && !vis[r][c + 1]) {
                            vis[r][c + 1] = true;
                            qq.add(new Pair(r, c + 1));
                        }

                        if (c - 1 >= 0 && grid[r][c - 1] > 0 && !vis[r][c - 1]) {
                            vis[r][c - 1] = true;
                            qq.add(new Pair(r, c - 1));
                        }
                    }

                    ans = Math.max(ans, fish);
                }
            }
        }

        return ans;
    }
}