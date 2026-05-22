class Solution {
    public int minDays(int[] arr, int m, int k) {
        if((long)m*k>arr.length){
            return -1;
        }
        int output=Integer.MAX_VALUE;
        int start=arr[0];
        int end=arr[0];
        for(int i=0;i<arr.length;i++){
            start=Math.min(start,arr[i]);
            end=Math.max(end,arr[i]);
     }
     while(start<=end){
               int mid=start+(end-start)/2;
               if(helper(arr,m,k,mid)>=m){
                     output=Math.min(output,mid);
                     end=mid-1;
                }
                else{
                    start=mid+1;
                }        
     }
                
        
        return output;
    }
    public int helper(int arr[],int m,int k,int i){
        
        boolean vis[]=new boolean[arr.length];
        for(int j=0;j<arr.length;j++){
            if(arr[j]<=i){
                vis[j]=true;
            }
        }
        int counter=0;
        int a=0;
        for(int j=0;j<vis.length;j++){
             if(vis[j]==true){
                a++;
             }
             if(a==k){
                counter++;
                a=0;
             }
             if(vis[j]==false){
                a=0;
             }
        }
        return counter;
    }
}