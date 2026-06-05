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
    public int[][] highestPeak(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int d[][]=new int[n][m];
        boolean vis[][]=new boolean[n][m];
        Queue<pair>qq=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    vis[i][j]=true;
                    d[i][j]=0;
                    qq.add(new pair(i,j,0));
                }
            }
        }

        while(!qq.isEmpty()){
            pair curr=qq.poll();
            int row=curr.row;
            int col=curr.col;
            int dist=curr.dist;
            if(row+1<n && vis[row+1][col]==false){
                vis[row+1][col]=true;
                qq.add(new pair(row+1,col,dist+1));
                d[row+1][col]=dist+1;
            }
            if(row-1>=0 && vis[row-1][col]==false){
                vis[row-1][col]=true;
                qq.add(new pair(row-1,col,dist+1));
                d[row-1][col]=dist+1;
            }
            if(col+1<m && vis[row][col+1]==false){
                vis[row][col+1]=true;
                qq.add(new pair(row,col+1,dist+1));
                d[row][col+1]=dist+1;
            }if(col-1>=0 && vis[row][col-1]==false){
                vis[row][col-1]=true;
                qq.add(new pair(row,col-1,dist+1));
                d[row][col-1]=dist+1;
            }
        }
        return d;
    }
}