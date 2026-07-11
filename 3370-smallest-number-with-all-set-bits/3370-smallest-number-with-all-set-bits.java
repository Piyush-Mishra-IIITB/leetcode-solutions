class Solution {
    public int helper(int n){
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.pow(2,i);
        }
        return ans;
    }
    public int smallestNumber(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append(n%2);
            n=n/2;
        }
        return helper(sb.length());
    }
}