class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer>ss=new Stack<>();
        
        int n=arr.length;
        int i=2*n-1;
        int nge[]=new int[n];
        while(i>=0){
            int curr=arr[i%n];
            while(!ss.isEmpty() && ss.peek()<=curr){
                ss.pop();
            }
            if(ss.isEmpty()){
                nge[i%n]=-1;
            }if(!ss.isEmpty()){
                nge[i%n]=ss.peek();
            }
            ss.push(curr);
            i--;
        }
        return nge;
    }
}