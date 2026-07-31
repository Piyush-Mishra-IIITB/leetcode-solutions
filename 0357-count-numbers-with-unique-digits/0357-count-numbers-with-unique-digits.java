class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        HashSet<Integer>hs=new HashSet<>();
        return helper(0,n,hs)+1;
    }
    public int helper(int ind,int length,HashSet<Integer>hs){
        if(ind==length){
            return 0;
        }
        int ans=0;
        for(int i=0;i<=9;i++){
            if(ind==0){
                if(i==0){
                    continue;
                }else{
                    if(!hs.contains(i)){
                        hs.add(i);
                        ans+=1+helper(ind+1,length,hs);
                        hs.remove(i);
                    }
                }
            }
            else{
                if(!hs.contains(i)){
                hs.add(i);
                ans+=1+helper(ind+1,length,hs);
                hs.remove(i);
                }
            }
        }
        return ans;
    }
}