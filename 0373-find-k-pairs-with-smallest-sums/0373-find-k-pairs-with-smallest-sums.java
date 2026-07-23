class Solution {
    public class pair{
        int first;
        int sec;
        public pair(int first,int sec){
            this.first=first;
            this.sec=sec;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->Integer.compare(
        nums1[a.first] + nums2[a.sec], nums1[b.first] + nums2[b.sec]));
        for(int i=0;i<Math.min(k,nums1.length);i++){
            pq.add(new pair(i,0));
        }
        while(!pq.isEmpty() && k>0){
             List<Integer>ll=new ArrayList<>();
             pair p=pq.poll();
             int row=p.first;
             int col=p.sec;
             ll.add(nums1[row]);
             ll.add(nums2[col]);
             ans.add(ll);
             if(col+1<nums2.length){
                pq.add(new pair(row,col+1));
             }
             k--;
        }
        return ans;
    }
}