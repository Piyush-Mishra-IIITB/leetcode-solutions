class Solution {

    public int evalRPN(String[] arr) {

        Stack<Integer> ss = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            String c = arr[i];
            if(c.equals("+")){
                int a = ss.pop();
                int b = ss.pop();
                ss.push(b + a);
            }

            else if(c.equals("-")){
                int a = ss.pop();
                int b = ss.pop();
                ss.push(b - a);
            }

           else if(c.equals("*")){
               int a = ss.pop();
                int b = ss.pop();
                ss.push(b * a);
            }

            else if(c.equals("/")){
                int a = ss.pop();
                int b = ss.pop();
                ss.push(b / a);
            }

            else{
                ss.push(Integer.parseInt(c));
            }
        }

        return ss.pop();
    }
}