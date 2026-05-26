class Solution {
    public int triangularSum(int[] nums) {
        List<Integer>temp=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
        }
        helper(temp);
        return temp.get(0);
    }
    public void helper(List<Integer>ll){
        if(ll.size()==1){
            return;
        }
        List<Integer>temp=new ArrayList<>();
        for(int i=0;i<ll.size()-1;i++){
            temp.add((ll.get(i)+ll.get(i+1))%10);
        }
        ll.clear();
        ll.addAll(temp);
        helper(ll);
    }
}