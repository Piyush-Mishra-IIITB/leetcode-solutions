class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer>first=new ArrayList<>();
        List<Integer>second=new ArrayList<>();
        first.add(nums[0]);
        second.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            int last1=first.get(first.size()-1);
            int last2=second.get(second.size()-1);
            if(last1>last2){
                first.add(nums[i]);
            }else{
                second.add(nums[i]);
            }
        }
        int ans[]=new int[nums.length];
        int i=0;
        for(Integer it:first){
            ans[i]=it;
            i++;
        }
        for(Integer it:second){
            ans[i]=it;
            i++;
        }
        return ans;
    }
}