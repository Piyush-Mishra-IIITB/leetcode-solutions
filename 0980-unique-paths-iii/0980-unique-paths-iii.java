class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startRow=0;
        int startCol=0;
        int n=grid.length;
        int m=grid[0].length;
        int no=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    startRow=i;
                    startCol=j;
                }
                if(grid[i][j]==0){
                    no++;
                }
            }
        }
        boolean vis[][]=new boolean[n][m];
        return helper(n,m,startRow,startCol,grid,vis,no);
    }
    public int helper(int n,int m,int i,int j,int grid[][],boolean vis[][],int no){
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==-1 || vis[i][j]){
            return 0;
        }
        
        if(grid[i][j]==2){
            if(no==0){
                return 1;
            }else{
                return 0;
            }
        }
          int nextNo = no;
          if (grid[i][j] == 0) {
          nextNo--;
          }

        vis[i][j]=true;
        int r=helper(n,m,i+1,j,grid,vis,nextNo);
        int l=helper(n,m,i-1,j,grid,vis,nextNo);
        int u=helper(n,m,i,j+1,grid,vis,nextNo);
        int b=helper(n,m,i,j-1,grid,vis,nextNo);
        vis[i][j]=false;
        return r+l+u+b;
    }
}