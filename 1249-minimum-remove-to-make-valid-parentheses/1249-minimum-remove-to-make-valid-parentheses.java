class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer>ss=new Stack<>();
        HashSet<Integer>hs=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                ss.push(i);
            }
            else if(c==')'){
                if(!ss.isEmpty()){
                    ss.pop();  
                }else{
                    hs.add(i);
                }
            }
        }
        while(!ss.isEmpty()){
            int a=ss.pop();
            hs.add(a);
        }
        for(int i=0;i<s.length();i++){
            if(hs.contains(i)){
                continue;
            }else{
               sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }}