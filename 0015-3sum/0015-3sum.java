class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        
       Arrays.sort(arr);
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            for(int j=i+1;j<arr.length;j++){
                 if(j>i+1 && arr[j]==arr[j-1]){
                     continue;
                }
                int target=-(arr[i]+arr[j]);
                int start=j+1;
                int end=arr.length-1;
                while(start<=end){
                    int mid=start+(end-start)/2;
                    if(arr[mid]==target){
                      List<Integer>ll=new ArrayList<>();
                      ll.add((target));
                      ll.add(arr[i]);
                      ll.add(arr[j]);
                      ans.add(new ArrayList<>(ll));
                      break;
                    }
                    else if(arr[mid]>target){
                         end=mid-1;
                    }else{
                        start=mid+1;
                    }
                }
            }
        }
        return ans;
    }
}