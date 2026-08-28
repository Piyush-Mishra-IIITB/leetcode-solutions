class Solution {
    public int maxArea(int[] arr) {
        int i=0;
        int j=arr.length-1;
       int op=0;
        while(i<j){
            int val1=arr[i];
            int val2=arr[j];
            if(val1>=val2){
                int water=val2*(j-i);
                op=Math.max(op,water);
                j--;
            }else{
                int water=val1*(j-i);
                op=Math.max(op,water);
                i++;
            }
        }
        return op;
    }
}