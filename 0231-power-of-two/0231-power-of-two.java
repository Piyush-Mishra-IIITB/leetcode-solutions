class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        else{
           int a=n &(n-1);
        return  a==0;
        }
       
}
}
