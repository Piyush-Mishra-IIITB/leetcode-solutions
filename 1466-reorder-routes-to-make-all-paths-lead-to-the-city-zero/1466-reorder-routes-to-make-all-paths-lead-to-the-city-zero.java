class Solution {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    int changed = 0;
    public int minReorder(int n, int[][] connections) {
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<int[]>());
        }
        for(int[] conn: connections){
            graph.get(conn[0]).add(new int[]{conn[1], 0});
            graph.get(conn[1]).add(new int[]{conn[0], 1});
        }
        dfs(0);
        return changed;
    }
    void dfs(int x){
        set.add(x);
        for(int[] conn: graph.get(x)){
            if(set.contains(conn[0])) continue;
            if(conn[1] == 0){
                changed++;
                dfs(conn[0]);
            } else {
                dfs(conn[0]);
            }
        }
    }
}