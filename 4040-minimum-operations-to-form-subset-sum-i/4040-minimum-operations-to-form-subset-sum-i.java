class Solution {
    Integer dp[][];
    public int minOperations(int[] nums, int sum) {
        
        dp=new Integer[nums.length+1][sum+1];
       int op= helper(0,0,sum,nums);
       return op>=Integer.MAX_VALUE ? -1: op;
    }
    public int helper(int ind,int currSum,int sum,int arr[]){
       if(ind==arr.length){
           if(currSum==sum){
               return 0;
           }
           return Integer.MAX_VALUE;
       }
        if(dp[ind][currSum]!=null){
            return dp[ind][currSum];
        }

        // skip
        int a=helper(ind+1,currSum,sum,arr);
        
        // multi
         int multi=Integer.MAX_VALUE;
          int val=arr[ind];
           int operation=0;
            while(val+currSum<=sum){
                int temp=helper(ind+1,currSum+val,sum,arr);
                if(temp!=Integer.MAX_VALUE){
                    multi=Math.min(multi,temp+operation);
                }
                val=val*2;
                operation++;
            }
            
        
        // div
           int div=Integer.MAX_VALUE;
        int val2=arr[ind]/2;
        int opr=1;
        while(val2>0 ){
            if(currSum+val2<=sum){
            int tem=helper(ind+1,currSum+val2,sum,arr);
            if(tem!=Integer.MAX_VALUE){
                div=Math.min(div,opr+tem);
            }
            }      
            val2=val2/2;
            opr++;
        }
          
        return dp[ind][currSum]=Math.min(a,Math.min(multi,div));
    }
}