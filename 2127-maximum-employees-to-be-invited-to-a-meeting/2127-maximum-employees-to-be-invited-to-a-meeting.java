class Solution {
    public int maximumInvitations(int[] favorite) {

        int n = favorite.length;

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] depth = new int[n];
        Arrays.fill(depth, 1);

        while (!q.isEmpty()) {
            int u = q.poll();

            int v = favorite[u];

            depth[v] = Math.max(depth[v], depth[u] + 1);

            indegree[v]--;

            if (indegree[v] == 0) {
                q.offer(v);
            }
        }

        int pairSum = 0;

        for (int i = 0; i < n; i++) {
            int j = favorite[i];

            if (favorite[j] == i && i < j) {
                pairSum += depth[i] + depth[j];
            }
        }

        int largestCycle = 0;

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (indegree[i] > 0 && !vis[i]) {

                int curr = i;
                int len = 0;

                while (!vis[curr]) {
                    vis[curr] = true;
                    curr = favorite[curr];
                    len++;
                }

                largestCycle = Math.max(largestCycle, len);
            }
        }

        return Math.max(largestCycle, pairSum);
    }
}