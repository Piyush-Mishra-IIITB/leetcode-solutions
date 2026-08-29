class Solution {
    public int fib(int n) {
        return helper(n);
    }
    public int helper(int n){
        if(n==1 || n==0){
            return n;
        }
        return helper(n-1)+helper(n-2);
    }
}