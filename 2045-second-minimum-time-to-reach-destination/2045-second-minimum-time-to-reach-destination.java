class Solution {
    public class pair{
        int dist;
        int node;
        public pair(int dist,int node){
            this.dist=dist;
            this.node=node;
        }
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
         int dist1[]=new int[n];

         int dist2[]=new int[n];
         Arrays.fill(dist1, Integer.MAX_VALUE);
Arrays.fill(dist2, Integer.MAX_VALUE);
         List<List<Integer>>adj=new ArrayList<>();
         for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }
         for(int i=0;i<edges.length;i++){
            int a[]=edges[i];
            int u=a[0]-1;
            int v=a[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
         }
         dist1[0]=0;
         PriorityQueue<pair>pq=new PriorityQueue<>((a,b) -> a.dist-b.dist);
         pq.add(new pair(0,0));
         while(!pq.isEmpty()){
            pair p=pq.poll();
            int d=p.dist;
            int no=p.node;
            int newtime=0;
            if((d/change)%2==0){
                newtime=d;
            }else{
                newtime=((d/change)+1)*change;
            }
            for(Integer it:adj.get(no)){
                if(dist1[it]>newtime+time){
                    dist2[it]=dist1[it];
                    dist1[it]=newtime+time;
                    pq.add(new pair(newtime+time,it));
                }
                else if(dist1[it]<newtime+time && newtime+time<dist2[it]){
                    dist2[it]=newtime+time;
                    pq.add(new pair(newtime+time,it));
                }
            }
         }
         return dist2[n-1];
    }
}