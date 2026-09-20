class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        HashMap<Character,Integer>hm=new HashMap<>();
        char curr='a';
        for(int i=26;i>=1;i--){
            hm.put(curr,i);
            curr++;
        }
        for(int i=0;i<s.length();i++){
            ans+=(i+1)*hm.get(s.charAt(i));
        }
        return ans;
    }
}