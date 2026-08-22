class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>ss=new Stack<>();
        int nge[]=new int[nums2.length];
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
           int curr=nums2[i];
            while(!ss.isEmpty() && ss.peek()<=curr){
                ss.pop();
            }
            if(ss.isEmpty()){
                nge[i]=-1;
            }else{
                nge[i]=ss.peek();
            }
            hm.put(curr,nge[i]);
            ss.push(curr);
        }
        int ans[]=new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            System.out.println(nge[i]);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i]=hm.get(nums1[i]);
        }
        return ans;
    }
}