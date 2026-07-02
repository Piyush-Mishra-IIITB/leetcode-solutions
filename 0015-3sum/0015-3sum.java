class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
       for(int i=0;i<arr.length;i++){
        if(i>0 && arr[i]==arr[i-1]){
            continue;
        }
          int start=i+1;
          int end=arr.length-1;
          int target=-arr[i];
          while(start<end){
               if(arr[start]+arr[end]==target){
                   List<Integer>ll=new ArrayList<>();
                   ll.add(arr[start]);
                   ll.add(arr[end]);
                   ll.add(-target);
                   result.add(new ArrayList<>(ll));
                   start++;
                   end--;
                   while(start<end && arr[start]==arr[start-1]){
                    start++;
                   }
                   while(start<end && arr[end]==arr[end+1]){
                    end--;
                   }
               }else if(arr[start]+arr[end]>target){
                end--;
               }else{
                start++;
               }
          }
          
       }
       return result;
    }
}
