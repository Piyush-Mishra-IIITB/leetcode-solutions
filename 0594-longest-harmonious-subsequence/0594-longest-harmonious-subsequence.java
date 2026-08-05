class Solution {
    public class pair{
        int a;
        int b;
        public pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        List<Integer>ll=new ArrayList<>();
        for(Integer it:hm.keySet()){
            ll.add(it);
        }
        Collections.sort(ll);
        List<pair>ans=new ArrayList<>();
        for(int i=1;i<ll.size();i++){
            if(ll.get(i)-ll.get(i-1)==1){
                ans.add(new pair(ll.get(i),ll.get(i-1)));
            }
        }
        int var=0;
        for(int i=0;i<ans.size();i++){
           pair p=ans.get(i);
           int a=p.a;
           int b=p.b;
           int value=hm.get(a)+hm.get(b);
           var=Math.max(value,var);
        }
        return var;
    }
}