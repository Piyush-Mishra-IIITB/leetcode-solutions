class Solution {
    public class pair {
        int row;
        int col;
        int time;

        public pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int minimumTime(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (n > 1 && m > 1 && grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<pair> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);

        int dist[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        pq.add(new pair(0, 0, 0));

        while (!pq.isEmpty()) {

            pair p = pq.poll();

            int r = p.row;
            int c = p.col;
            int t = p.time;
            System.out.println(r + " " + c + " " + t);
            if (t > dist[r][c]) {
                continue;
            }

            if (r == n - 1 && c == m - 1) {
                return t;
            }
            if (r + 1 < n) {

                int nt;

                if (grid[r + 1][c] <= t + 1) {
                    nt = t + 1;
                } else {
                    nt = grid[r + 1][c];

                    if ((nt - (t + 1)) % 2 != 0) {
                        nt++;
                    }
                }

                if (nt < dist[r + 1][c]) {
                    dist[r + 1][c] = nt;
                    pq.add(new pair(r + 1, c, nt));
                }
            }
            if (r - 1 >= 0) {

                int nt;

                if (grid[r - 1][c] <= t + 1) {
                    nt = t + 1;
                } else {
                    nt = grid[r - 1][c];

                    if ((nt - (t + 1)) % 2 != 0) {
                        nt++;
                    }
                }

                if (nt < dist[r - 1][c]) {
                    dist[r - 1][c] = nt;
                    pq.add(new pair(r - 1, c, nt));
                }
            }
            if (c + 1 < m) {

                int nt;

                if (grid[r][c + 1] <= t + 1) {
                    nt = t + 1;
                } else {
                    nt = grid[r][c + 1];

                    if ((nt - (t + 1)) % 2 != 0) {
                        nt++;
                    }
                }

                if (nt < dist[r][c + 1]) {
                    dist[r][c + 1] = nt;
                    pq.add(new pair(r, c + 1, nt));
                }
            }
            if (c - 1 >= 0) {

                int nt;

                if (grid[r][c - 1] <= t + 1) {
                    nt = t + 1;
                } else {
                    nt = grid[r][c - 1];

                    if ((nt - (t + 1)) % 2 != 0) {
                        nt++;
                    }
                }

                if (nt < dist[r][c - 1]) {
                    dist[r][c - 1] = nt;
                    pq.add(new pair(r, c - 1, nt));
                }
            }
        }

        return -1;
    }
}