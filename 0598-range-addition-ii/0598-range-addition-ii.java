class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0){
            return m*n;
        }
        int minRow=Integer.MAX_VALUE;
        int minCol=Integer.MAX_VALUE;
        for(int i=0;i<ops.length;i++){
            int a[]=ops[i];
            int u=a[0];
            int v=a[1];
            minRow=Math.min(minRow,u);
            minCol=Math.min(minCol,v);
        }
        return minRow*minCol;
    }
}