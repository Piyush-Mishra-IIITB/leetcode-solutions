class Solution {
    public int findKthPositive(int[] arr, int k) {
       int largest=arr[arr.length-1];
       int end=largest+k;
       HashMap<Integer,Integer>hm=new HashMap<>();
       for(int i=0;i<arr.length;i++){
            hm.put(arr[i],1);
       }
       for(int i=1;i<=end;i++){
        if(!hm.containsKey(i)){
            k--;
        }
        if(k==0){
            return i;
        }
    }
       return -1;
    }
}
