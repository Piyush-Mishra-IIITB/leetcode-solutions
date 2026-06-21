import java.util.*;

class Solution {

    class Pair {
        int row;
        int col;
        int cost;

        Pair(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            int r = cur.row;
            int c = cur.col;
            int cost = cur.cost;

            if (cost > dist[r][c]) {
                continue;
            }

            if (r == n - 1 && c == m - 1) {
                return cost;
            }
            if (c + 1 < m) {
                int newCost = cost;
                if (grid[r][c] != 1) {
                    newCost++;
                }

                if (newCost < dist[r][c + 1]) {
                    dist[r][c + 1] = newCost;
                    pq.offer(new Pair(r, c + 1, newCost));
                }
            }
            if (c - 1 >= 0) {
                int newCost = cost;
                if (grid[r][c] != 2) {
                    newCost++;
                }

                if (newCost < dist[r][c - 1]) {
                    dist[r][c - 1] = newCost;
                    pq.offer(new Pair(r, c - 1, newCost));
                }
            }
            if (r + 1 < n) {
                int newCost = cost;
                if (grid[r][c] != 3) {
                    newCost++;
                }

                if (newCost < dist[r + 1][c]) {
                    dist[r + 1][c] = newCost;
                    pq.offer(new Pair(r + 1, c, newCost));
                }
            }
            if (r - 1 >= 0) {
                int newCost = cost;
                if (grid[r][c] != 4) {
                    newCost++;
                }

                if (newCost < dist[r - 1][c]) {
                    dist[r - 1][c] = newCost;
                    pq.offer(new Pair(r - 1, c, newCost));
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}