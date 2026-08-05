class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        boolean allzero=true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                allzero=false;
                break;
            }
        }
        if(allzero){
            return true;
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
        }
        if(sum%3!=0){
            return false;
        }
        int currsum=0;
        int count=0;
        int finalsum=sum/3;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(currsum==finalsum){
                currsum=0;
                count++;
            }
        }

        return count==3;
    }
}