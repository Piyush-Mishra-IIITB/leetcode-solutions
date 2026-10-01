class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int no=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i]=1;
                if(i>0){
                    if(arr[i-1]==1){
                        arr[i]=0;
                    }
                }
                if(i<arr.length-1){
                    if(arr[i+1]==1){
                        arr[i]=0;
                    }
                }
                if(arr[i]==1){
                    no++;
                }
            }
        }
        return no>=n;
    }
}