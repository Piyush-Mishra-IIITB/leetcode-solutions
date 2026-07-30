class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        int ans=0;
        int odd=0;
        for(Integer it:hm.values()){
            int val=it/2;
            if(it%2!=0){
                odd=1;
            }
            ans+=val*2;
        }
        return ans+odd;
    }
}