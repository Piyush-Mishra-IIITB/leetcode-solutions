class Solution {
    public boolean find132pattern(int[] arr) {
     int num3=Integer.MIN_VALUE;

     Stack<Integer>ss=new Stack<>();
     for(int i=arr.length-1;i>=0;i--){
        
        if(num3>arr[i]){
            return true;
        }
        while(!ss.isEmpty() && ss.peek()<arr[i]){
            num3=ss.peek();
            ss.pop();
        }
        ss.push(arr[i]);
     }
     return false;
    }  
}