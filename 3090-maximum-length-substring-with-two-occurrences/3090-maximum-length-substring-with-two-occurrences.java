class Solution {
    public int maximumLengthSubstring(String s) {
        int low=0;
        int ans=0;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int high =0;high<s.length();high++){
            char curr=s.charAt(high);
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }

            while(hm.get(curr)>2){
                int val=hm.get(s.charAt(low));
                hm.remove(s.charAt(low));
                if(val>1){
                    hm.put(s.charAt(low),val-1);
                }
                low++;
            }
            ans=Math.max(ans,high-low+1);
        }
        return ans;
    }
}