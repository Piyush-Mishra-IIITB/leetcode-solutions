class Solution {

    class State {
        int r, c, mask;

        State(int r, int c, int mask) {
            this.r = r;
            this.c = c;
            this.mask = mask;
        }
    }

    public int shortestPathAllKeys(String[] grid) {

        int m = grid.length;
        int n = grid[0].length();

        int startR = 0;
        int startC = 0;
        int totalKeys = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = grid[i].charAt(j);

                if (ch == '@') {
                    startR = i;
                    startC = j;
                }

                if (ch >= 'a' && ch <= 'f') {
                    totalKeys = Math.max(totalKeys, ch - 'a' + 1);
                }
            }
        }

        int finalMask = (1 << totalKeys) - 1;

        Queue<State> q = new LinkedList<>();

        boolean[][][] vis = new boolean[m][n][1 << totalKeys];

        q.offer(new State(startR, startC, 0));
        vis[startR][startC][0] = true;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                State curr = q.poll();
                int r = curr.r;
                int c = curr.c;
                int mask = curr.mask;
                if (mask == finalMask) {
                    return steps;
                }
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                        continue;
                    }
                    char ch = grid[nr].charAt(nc);
                    if (ch == '#') {
                        continue;
                    }
                    int newMask = mask;
                    if (ch >= 'a' && ch <= 'f') {
                        newMask |= (1 << (ch - 'a'));
                    }
                    if (ch >= 'A' && ch <= 'F') {

                        if ((newMask & (1 << (ch - 'A'))) == 0) {
                            continue;
                        }
                    }

                    if (!vis[nr][nc][newMask]) {

                        vis[nr][nc][newMask] = true;
                        q.offer(new State(nr, nc, newMask));
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}