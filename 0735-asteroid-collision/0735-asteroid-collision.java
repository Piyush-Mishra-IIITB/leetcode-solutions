 class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> ss = new Stack<>();
       for(int i=0;i<arr.length;i++){
        int curr=arr[i];
        if(curr>0){
            ss.push(curr);
        }else{
            while(!ss.isEmpty()&& ss.peek()>0&& ss.peek()<Math.abs(curr)){
                ss.pop();  
            }
            if(!ss.isEmpty()&&ss.peek()==Math.abs(curr)){
                ss.pop();
                continue;
            }
            if(ss.isEmpty() || ss.peek()<0){
                ss.push(curr);
            }
            else if(ss.peek()>Math.abs(curr)){
                continue;
            }
        }
       }
       int ans[]=new int[ss.size()];
       for(int i=0;i<ss.size();i++){
        ans[i]=ss.get(i);
       }
       return ans;
    }
}
