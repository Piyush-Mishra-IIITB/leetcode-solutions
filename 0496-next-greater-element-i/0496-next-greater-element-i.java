class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>ss=new Stack<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
           int curr=nums2[i];
            while(!ss.isEmpty() && ss.peek()<=curr){
                ss.pop();
            }
            if(ss.isEmpty()){
                hm.put(curr,-1);
            }else{
                hm.put(curr,ss.peek());
            }
            ss.push(curr);
        }
        int ans[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=hm.get(nums1[i]);
        }
        return ans;
    }
}