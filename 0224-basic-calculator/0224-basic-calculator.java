class Solution {
    public int calculate(String s) {
        Stack<Integer>ss=new Stack<>();
        int no=0;
        int result=0;
        int sign =1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!='+' && c!='-' && c!='(' && c!=')'&& c!=' '){
                no=no*10+(c-'0');
            }
            else if(c=='+'){
                result+=(no*sign);
                sign=1;
                no=0;
            }
            else if(c=='-'){
                result+=(no*sign);
                sign=-1;
                no=0;
            }
            else if(c=='('){
                ss.push(result);
                ss.push(sign);
                no=0;
                result=0;
                sign=1;
            }else if(c==')'){
                result+=(no*sign);
                no=0;
                int last_sign=ss.peek();ss.pop();
                int last_result=ss.peek();ss.pop();
                result=result*last_sign+last_result;
            }

        }
        return result+=no*sign;
    }
}