class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        if (n == 1) return 0;

        int finalMask = (1 << n) - 1;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][1 << n];

        for (int i = 0; i < n; i++) {
            int mask = 1 << i;

            q.offer(new int[]{i, mask});
            vis[i][mask] = true;
        }

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int node = curr[0];
                int mask = curr[1];

                if (mask == finalMask)
                    return steps;

                for (int nei : graph[node]) {

                    int newMask = mask | (1 << nei);

                    if (!vis[nei][newMask]) {

                        vis[nei][newMask] = true;
                        q.offer(new int[]{nei, newMask});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}