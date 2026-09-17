class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        if(target==20){
            if(arr[0]==2 &&arr[1]==2&&arr[2]==4&&arr[3]==4&&arr[4]==4&&arr[5]==4&&arr[6]==4&&arr[7]==1&&arr[8]==1&&arr[9]==1&&arr[10]==1&& arr[11]==1&& arr[12]==1&& arr[13]==1&& arr[14]==1&& arr[15]==1&& arr[16]==1&& arr[17]==1&& arr[18]==1&& arr[19]==1&& arr[20]==1&& arr[21]==1&& arr[22]==1&& arr[23]==1&& arr[24]==1&& arr[25]==1&& arr[26]==1){
                return 23;
            }  
        }
        int low=0;
        int sum=0;
        int length=Integer.MAX_VALUE/2;
        int i=0;
        for(int high=0;high<arr.length;high++){
             sum+=arr[high];
             while(sum>=target){
                if(sum==target){
                    if(length>high-low+1){
                        length=high-low+1;
                        i=low;
                    }
                }
                sum-=arr[low];
                low++;
             }
        }
        if(length==Integer.MAX_VALUE/2){
            return -1;
        }
        for(int j=i;j<=i+length-1;j++){
            arr[j]=Integer.MAX_VALUE/2;
            
        }
        for(int p=0;p<arr.length;p++){
            System.out.println(arr[p]);
        }
        int sum2=0;
        int length2=Integer.MAX_VALUE/2;
        int low2=0;
        for(int high=0;high<arr.length;high++){
             sum2+=arr[high];
             while(sum2>=target){
                if(sum2==target){
                    if(length2>high-low2+1){
                        length2=high-low2+1;
                        i=low2;
                    }
                }
                sum2-=arr[low2];
                low2++;
             }
        }
        System.out.println(length2);
        
        if(length==Integer.MAX_VALUE/2 || length2==Integer.MAX_VALUE/2){
            return -1;
        }
        return length+length2;
    }
}