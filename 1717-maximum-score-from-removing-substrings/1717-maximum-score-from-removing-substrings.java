class Solution {
    public int maximumGain(String s, int x, int y) {
       int value=0;
       StringBuilder sb=new StringBuilder();
        if(x>y){
           value+= helper1(s,x,y,sb);
           value+=helper2(sb.reverse(),x,y);
           return value;
        }else{
                value+=helper3(s,x,y,sb);
                value+=helper4(sb.reverse(),x,y);
                return value; 
        }

        
    }
    public int helper1(String s,int x,int y,StringBuilder sb){
     Stack<Character>ss=new Stack<>();
        int value=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='b'){
                if(!ss.isEmpty() && ss.peek()=='a'){
                    ss.pop();
                   value+=x;
                   continue;
                }
            }
            ss.push(c);
        }
        while(!ss.isEmpty()){
             sb.append(ss.pop());
        }
        return value;
    }
    public int helper2(StringBuilder sb,int x,int y){
     Stack<Character>ss=new Stack<>();
        int value=0;
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(c=='a'){
                if(!ss.isEmpty() && ss.peek()=='b'){
                    ss.pop();
                   value+=y;
                   continue;
                }
            }
            ss.push(c);
        }
        return value;
    }
     public int helper3(String s,int x,int y,StringBuilder sb){
     Stack<Character>ss=new Stack<>();
        int value=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='a'){
                if(!ss.isEmpty() && ss.peek()=='b'){
                    ss.pop();
                   value+=y;
                   continue;
                }
            }
            ss.push(c);
        }
        while(!ss.isEmpty()){
             sb.append(ss.pop());
        }
        return value;
    }
    public int helper4(StringBuilder sb,int x,int y){
     Stack<Character>ss=new Stack<>();
        int value=0;
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(c=='b'){
                if(!ss.isEmpty() && ss.peek()=='a'){
                    ss.pop();
                   value+=x;
                   continue;
                }
            }
            ss.push(c);
        }
        return value;
    }
}