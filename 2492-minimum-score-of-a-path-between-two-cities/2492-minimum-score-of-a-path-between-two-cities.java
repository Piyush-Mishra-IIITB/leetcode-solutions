class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] a:roads){
            int u=a[0];
            int v=a[1];
            int d=a[2];

            adj.get(u).add(new int[]{v,d});
            adj.get(v).add(new int[]{u,d});
        }

        boolean[] vis=new boolean[n+1];
        Queue<Integer> qq=new LinkedList<>();

        qq.add(1);
        vis[1]=true;

        int ans=Integer.MAX_VALUE;

        while(!qq.isEmpty()){
            int curr=qq.poll();

            for(int[] it:adj.get(curr)){
                ans=Math.min(ans,it[1]);

                if(!vis[it[0]]){
                    vis[it[0]]=true;
                    qq.add(it[0]);
                }
            }
        }

        return ans;
    }
}