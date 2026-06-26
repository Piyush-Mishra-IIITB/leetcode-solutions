class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer>even=new ArrayList<>();
        List<Integer>odd=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                even.add(nums[i]);
            }else{
                odd.add(nums[i]);
            }
        }
        int ans[]=new int[nums.length];
        int i=0;
        Collections.sort(even);
        Collections.sort(odd);
        for(int j=0;j<even.size();j++){
            ans[i]=even.get(j);
            i++;
        }
        for(int j=0;j<odd.size();j++){
            ans[i]=odd.get(j);
            i++;
        }
        return ans;

    }
}