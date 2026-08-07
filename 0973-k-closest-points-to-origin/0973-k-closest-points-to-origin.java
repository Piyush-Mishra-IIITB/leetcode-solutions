class Solution {
    public class pair{
        int row;
        int col;
        int dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int ans[][]=new int[k][2];

        for(int i=0;i<points.length;i++){
            int a[]=points[i];
            int u=a[0];
            int v=a[1];
            int d = u * u + v * v;
            pq.add(new pair(u,v,d));
        }
        int i=0;
        int l=0;
        while(l<k){
            pair p=pq.poll();
            int a=p.row;
            int b=p.col;
            ans[i][0]=a;
            ans[i][1]=b;
            i++;
            l++;
        }
        return ans;
    }
}