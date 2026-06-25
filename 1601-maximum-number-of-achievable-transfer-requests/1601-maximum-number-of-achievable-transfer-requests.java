class Solution {
    int output=-1;
    public int maximumRequests(int n, int[][] requests) {
        int ans[]=new int[n];
        helper(0,requests,ans,0);
        return output;
    }
    public void helper(int ind,int[][] requests,int ans[],int steps){
        if(ind==requests.length){
             for(int i=0;i<ans.length;i++){
                if(ans[i]!=0){
                    return;
                }
             }
             output=Math.max(steps,output);
             return;
        }
            int a[]=requests[ind];
            ans[a[0]]--;
            ans[a[1]]++;
            helper(ind+1,requests,ans,steps+1);
            ans[a[0]]++;
            ans[a[1]]--;
            helper(ind+1,requests,ans,steps);
    }
}