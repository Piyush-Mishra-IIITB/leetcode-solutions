class Solution {
    public int gcdOfOddEvenSums(int n) {
        int firstO=1;
        int firstE=2;
        int sumOdd=0;
        int sumEven=0;
        for(int i=0;i<n;i++){
            sumOdd+=firstO;
            sumEven+=firstE;
            firstO=firstO+2;
            firstE=firstE+2;
        }
        return gcd(sumOdd,sumEven);
    }
    public int gcd(int a,int b){
        int min=Math.min(a,b);
        int ans=1;
        for(int i=2;i<=min;i++){
            if(a%i==0 && b%i==0){
                ans=i;
            }
        }
        return ans;
    }
}