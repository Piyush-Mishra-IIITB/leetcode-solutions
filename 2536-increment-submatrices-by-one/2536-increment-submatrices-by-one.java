class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int ans[][]=new int[n][n];
        for(int i=0;i<queries.length;i++){
            int a[]=queries[i];
            int u1=a[0];
            int u2=a[2];
            int u3=a[1];
            int u4=a[3];
            for(int j=u1;j<=u2;j++){
                ans[j][u3]+=1;
            }
            if(u4+1<n){
                  for(int j=u1;j<=u2;j++){
                   ans[j][u4+1]+=-1;
                  }
            }
            
        }
        for(int i=0;i<ans.length;i++){
            
            for(int j=1;j<ans.length;j++){
                ans[i][j]=ans[i][j]+ans[i][j-1];
            }

        }
        return ans;
    }
}