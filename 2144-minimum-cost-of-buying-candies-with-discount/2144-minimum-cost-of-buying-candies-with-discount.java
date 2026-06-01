class Solution {
    public int minimumCost(int[] arr) {
        Arrays.sort(arr);
        int sum=0;
        int a=0;
        for(int i=arr.length-1;i>=0;i--){
            a++;
            if(a!=3){
                sum+=arr[i];
            }
            
            if(a==3){
                a=0;
            }
        }
        return sum;
    }
}//8085924663