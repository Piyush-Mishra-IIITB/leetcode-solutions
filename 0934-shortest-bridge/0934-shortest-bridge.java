class Solution {
    int n, m;
    Queue<int[]> q = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean found = false;

        // Find and mark the first island
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    found = true;
                    break;
                }
            }
        }

        // Multi-source BFS
        int level = 0;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    // Reached second island
                    if (grid[nx][ny] == 1) {
                        return level;
                    }

                    // Expand through water
                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }

            level++;
        }

        return -1;
    }

    public void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        q.offer(new int[]{i, j});

        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}