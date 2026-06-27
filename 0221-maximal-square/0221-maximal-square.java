class Solution {
    int dp[][];
    public int maximalSquare(char[][] matrix) {
        int arr[][]=new int[matrix.length][matrix[0].length];
        int n=matrix.length;
        int m=matrix[0].length;
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c=matrix[i][j];
                if(c=='1'){
                    arr[i][j]=1;
                }else{
                    arr[i][j]=0;
                    vis[i][j]=true;
                }
            }
        }
        int op=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false){
                    vis[i][j]=true;
                    int a=helper(i,j,n,m,arr);
                    op=Math.max(a,op);
                }
            }
        }
        return op*op;


    }
    public int helper(int i,int j,int n,int m,int arr[][]){
        if(i<0||i>=n||j<0||j>=m||arr[i][j]==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a=arr[i][j]+helper(i+1,j,n,m,arr);
        int b=arr[i][j]+helper(i+1,j+1,n,m,arr);
        int c=arr[i][j]+helper(i,j+1,n,m,arr);
        return dp[i][j]=Math.min(a,Math.min(b,c));
    }

}