class Solution {
    public class pair{
        int row;
        int col;
        int health;
        public pair(int row,int col,int health){
            this.row=row;
            this.col=col;
            this.health=health;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        
        int n=grid.size();
        int m=grid.get(0).size();
        int grids[][]=new int[n][m];
        for(int i=0;i<grid.size();i++){
            List<Integer>ll=grid.get(i);
            for(int j=0;j<ll.size();j++){
                grids[i][j]=ll.get(j);
            }
        }
        boolean vis[][][]=new boolean[n][m][health+1];
        Queue<pair>qq=new LinkedList<>();
        int start=grids[0][0];
        if(start==0){
              qq.add(new pair(0,0,health));
              vis[0][0][health]=true;
        }else{
            if(health-1==0){
                return false;
            }
            qq.add(new pair(0,0,health-1));
            vis[0][0][health-1]=true;
            
        }


    while(!qq.isEmpty()){
        pair p=qq.poll();
        int r=p.row;
        int c=p.col;
        int h=p.health;
        if(r==n-1 && c==m-1){
            return true;
        }
        if(r+1<n){
            int newH=h-grids[r+1][c];
            if(newH>=1 && vis[r+1][c][newH]==false){
                vis[r+1][c][newH]=true;
                qq.add(new pair(r+1,c,newH));
            }
        }if(r-1>=0){
            int newH=h-grids[r-1][c];
            if(newH>=1 && vis[r-1][c][newH]==false){
                vis[r-1][c][newH]=true;
                qq.add(new pair(r-1,c,newH));
            }
        }
        if(c+1<m){
            int newH=h-grids[r][c+1];
            if(newH>=1 && vis[r][c+1][newH]==false){
                vis[r][c+1][newH]=true;
                qq.add(new pair(r,c+1,newH));
            }
        }
        if(c-1>=0){
            int newH=h-grids[r][c-1];
            if(newH>=1 && vis[r][c-1][newH]==false){
                vis[r][c-1][newH]=true;
                qq.add(new pair(r,c-1,newH));
            }
        }
    }
     return false;
    }
}