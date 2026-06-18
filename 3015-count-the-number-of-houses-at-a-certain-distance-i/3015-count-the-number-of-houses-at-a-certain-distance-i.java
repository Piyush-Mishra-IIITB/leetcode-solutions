class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
            dist[i][i]=0;   
        }
        if(x!=y){
            dist[x-1][y-1]=1;
            dist[y-1][x-1]=1;
        }
        for(int i=1;i<n;i++){
            dist[i][i-1]=1;
            dist[i-1][i]=1;
        }
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                if(dist[i][via]==Integer.MAX_VALUE){
                        continue;
                    }
                for(int j=0;j<n;j++){
                    if(dist[via][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }
        int ans[]=new int[n];
        
        for(int k=0;k<n;k++){
           int count=0;
           for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i][j]==k+1){
                    count++;
                }
            }
           }
           ans[k]=count;
        }
        return ans;
    }
}