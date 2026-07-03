class Solution {
    public int maxProfit(int[] arr) {
        int buy=arr[0];
        int sell=0;
        for(int i=1;i<arr.length;i++){
            if(buy<arr[i]){
                sell=Math.max(sell,arr[i]-buy);
            }else{
                buy=arr[i];
            }
        }
        return sell;
    }
}