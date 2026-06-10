class Solution {
    public class pair{
        int row;
        int col;
        int steps;
        public pair(int row,int col,int steps){
            this.row=row;
            this.col=col;
            this.steps=steps;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<pair>qq=new LinkedList<>();
        qq.add(new pair(entrance[0],entrance[1],0));
        vis[entrance[0]][entrance[1]]=true;
        while(!qq.isEmpty()){
            pair p=qq.poll();
            int r=p.row;
            int c=p.col;
            int s=p.steps;
            if(r==0||r==n-1||c==0||c==m-1){
                if (!(r==entrance[0] && c==entrance[1])){
                     return s;
                }
            }
            if(r+1<n && vis[r+1][c]==false && maze[r+1][c]=='.'){
                qq.add(new pair(r+1,c,s+1));
                vis[r+1][c]=true;
            }
            if(r-1>=0 && vis[r-1][c]==false && maze[r-1][c]=='.'){
                qq.add(new pair(r-1,c,s+1));
                vis[r-1][c]=true;
            }
            if(c+1<m && vis[r][c+1]==false && maze[r][c+1]=='.'){
                qq.add(new pair(r,c+1,s+1));
                vis[r][c+1]=true;
            }
            if(c-1>=0 && vis[r][c-1]==false && maze[r][c-1]=='.'){
                qq.add(new pair(r,c-1,s+1));
                vis[r][c-1]=true;
            }
        }
        return -1;
    }
    public int helper(int i, int j, char[][] arr,
                      boolean[][] vis,
                      int sr, int sc) {
        int n = arr.length;
        int m = arr[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m ||
            arr[i][j] == '+' || vis[i][j]) {
            return Integer.MAX_VALUE;
        }
        if ((i == 0 || i == n - 1 || j == 0 || j == m - 1)
                && !(i == sr && j == sc)) {
            return 0;
        }

        vis[i][j] = true;

        int a = helper(i + 1, j, arr, vis, sr, sc);
        int b = helper(i - 1, j, arr, vis, sr, sc);
        int c = helper(i, j + 1, arr, vis, sr, sc);
        int d = helper(i, j - 1, arr, vis, sr, sc);

        vis[i][j] = false;

        int ans = Math.min(Math.min(a, b), Math.min(c, d));

        return ans == Integer.MAX_VALUE ? ans : ans + 1;
    }
}