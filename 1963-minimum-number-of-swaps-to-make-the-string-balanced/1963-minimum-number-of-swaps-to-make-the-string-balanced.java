class Solution {
    public int minSwaps(String s) {
        Stack<Character>ss=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==']'){
                if(!ss.isEmpty() && ss.peek()=='['){
                    ss.pop();
                    continue;
                    
                }}
                
            ss.push(c);
        }
        while(!ss.isEmpty()){
          char c=ss.pop();
          if(c=='['){
            count++;
          }
        }
        return (count+1)/2;
    }
}