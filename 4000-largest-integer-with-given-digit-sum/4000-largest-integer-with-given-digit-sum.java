class Solution {
    int ans=-1;
    public int largestInteger(int n, int s) {
        if(n*9<s){
            return -1;
        }else{
            helper(0,0,n,0,s);
            return ans;
        }

    }
    public void helper(int no,int ind,int n,int sum,int s){
        if(ind==n){
             if(sum==s){
                ans=Math.max(ans,no);
             }
            return;
        }

        for(int i=0;i<=9;i++){
            helper(no*10+i,ind+1,n,sum+i,s);
        }
    }
}