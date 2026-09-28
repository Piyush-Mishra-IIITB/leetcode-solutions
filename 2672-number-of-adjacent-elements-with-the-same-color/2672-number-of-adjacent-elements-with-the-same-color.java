class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int arr[]=new int[n+1];
        int ans[]=new int[queries.length];
        int count=0;
        for(int i=0;i<queries.length;i++){
            int a[]=queries[i];
             int u=a[0];
             int v=a[1];
            if(u!=0){
                 if(arr[u]==arr[u-1] && arr[u]!=0){
                    count--;
                 }
             }
             if(u!=arr.length-1){
                 if(arr[u]==arr[u+1]&& arr[u]!=0){
                    count--;
                 }
             }
             arr[u]=v;
             if(u!=0){
                 if(arr[u]==arr[u-1]){
                    count++;
                 }
             }
             if(u!=arr.length-1){
                 if(arr[u]==arr[u+1]){
                    count++;
                 }
             }
             ans[i]=count;       
        }
        
      return ans;
    }
}