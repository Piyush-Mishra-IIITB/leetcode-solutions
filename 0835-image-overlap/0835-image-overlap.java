class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int op=0;
        for(int r=-n-1;r<n;r++){
            for(int c=-n-1;c<n;c++){
                int count=0;

                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        int x=r+i;
                        int y=c+j;

                        if(x>=0 && y>=0 && x<n && y<n){
                            if(img1[x][y]==img2[i][j]&& img2[i][j]==1){
                                count++;
                            }
                        }
                    }
                }
                op=Math.max(op,count);
            }
        }
        return op;
    }
}