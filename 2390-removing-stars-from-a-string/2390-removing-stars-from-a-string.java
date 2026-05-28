class Solution {
    public String removeStars(String s) {
        Stack<Character>ss=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!='*'){
                ss.push(c);
            }else{
                ss.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!ss.isEmpty()){
           sb.append(ss.pop());
        }
        return sb.reverse().toString();
    }
}