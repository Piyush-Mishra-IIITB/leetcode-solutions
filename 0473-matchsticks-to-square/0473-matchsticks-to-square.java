class Solution {
    public boolean makesquare(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%4!=0){
            return false;
        }
        int find=sum/4;
        boolean vis[]=new boolean[arr.length+1];
        return helper(0,arr,find,vis,find,0);
    }
    public boolean helper(int ind,int arr[],int find,boolean vis[],int sum,int count){
        
        if(count==4){
            return true;
        }
        if(find==0){
            return helper(0,arr,sum,vis,sum,count+1);
        }
        if(ind==arr.length){
            return false;
        }
        for(int i=ind;i<arr.length;i++){
             if(vis[i]==false && arr[i]<=find){
                vis[i]=true;
                if(helper(i+1,arr,find-arr[i],vis,sum,count)){
                   return true;
                }
                vis[i]=false;
             }
        }
        return false;
    }
}