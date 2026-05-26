class Solution {
    public int minMaxGame(int[] nums) {
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
        int index=0;
        for(int i=0;i<ll.size();i+=2){
           if(index%2==0){
            temp.add(Math.min(ll.get(i),ll.get(i+1)));
           }else{
            temp.add(Math.max(ll.get(i),ll.get(i+1)));
           }
           index++;
        }
        ll.clear();
        ll.addAll(temp);
        helper(ll);
    }
}