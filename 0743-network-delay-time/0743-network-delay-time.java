
class Solution {
    public class pair{
        int val;
        int dist;
        public pair(int val,int dist){
            this.val=val;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
    PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->(a.dist-b.dist));
    pq.add(new pair(k,0));
    int dis[]=new int[n+1];
    for(int i=0;i<n+1;i++){
        dis[i]=Integer.MAX_VALUE;
    }
    dis[0]=0;
    dis[k]=0;
    while(!pq.isEmpty()){
        pair p=pq.poll();
        int val=p.val;
        int dist=p.dist;
        if(dis[val]>dist){
            continue;
        }
        for(int i=0;i<times.length;i++){
            if(times[i][0]==val){
                int next=times[i][1];
                int d=times[i][2];
                if(dis[next]>dist+d){
                    dis[next]=dist+d;
                    pq.add(new pair(next,dist+d));
                }
            }
        }

    }
    int ans=-1;
    for(int i=0;i<n+1;i++){
     ans=Math.max(ans,dis[i]);
    }
        return ans==Integer.MAX_VALUE ? -1:ans;
}}
