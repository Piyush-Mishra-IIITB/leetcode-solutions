class Solution {
    public int countSpecialNumbers(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append(n%10);
            n=n/10;
        }
        return helper(0,1,0,1,sb.reverse().toString())-1;
    }
    public int helper(int ind,int tide,int mask,int lz,String s){
        if(ind==s.length()){
            return 1;
        }
        int ans=0;
        int lw=0;
        int uw=9;
        if(tide==1){
            uw=s.charAt(ind)-'0';
        }
        for(int i=lw;i<=uw;i++){
            if(lz==1 && i==0){
                int newTide=tide;
                    if(tide==1 && i == s.charAt(ind) - '0'){
                        newTide=1;
                    }else{
                        newTide=0;
                    }
                ans+=helper(ind+1,newTide,mask,1,s);
            }else{
                if((mask & (1<<i))==0){
                    int newMask=mask |(1<<i);
                    int newTide=tide;
                    if(tide==1 && i == s.charAt(ind) - '0'){
                        newTide=1;
                    }else{
                        newTide=0;
                    }
                    ans+=helper(ind+1,newTide,newMask,0,s);
                }
            }
            
        }
        return ans;  
    }
}