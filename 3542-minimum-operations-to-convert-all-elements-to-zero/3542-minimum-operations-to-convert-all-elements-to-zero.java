class Solution {
    public int minOperations(int[] arr) {
        int ops=0;
        Stack<Integer>ss=new Stack<>();
        for(int i=0;i<arr.length;i++){

            int curr=arr[i];
            
            while(!ss.isEmpty()&& ss.peek()>curr){
                ss.pop();
            }
            if(curr==0){
                continue;
            }
            if(ss.isEmpty()||ss.peek()<curr){
                ss.push(curr);
                ops++;
            }
            
        }
        return ops;
    }
}