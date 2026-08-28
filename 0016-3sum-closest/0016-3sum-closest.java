class Solution {
    public class pair{
        int val;
        int val2;
        public pair(int val,int val2){
            this.val=val;
            this.val2=val2;
        }
    }
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1] ){
                continue;
            }
            for(int j=i+1;j<arr.length;j++){
                if(j>i+1 && arr[j]==arr[j-1] ){
                continue;
                }
                int start=j+1;
                int end=arr.length-1;
                while(start<=end){
                     int mid=start+(end-start)/2;
                    //  System.out.println(target-(arr[i]+arr[mid]+arr[j]));
                    //  System.out.println("next");
                    //  System.out.println(target-(arr[i]+arr[mid]+arr[j])+"next"+(arr[i]+arr[mid]+arr[j]));
                     pq.add(new pair(Math.abs(target-(arr[i]+arr[mid]+arr[j])),(arr[i]+arr[mid]+arr[j])));
                     if(arr[i]+arr[mid]+arr[j]>=target){
                        end=mid-1;
                     }else{
                        start=mid+1;
                     }
                }
               
            }
        }
        return pq.peek().val2;
    }
}