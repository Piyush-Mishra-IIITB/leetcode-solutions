class Solution {
    public int calPoints(String[] operations) {
        Stack<String>ss=new Stack<>();
        for(int i=0;i<operations.length;i++){
           String curr=operations[i];
           if(!curr.equals("+") && !curr.equals("C") && !curr.equals("D")){
            ss.push(curr);
           }
           else if(curr.equals("+")){
              int first=Integer.parseInt(ss.pop());
              int second=Integer.parseInt(ss.pop());
              int third=first+second;
              ss.push(Integer.toString(second));
              ss.push(Integer.toString(first));
              ss.push(Integer.toString(third));
           }
           else if(curr.equals("D")){
              int first=Integer.parseInt(ss.pop());
              ss.push(Integer.toString(first));
              ss.push(Integer.toString(first*2));
           }else if(curr.equals("C")){
              ss.pop();
           }
        }
        int ans=0;
        while(!ss.isEmpty()){
            ans+=Integer.parseInt(ss.pop());
        }
        return ans;
    }
}