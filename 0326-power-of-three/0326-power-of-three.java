class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }
        int var=0;
        long no=3;
        while(no<n){
            no=(long)Math.pow(3,var);
            var++;
        }
        return (int)no==(n);
    }
}