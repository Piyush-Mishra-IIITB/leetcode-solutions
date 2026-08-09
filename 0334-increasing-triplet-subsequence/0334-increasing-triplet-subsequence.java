class Solution {
    public boolean increasingTriplet(int[] arr) {
        int smallest=Integer.MAX_VALUE;
        int biggest=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
             if(smallest>=arr[i]){
                smallest=arr[i];
             }
             else if(biggest>=arr[i]){
                biggest=arr[i];
             }
             else{
                return true;
             }
        }
        return false;

    }
}