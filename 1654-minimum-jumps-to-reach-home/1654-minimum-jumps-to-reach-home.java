class Solution {

    class Pair {
        int pos;
        int back;

        Pair(int pos, int back) {
            this.pos = pos;
            this.back = back;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        boolean[] forbid = new boolean[6001];

        for (int f : forbidden) {
            forbid[f] = true;
        }

        boolean[][] vis = new boolean[6001][2];

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0));
        vis[0][0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                int pos = curr.pos;
                int back = curr.back;

                if (pos == x) {
                    return steps;
                }
                int forward = pos + a;

                if (forward <= 6000 &&
                    !forbid[forward] &&
                    !vis[forward][0]) {

                    vis[forward][0] = true;
                    q.offer(new Pair(forward, 0));
                }
                int backward = pos - b;

                if (back == 0 &&
                    backward >= 0 &&
                    !forbid[backward] &&
                    !vis[backward][1]) {

                    vis[backward][1] = true;
                    q.offer(new Pair(backward, 1));
                }
            }

            steps++;
        }

        return -1;
    }
}