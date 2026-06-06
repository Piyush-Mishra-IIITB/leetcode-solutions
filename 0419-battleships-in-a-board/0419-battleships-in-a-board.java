class Solution {
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && board[i][j]=='X'){
                    dfs(i,j,vis,board);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,boolean vis[][],char[][] board){
        int n=board.length;
        int m=board[0].length;
        if(i<0||i>=n||j<0||j>=m|| vis[i][j]||board[i][j]=='.'){
            return ;
        }
        vis[i][j]=true;
        dfs(i+1,j,vis,board);
        dfs(i-1,j,vis,board);
        dfs(i,j+1,vis,board);
        dfs(i,j-1,vis,board);
    }
}