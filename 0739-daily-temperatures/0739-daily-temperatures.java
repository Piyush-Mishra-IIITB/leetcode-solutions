class Solution {
    public class pair{
        int val;
        int ind;
        public pair(int val,int ind){
            this.val=val;
            this.ind=ind;
        }
    }
    public int[] dailyTemperatures(int[] t) {
        Stack<pair>ss=new Stack<>();
        int ans[]=new int[t.length];
        for(int i=t.length-1;i>=0;i--){
             int curr=t[i];
            while(!ss.isEmpty() && ss.peek().val<=curr){
                System.out.println("del" + ss.peek().val + ss.peek().ind);
                ss.pop();
            }
            if(ss.isEmpty()){
                ans[i]=0;
            }else{
                ans[i]=ss.peek().ind-i;
            }
            ss.push(new pair(curr,i));
        }

        return ans;
    }
}