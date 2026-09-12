class Solution {
    public int maxDistance(int[] arr, int[] arr2) {
        int i=arr.length-1;
        int j=arr2.length-1;
        int ans=0;
        while(i>=0 && j>=0){
            
            while(i>0 && arr2[j]>=arr[i]){
                    ans=Math.max(ans,j-i);
                    i--;
                }
                if(i==0 && arr[i]<=arr2[j]){
                    ans=Math.max(ans,j-i);
                }
           j--;
        }
        return ans;
    }
}