class Solution {
    public class pair{
        int dist;
        int row;
        int col;
        public pair(int dist,int row,int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b) ->a.dist-b.dist);
        pq.add(new pair(0,0,0));
        int n=grid.length;
        int m=grid[0].length;
        int dist[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int d=p.dist;
            int r=p.row;
            int c=p.col;
            if(d>dist[r][c]){
                continue;
            }
            if(r+1<n && dist[r+1][c]>d+grid[r+1][c]){
                dist[r+1][c]=d+grid[r+1][c];
                pq.add(new pair(d+grid[r+1][c],r+1,c));
            }
            if(r-1>=0 && dist[r-1][c]>d+grid[r-1][c]){
                dist[r-1][c]=d+grid[r-1][c];
                pq.add(new pair(d+grid[r-1][c],r-1,c));
            }
            if(c+1<m && dist[r][c+1]>d+grid[r][c+1]){
                dist[r][c+1]=d+grid[r][c+1];
                pq.add(new pair(d+grid[r][c+1],r,c+1));
            }
            if(c-1>=0 && dist[r][c-1]>d+grid[r][c-1]){
                dist[r][c-1]=d+grid[r][c-1];
                pq.add(new pair(d+grid[r][c-1],r,c-1));
            }

        }
        return dist[n-1][m-1];
    }
}