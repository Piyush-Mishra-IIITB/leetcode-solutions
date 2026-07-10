class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                traversal(grid,i,0);
            }
            if(grid[i][m-1]==0){
                traversal(grid,i,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==0){
                traversal(grid,0,i);
            }
            if(grid[n-1][i]==0){
                traversal(grid,n-1,i);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    traversal(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void traversal(int grid[][],int i,int j){
        if(i<0|| i>=grid.length || j<0||j>=grid[0].length|| grid[i][j]==1){
               return;
        }
        grid[i][j]=1;
        traversal(grid,i+1,j);
        traversal(grid,i-1,j);
        traversal(grid,i,j+1);
        traversal(grid,i,j-1);
    }
}