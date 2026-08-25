class Solution {
    public int missingMultiple(int[] nums, int k) {
        int val=1;
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
             hs.add(nums[i]);
        }
        int no=k*val;
        while(hs.contains(no)){
            val++;
            no=k*val;
        }
        return no;
    }
}