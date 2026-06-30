class Solution {
    public int maxVowels(String s, int k) {
        int ans=0;
        int i=0;
        int j=k;
        while(j<=s.length()){
            int a=count(s.substring(i,j));
            ans=Math.max(ans,a);
            j++;
            i++;
        }
        return ans;
    }
    public int count(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='a'|| c=='e' || c=='i' || c=='o' || c=='u'){
                count++;
            }
        }
        return count;
    }
}