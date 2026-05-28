class Solution {
    public String removeKdigits(String s, int k) {
        Stack<Character> ss = new Stack<>();
        if(s.length()==k){
            return "0";
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            while(!ss.isEmpty() && ss.peek()-'0'>c-'0' && k>0){
                ss.pop();
                k--;
            }
            ss.push(c);
        }
        StringBuilder sb=new StringBuilder();
        while(k>0){
            if(!ss.isEmpty()){
                ss.pop();
                k--;}
        }
        while(!ss.isEmpty()){
              char c=ss.pop();
              sb.append(c);
        }
        
        String ans= sb.reverse().toString();
        int i=0;
        while(i<ans.length()){
            if(ans.charAt(i)=='0'){
                i++;
            }else{
                break;
            }
        }
        if(ans.substring(i,ans.length()).length()==0){
            return "0";
        }
        return ans.substring(i,ans.length());
    }
}
