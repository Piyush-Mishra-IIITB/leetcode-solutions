class Solution {
    class State {
        int r, c, energy, mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();

        int sr = 0, sc = 0;
        int[][] id = new int[n][m];

        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = cnt++;
                }
            }
        }

        if (cnt == 0) {
            return 0;
        }

        int fullMask = (1 << cnt) - 1;

        Queue<State> q = new LinkedList<>();
        q.add(new State(sr, sc, energy, fullMask));

        boolean[][][][] visited =
            new boolean[n][m][energy + 1][1 << cnt];

        visited[sr][sc][energy][fullMask] = true;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                State cur = q.poll();

                if (cur.mask == 0) {
                    return moves;
                }

                if (cur.energy == 0) {
                    continue;
                }

                for (int[] d : dir) {
                    int nr = cur.r + d[0];
                    int nc = cur.c + d[1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }

                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int newEnergy = cur.energy - 1;
                    int newMask = cur.mask;

                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    if (classroom[nr].charAt(nc) == 'L') {
                        int bit = id[nr][nc];
                        newMask &= ~(1 << bit);
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {
                        visited[nr][nc][newEnergy][newMask] = true;
                        q.add(new State(nr, nc, newEnergy, newMask));
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}