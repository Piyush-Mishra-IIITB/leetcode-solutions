class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                helper(grid,n,m,i,0);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==0){
                helper(grid,n,m,0,i);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[n-1][i]==0){
                helper(grid,n,m,n-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==0){
                helper(grid,n,m,i,m-1);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    count++;
                    helper(grid,n,m,i,j);
                }
            }
        }
        return count;
    }
    public void helper(int grid[][],int n,int m,int i,int j){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==1){
            return ;
        }
        grid[i][j]=1;
        helper(grid,n,m,i+1,j);
        helper(grid,n,m,i-1,j);
        helper(grid,n,m,i,j+1);
        helper(grid,n,m,i,j-1);
    }
}