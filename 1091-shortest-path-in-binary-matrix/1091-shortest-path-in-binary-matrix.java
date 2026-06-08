
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
    public int shortestPathBinaryMatrix(int[][] grid) {
     Queue<pair>qq=new LinkedList<>();
     int n=grid.length;
     int m=grid[0].length;
     if(grid[0][0]==1|| grid[n-1][m-1]==1){
        return -1;
     }
     qq.add(new pair(0,0,1));
     int dis[][]=new int[n][m];
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            dis[i][j]=Integer.MAX_VALUE;
        }
     }
    dis[0][0]=1;
     while(!qq.isEmpty()){
        pair p=qq.poll();
        int row=p.row;
        int col=p.col;
        int dist=p.dist;
        if(dis[row][col]<dist){
            continue;
        }
        if(row+1<n && grid[row+1][col]==0 && dis[row+1][col]>dist+1){
            dis[row+1][col]=dist+1;
            qq.add(new pair(row+1,col,dist+1));
        }
        if(row-1>=0 && grid[row-1][col]==0 && dis[row-1][col]>dist+1){
            dis[row-1][col]=dist+1;
            qq.add(new pair(row-1,col,dist+1));
        }
        if(col-1>=0 && grid[row][col-1]==0 && dis[row][col-1]>dist+1){
            dis[row][col-1]=dist+1;
            qq.add(new pair(row,col-1,dist+1));
        }
        if(col+1<m && grid[row][col+1]==0 && dis[row][col+1]>dist+1){
            dis[row][col+1]=dist+1;
            qq.add(new pair(row,col+1,dist+1));
        }
        if(row+1<n && col+1<m && grid[row+1][col+1]==0 && dis[row+1][col+1]>dist+1){
            dis[row+1][col+1]=dist+1;
            qq.add(new pair(row+1,col+1,dist+1));
        }
        if(row+1<n&& col-1>=0 && grid[row+1][col-1]==0 && dis[row+1][col-1]>dist+1){
            dis[row+1][col-1]=dist+1;
            qq.add(new pair(row+1,col-1,dist+1));
        }
        if(row-1>=0 && col+1<m && grid[row-1][col+1]==0 && dis[row-1][col+1]>dist+1){
            dis[row-1][col+1]=dist+1;
            qq.add(new pair(row-1,col+1,dist+1));
        }if(row-1>=0 && col-1>=0 && grid[row-1][col-1]==0 && dis[row-1][col-1]>dist+1){
            dis[row-1][col-1]=dist+1;
            qq.add(new pair(row-1,col-1,dist+1));
        }
     }
     return dis[n-1][m-1]==Integer.MAX_VALUE ? -1: dis[n-1][m-1];
    }
}
