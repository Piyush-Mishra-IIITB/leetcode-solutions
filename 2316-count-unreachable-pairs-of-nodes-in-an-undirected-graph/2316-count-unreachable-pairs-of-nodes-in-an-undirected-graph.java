class Solution {
    public long countPairs(int n, int[][] edges) {

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

        boolean[] vis = new boolean[n];
        List<Integer> componentSizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int size = dfs(i, adj, vis);
                componentSizes.add(size);
            }
        }

        long ans = 0;
        long remaining = n;

        for (int size : componentSizes) {
            remaining -= size;
            ans += (long) size * remaining;
        }

        return ans;
    }

    public int dfs(int node, List<List<Integer>> adj, boolean[] vis) {

        vis[node] = true;
        int size = 1;

        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                size += dfs(neighbour, adj, vis);
            }
        }

        return size;
    }
}