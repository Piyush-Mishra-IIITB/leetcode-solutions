class Solution {
    public int findShortestCycle(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {

            int[] dist = new int[n];
            Arrays.fill(dist, -1);

            int[] parent = new int[n];
            Arrays.fill(parent, -1);

            Queue<Integer> q = new LinkedList<>();

            q.offer(start);
            dist[start] = 0;

            while (!q.isEmpty()) {

                int node = q.poll();

                for (int next : adj.get(node)) {

                    if (dist[next] == -1) {
                        dist[next] = dist[node] + 1;
                        parent[next] = node;
                        q.offer(next);
                    }
                    else if (parent[node] != next) {
                        ans = Math.min(ans,
                                dist[node] + dist[next] + 1);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}