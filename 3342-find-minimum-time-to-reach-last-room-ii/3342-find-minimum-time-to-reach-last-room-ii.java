class Solution {
     public class pair{
        int row;
        int col;
        int dist;
        int moves;
        public pair(int row,int col,int dist,int moves){
            this.row=row;
            this.col=col;
            this.dist=dist;
            this.moves=moves;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
        int n=moveTime.length;
        int m=moveTime[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        pq.add(new pair(0,0,0,0));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int r=p.row;
            int c=p.col;
            int d=p.dist;
            int mo=p.moves;
            if(r==n-1 && c==m-1){
                return d;
            }
            if(d>dist[r][c]){
                continue;
            }
            if(r+1<n){
                int newD=Math.max(moveTime[r+1][c]+1,d+1);
                if(mo%2!=0){
                    newD++;
                }
                if(dist[r+1][c]>newD){
                    dist[r+1][c]=newD;
                    pq.add(new pair(r+1,c,newD,mo+1));
                }
            }
            if(r-1>=0){
                int newD=Math.max(moveTime[r-1][c]+1,d+1);
                if(mo%2!=0){
                    newD++;
                }
                if(dist[r-1][c]>newD){
                    dist[r-1][c]=newD;
                    pq.add(new pair(r-1,c,newD,mo+1));
                }
            }
            if(c+1<m){
                int newD=Math.max(moveTime[r][c+1]+1,d+1);
                if(mo%2!=0){
                    newD++;
                }
                if(dist[r][c+1]>newD){
                    dist[r][c+1]=newD;
                    pq.add(new pair(r,c+1,newD,mo+1));
                }
            }
            if(c-1>=0){
                int newD=Math.max(moveTime[r][c-1]+1,d+1);
                if(mo%2!=0){
                    newD++;
                }
                if(dist[r][c-1]>newD){
                    dist[r][c-1]=newD;
                    pq.add(new pair(r,c-1,newD,mo+1));
                }
            }
        }
        return -1;
    }
}