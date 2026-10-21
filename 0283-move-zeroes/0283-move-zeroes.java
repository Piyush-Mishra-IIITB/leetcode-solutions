class Solution {
    public void moveZeroes(int[] arr) {
        int i=0;
        int j=0;
        int n=arr.length;
        while(j<n){
             while(j<n && arr[j]==0){
                j++;
             }
            if(j<n && i != j){
                arr[i]=arr[j];
                arr[j]=0;
            } 
             i++;
             j++;
        }
    }
}