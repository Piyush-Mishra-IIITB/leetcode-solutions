class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1){
            return true;
        }
        int var=1;
        long no=4;
        while(no<n){
            no=(long)Math.pow(4,var);
            var++;
        }
        return (int)no==n;
    }
}