class Solution {
    Boolean dp[];
    public boolean wordBreak(String s, List<String> ll) {
     dp=new Boolean[s.length()];
     HashSet<String>hs=new HashSet<>();
     for(int i=0;i<ll.size();i++){
        hs.add(ll.get(i));
     }
     return helper(0,s,hs);
    }
    public boolean helper(int ind,String s,HashSet<String>hs){
        if(ind==s.length()){
            return true;
        }
        if(dp[ind]!=null){
            return dp[ind];
        }
        boolean a=false;
        for(int i=ind;i<s.length();i++){
            if(i==s.length()&& !hs.contains(s.substring(ind,i+1))){
                a=false;
            }
            if(hs.contains(s.substring(ind,i+1))){
                if(helper(i+1,s,hs)){
                    a=true;
                }
            }
        }
        return dp[ind]=a;
    }
}