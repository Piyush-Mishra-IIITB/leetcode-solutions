class Solution {
    public class pair{
        int row;
        int col;
        int time;
        public pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;

        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b) -> a.time- b.time);
        int n=grid.length;
        int m=grid[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=grid[0][0];
        pq.add(new pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int r=p.row;
            int c=p.col;
            int t=p.time;
            if(r==n-1 && c==m-1){
                return t;
            }
            if(r+1<n){
                int newt=Math.max(grid[r+1][c],t);
                if(dist[r+1][c]>newt){
                    pq.add(new pair(r+1,c,newt));
                    dist[r+1][c]=newt;
                }
            }
            if(r-1>=0){
                int newt=Math.max(grid[r-1][c],t);
                if(dist[r-1][c]>newt){
                    pq.add(new pair(r-1,c,newt));
                    dist[r-1][c]=newt;
                }
            }
            if(c+1<m){
                int newt=Math.max(grid[r][c+1],t);
                if(dist[r][c+1]>newt){
                    pq.add(new pair(r,c+1,newt));
                    dist[r][c+1]=newt;
                }
            }
            if(c-1>=0){
                int newt=Math.max(grid[r][c-1],t);
                if(dist[r][c-1]>newt){
                    pq.add(new pair(r,c-1,newt));
                    dist[r][c-1]=newt;
                }
            }
        }
        return dist[n-1][m-1];
    }
}