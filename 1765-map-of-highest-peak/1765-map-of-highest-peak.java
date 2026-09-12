class Solution {
    public class pair {
        int row;
        int col;
        int val;

        public pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int[][] highestPeak(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] ans = new int[n][m];
        Queue<pair> qq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 1) {
                    qq.add(new pair(i, j, 0));
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;  // unvisited
                }
            }
        }

        while (!qq.isEmpty()) {
            pair p = qq.poll();

            int r = p.row;
            int c = p.col;

            if (r + 1 < n && ans[r + 1][c] == -1) {
                ans[r + 1][c] = p.val + 1;
                qq.add(new pair(r + 1, c, p.val + 1));
            }

            if (r - 1 >= 0 && ans[r - 1][c] == -1) {
                ans[r - 1][c] = p.val + 1;
                qq.add(new pair(r - 1, c, p.val + 1));
            }

            if (c + 1 < m && ans[r][c + 1] == -1) {
                ans[r][c + 1] = p.val + 1;
                qq.add(new pair(r, c + 1, p.val + 1));
            }

            if (c - 1 >= 0 && ans[r][c - 1] == -1) {
                ans[r][c - 1] = p.val + 1;
                qq.add(new pair(r, c - 1, p.val + 1));
            }
        }

        return ans;
    }
}