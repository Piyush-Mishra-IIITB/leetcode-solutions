class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {

        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean[] vis = new boolean[n];
        return dfs(source, dest, adj, vis);
    }

    public boolean dfs(int node, int dest,
                       List<Integer>[] adj,
                       boolean[] vis) {

        if(node == dest) {
            return true;
        }
        vis[node] = true;
        for(int nei : adj[node]) {
            if(!vis[nei]) {
                if(dfs(nei, dest, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}