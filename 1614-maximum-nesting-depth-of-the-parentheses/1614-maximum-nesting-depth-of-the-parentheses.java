class Solution {
    public int maxDepth(String s) {
        int op=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr=='('){
                op++;
            }
            if(curr==')'){
                op--;
            }
            ans=Math.max(ans,op);
        }
        return ans;
    }
}