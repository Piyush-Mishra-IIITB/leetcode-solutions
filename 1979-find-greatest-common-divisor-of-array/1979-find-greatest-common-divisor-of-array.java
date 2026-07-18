class Solution {
    public int findGCD(int[] arr) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
          min=Math.min(min,arr[i]);
          max=Math.max(max,arr[i]);
        }
        int ans=1;
        for(int i=2;i<=min;i++){
           if(min%i==0 && max%i==0){
            ans=i;
           }
        }
        return ans;
    }
}