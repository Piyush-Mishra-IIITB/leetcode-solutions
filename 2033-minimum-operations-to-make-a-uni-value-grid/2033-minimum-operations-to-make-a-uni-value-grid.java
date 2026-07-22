class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int arr[]=new int[n*m];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               arr[k]=grid[i][j];
               k++;
            }
        }
        Arrays.sort(arr);
        int median=arr[arr.length/2];
        int steps=0;
        for(int i=0;i<arr.length;i++){
            int v=Math.abs(arr[i]-median);
            if(v%x!=0){
                return -1;
            }
            steps+=v/x;
        }
        return steps;
    }
}