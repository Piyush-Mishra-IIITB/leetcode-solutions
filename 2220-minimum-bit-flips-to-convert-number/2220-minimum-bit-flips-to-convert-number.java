class Solution {
    public int count(int n){
        StringBuilder sb=new StringBuilder();
        while(n>0){
            int rem=n%2;
            n=n/2;
            sb.append(rem);
        }
        int ans=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                ans++;
            }
        }
        return ans;
    }
    public int minBitFlips(int start, int goal) {
        int op=start^goal;
        return count(op);
    }
}