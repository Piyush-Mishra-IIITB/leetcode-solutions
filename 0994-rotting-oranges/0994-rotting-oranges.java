class Solution {
    public class pair{
        int val;
        int row;
        int col;
        public pair(int val,int row,int col){
            this.val=val;
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<pair> qq = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int fresh = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    qq.add(new pair(2,i,j));
                    vis[i][j]=true;
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) {return 0;}
        int time = -1;
        while(!qq.isEmpty()){
            int size = qq.size();
            for(int i=0;i<size;i++){
                pair curr = qq.poll();
                int row = curr.row;
                int col = curr.col;
                if(row+1<grid.length && !vis[row+1][col] && grid[row+1][col]==1){
                    qq.add(new pair(2,row+1,col));
                    vis[row+1][col]=true;
                    fresh--;
                }
                if(row-1>=0 && !vis[row-1][col] && grid[row-1][col]==1){
                    qq.add(new pair(2,row-1,col));
                    vis[row-1][col]=true;
                    fresh--;
                }
                if(col+1<grid[0].length && !vis[row][col+1] && grid[row][col+1]==1){
                    qq.add(new pair(2,row,col+1));
                    vis[row][col+1]=true;
                    fresh--;
                }
                if(col-1>=0 && !vis[row][col-1] && grid[row][col-1]==1){
                    qq.add(new pair(2,row,col-1));
                    vis[row][col-1]=true;
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}