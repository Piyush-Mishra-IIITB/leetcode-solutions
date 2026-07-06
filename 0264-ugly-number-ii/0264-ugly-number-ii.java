class Solution {
    public int nthUglyNumber(int n) {
        int arr[]=new int[n+1];
        arr[0]=1;
        int i2=0;
        int i3=0;
        int i5=0;
        for(int i=1;i<=n;i++){
            int i2U=arr[i2]*2;
            int i3U=arr[i3]*3;
            int i5U=arr[i5]*5;
            int min=Math.min(Math.min(i2U,i3U),i5U);
            arr[i]=min;
            if (i2U == min) {
                i2++;
             }
            if (i3U == min) {
                i3++;
             }
            if (i5U == min) {
                i5++;
             }
        }
        return arr[n-1];
    }
}