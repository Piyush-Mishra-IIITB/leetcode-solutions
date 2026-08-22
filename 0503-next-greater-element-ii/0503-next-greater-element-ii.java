class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int nge[]=new int [nums.length];
        Stack<Integer>ss=new Stack<>();
        for(int i=2 * nums.length-1;i>=0;i--){
            int length=i % nums.length;
            int curr=nums[length];
            while(!ss.isEmpty() && ss.peek()<=curr){
                ss.pop();
            }
            if(ss.isEmpty()){
                nge[length]=-1;
            }else{
                nge[length]=ss.peek();
            }
            ss.push(curr);
        }
        return nge;
    }
}