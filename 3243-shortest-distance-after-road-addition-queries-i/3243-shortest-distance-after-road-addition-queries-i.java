class Solution {
    public class pair{
        int node;
        int dist;
        public pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            adj.get(i-1).add(i);
        }
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int a[]=queries[i];
            int u=a[0];
            int v=a[1];
            adj.get(u).add(v);
            ans[i]=helper(adj,n);
        }
        return ans;
    }
    public int helper(List<List<Integer>>adj,int n){
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new pair(0,0));
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int no=p.node;
            int d=p.dist;
            if(dist[no]<d){
                continue;
            }
            for(Integer it:adj.get(no)){
                if(dist[it]>d+1){
                    dist[it]=d+1;
                    pq.add(new pair(it,d+1));
                }
            }
        }
        return dist[n-1];
    }
}