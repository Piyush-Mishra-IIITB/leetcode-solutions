class NumMatrix {
    int prefix[][];
    public NumMatrix(int[][] matrix) {
        prefix=new int[matrix.length][matrix[0].length];
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=matrix[i][j];
                prefix[i][j]=sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(col1==0){
            int sum=0;
            for(int i=row1;i<=row2;i++){
                sum+=prefix[i][col2];
            }
            return sum;
        }
        else{
            int sum=0;
            for(int i=row1;i<=row2;i++){
                sum=sum+prefix[i][col2]-prefix[i][col1-1];
            }
            return sum;
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */