class Solution {
    public int findKthPositive(int[] arr, int k) {
       int max=-1;
       HashMap<Integer,Integer>hm=new HashMap<>();
       for(int i=0;i<arr.length;i++){
        hm.put(arr[i],1);
        max=Math.max(max,arr[i]);
     }
     int c=0;
     for(int i=1;i<=max+k;i++){
        if(hm.containsKey(i)==false){
            c++;
        } 
         if(k==c){
            return i;
        }
     }
     return -1;
    }
}
