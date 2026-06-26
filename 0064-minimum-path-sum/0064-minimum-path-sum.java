class Solution {

    class Pair {
        int row, col, val;

        Pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];
        pq.add(new Pair(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int r = cur.row;
            int c = cur.col;
            int d = cur.val;

            if (r == n - 1 && c == m - 1)
                return d;

            if (r + 1 < n && dist[r + 1][c] > d + grid[r + 1][c]) {
                dist[r + 1][c] = d + grid[r + 1][c];
                pq.add(new Pair(r + 1, c, dist[r + 1][c]));
            }

            if (c + 1 < m && dist[r][c + 1] > d + grid[r][c + 1]) {
                dist[r][c + 1] = d + grid[r][c + 1];
                pq.add(new Pair(r, c + 1, dist[r][c + 1]));
            }
        }

        return dist[n - 1][m - 1];
    }
}