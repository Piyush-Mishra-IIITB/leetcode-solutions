class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>ss=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(s.charAt(i)=='('){
                ss.push(curr);
            }else{
               if(!ss.isEmpty()){
                 ss.pop();
               }else{
                ans++;
               }
            }
        }
        return ans+ss.size();
    }
}