class Solution {
    public int findTheCity(int n, int[][] edge, int thres) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
                if(i==j){
                    dist[i][j]=0;
                }
            }
        }
        for(int i=0;i<edge.length;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            int wt=edge[i][2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(dist[i][k]==Integer.MAX_VALUE){
                    continue;
                }
                for(int j=0;j<n;j++){
                    if(dist[k][j]==Integer.MAX_VALUE){
                    continue;
                }
                dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
                }
            }
        int minCount = Integer.MAX_VALUE;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= thres) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        return city;
        }
    }
