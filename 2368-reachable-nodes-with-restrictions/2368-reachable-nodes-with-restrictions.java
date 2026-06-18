class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a[]=edges[i];
            int u=a[0];
            int v=a[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        for(int i=0;i<restricted.length;i++){
            int c=restricted[i];
            vis[c]=true;
        }
        if(vis[0]){
            return 0;
        }
        Queue<Integer>qq=new LinkedList<>();
        qq.add(0);
        vis[0]=true;
        int no=0;
        while(!qq.isEmpty()){
            int curr=qq.poll();
            no++;
            for(Integer it:adj.get(curr)){
                if(vis[it]==false){
                    qq.add(it);
                    vis[it]=true;
                }
            }
        }
        return no;
    }
}