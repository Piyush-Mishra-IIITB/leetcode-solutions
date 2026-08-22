class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        int x=n;
        while(x>0){
            int curr=x%10;
            sum+=curr;
            product*=curr;
            x=x/10;
        }
        return n%(sum+product)==0;
    }
}