class Solution {
    public class pair{
        int row;
        int col;
        int dis;
        public pair(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] arr) {
        Queue<pair>qq=new LinkedList<>();
        int n=arr.length;
        int m=arr[0].length;
        int dist[][]=new int [n][m];
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    qq.add(new pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        while(!qq.isEmpty()){
            pair p=qq.poll();
            int r=p.row;
            int c=p.col;
            int d=p.dis;
            if(r+1<n){
                if(vis[r+1][c]==false){
                    vis[r+1][c]=true;
                    dist[r+1][c]=d+1;
                    qq.add(new pair(r+1,c,d+1));
                }
            }
            if(r-1>=0){
                if(vis[r-1][c]==false){
                    vis[r-1][c]=true;
                    dist[r-1][c]=d+1;
                    qq.add(new pair(r-1,c,d+1));
                }
            }
            if(c+1<m){
                if(vis[r][c+1]==false){
                    vis[r][c+1]=true;
                    dist[r][c+1]=d+1;
                    qq.add(new pair(r,c+1,d+1));
                }
            }
            if(c-1>=0){
                if(vis[r][c-1]==false){
                    vis[r][c-1]=true;
                    dist[r][c-1]=d+1;
                    qq.add(new pair(r,c-1,d+1));
                }
            }

        }
        return dist;
    }
    
}