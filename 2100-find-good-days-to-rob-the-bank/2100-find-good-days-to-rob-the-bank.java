class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int k) {
       int incr[]=new int[arr.length];
       int decr[]=new int [arr.length];
       decr[0]=0;
       int decrs=1;
       for(int i=1;i<arr.length;i++){
            if(arr[i]<=arr[i-1]){
               decr[i]=decr[i-1]+1;
            }
            else{
                decr[i]=0;
            }
       }
       incr[arr.length-1]=0;
       for(int i=arr.length-2;i>=0;i--){
           if(arr[i]<=arr[i+1]){
            incr[i]=incr[i+1]+1;
           }else{
            incr[i]=0;
           }
       } 
    //    for(int i=0;i<arr.length;i++){
    //           System.out.println("incr" + incr[i]);
    //            System.out.println(decr[i]);
    //    }
    List<Integer>ll=new ArrayList<>();
     for(int i=k;i<=arr.length-k-1;i++){
        System.out.println(i);
        if(incr[i]>=k && decr[i]>=k){
            ll.add(i);
        }
     }
     return ll;
    }
    
}