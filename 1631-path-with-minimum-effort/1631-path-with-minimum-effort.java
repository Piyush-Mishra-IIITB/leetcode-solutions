class Solution {
    class pair{
        int dif,row,col;

        pair(int dif,int row,int col){
            this.dif=dif;
            this.row=row;
            this.col=col;
        }
    }

    public int minimumEffortPath(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;

        int diff[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j]=Integer.MAX_VALUE;
            }
        }

        diff[0][0]=0;

        PriorityQueue<pair> qq=new PriorityQueue<>((a,b)->a.dif-b.dif);
        qq.add(new pair(0,0,0));

        while(!qq.isEmpty()){
            pair p=qq.poll();

            int row=p.row;
            int col=p.col;
            int dif=p.dif;

            if(diff[row][col]<dif){
                continue;
            }

            if(row+1<n){
                int newEffort=Math.max(dif,
                    Math.abs(arr[row][col]-arr[row+1][col]));

                if(diff[row+1][col]>newEffort){
                    diff[row+1][col]=newEffort;
                    qq.add(new pair(newEffort,row+1,col));
                }
            }

            if(row-1>=0){
                int newEffort=Math.max(dif,
                    Math.abs(arr[row][col]-arr[row-1][col]));

                if(diff[row-1][col]>newEffort){
                    diff[row-1][col]=newEffort;
                    qq.add(new pair(newEffort,row-1,col));
                }
            }

            if(col+1<m){
                int newEffort=Math.max(dif,
                    Math.abs(arr[row][col]-arr[row][col+1]));

                if(diff[row][col+1]>newEffort){
                    diff[row][col+1]=newEffort;
                    qq.add(new pair(newEffort,row,col+1));
                }
            }

            if(col-1>=0){
                int newEffort=Math.max(dif,
                    Math.abs(arr[row][col]-arr[row][col-1]));

                if(diff[row][col-1]>newEffort){
                    diff[row][col-1]=newEffort;
                    qq.add(new pair(newEffort,row,col-1));
                }
            }
        }

        return diff[n-1][m-1];
    }
}