class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<Integer>[] adj = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] d : dislikes) {
            adj[d[0]].add(d[1]);
            adj[d[1]].add(d[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for(int i = 1; i <= n; i++) {

            if(color[i] != -1) continue;

            Queue<Integer> q = new LinkedList<>();

            q.offer(i);
            color[i] = 0;

            while(!q.isEmpty()) {

                int node = q.poll();

                for(int nei : adj[node]) {

                    if(color[nei] == -1) {
                        color[nei] = 1 - color[node];
                        q.offer(nei);
                    }
                    else if(color[nei] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}