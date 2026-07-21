class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int start=i+1;
            int end=n-1;
            int target=-arr[i];
            while(start<end){
                if(arr[start]+arr[end]==target){
                    List<Integer>ll=new ArrayList<>();
                    ll.add(-(target));
                    ll.add(arr[start]);
                    ll.add(arr[end]);
                    result.add(ll);
                    while(start>n-1 &&arr[start]==arr[start+1]){
                        start++;
                    }while(end>1 && arr[end]==arr[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }else if(arr[start]+arr[end]<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
       return result;
    }
}
