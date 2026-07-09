class Solution {
    Integer dp[][];
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp=new Integer[nums1.length+1][nums2.length+1];
        return helper(0,0,nums1,nums2);
    }
    public int helper(int i,int j,int arr1[],int arr2[]){
        if(i>=arr1.length || j>=arr2.length){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=0;
        if(arr1[i]==arr2[j]){
            ans+=1+helper(i+1,j+1,arr1,arr2);
        }else{
            ans+=Math.max(helper(i+1,j,arr1,arr2),helper(i,j+1,arr1,arr2));
        }
        return dp[i][j]=ans;
    }
}